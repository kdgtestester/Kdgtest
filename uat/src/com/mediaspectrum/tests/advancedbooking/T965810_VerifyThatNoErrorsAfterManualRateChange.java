package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.actions.AdvancedBookingActions;
import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.Random;
import com.qatestlab.utils.mail.MailHelper;
import com.qatestlab.utils.mail.MailMatcher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Verify that there are NO errors after manual rate change
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/T965810
 */

public class T965810_VerifyThatNoErrorsAfterManualRateChange extends BaseTest{

    private CustomerData customerData;
    private ProductData productData;
    private ContractData contractData;
    private List<SurchargesData> surcharges;
    private AdvancedOrderData advancedOrderData;

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String login, String password) {
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createPartnerTest(){

        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        customerData.setCreditBlocked(false);
        customerData.setCreditLimit(Constants.DEFAULT_CUSTOMER_CREDIT_LIMIT);

        Actions.partnerActions().createCustomer(customerData);
    }

    @Test(dependsOnMethods = "createPartnerTest")
    public void createContractTest(){

        productData = new ProductData();
        productData.setProductName("Le Matin");
        productData.setProductUniqueId("22002-00");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("10.0 %");

        Actions.mainPageActions().createApproveContract(contractData);
    }

    @Test(dependsOnMethods = "createContractTest")
    public void goToAdvancedBookingTest(){
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "goToAdvancedBookingTest")
    public void addProductToShoppingCartAndSaveItTest(){

        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartAndSaveItTest")
    public void checkContractDiscountTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();
        PartnersPages.priceManagementTab().clickProductCheckbox(productData.getProductName() + " " + productData.getProductUniqueId());
        PartnersPages.priceManagementTab().clickRateButton();

        PartnersPages.priceManagementTab().selectAllProducts();

        Assert.assertEquals(contractData.getAssignmentName(), PartnersPages.priceManagementTab().getDiscountContractName());

        Assert.assertEquals(contractData.getDiscountLevel().substring(0, 2), PartnersPages.priceManagementTab().getContractDiscountValue(),
                "Incorrect discount value!");

        PartnersPages.priceManagementTab().clickCloseChangeRateDialog();
    }

    @Test(dependsOnMethods = "checkContractDiscountTest")
    public void addSurchargesTest(){
        surcharges = new ArrayList<>();
        surcharges.add(new SurchargesData("Discount Media package gross", DataFactory.generateRateData("0.1")));
        surcharges.add(new SurchargesData("Discount Media package net", DataFactory.generateRateData("0.2")));

        Actions.advancedBookingActions().addSurcharges(surcharges);
    }

    @Test(dependsOnMethods = "addSurchargesTest")
    public void placeOrderTest(){
        PartnersPages.priceManagementTab().clickOrderInformationTab();
        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        advancedOrderData.setCustomerData(customerData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "placeOrderTest")
    public void checkOrderPlacedTest(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

    @Test(dependsOnMethods = "checkOrderPlacedTest")
    public void invoiceOrderTest(){
        String invoiceNumber = Actions.advancedBookingActions().invoiceOrder(advancedOrderData);

        MailMatcher mailMatcher = new MailMatcher();
        mailMatcher.setMailSubject(Constants.DEFAULT_INVOICE_MAIL_SUBJECT);
        mailMatcher.setMailContentUniqueValue(invoiceNumber);
        Message message = MailHelper.waitForEmail(Constants.DEFAULT_MAIL_LOGIN, Constants.DEFAULT_MAIL_PASSWORD, mailMatcher, Constants.DEFAULT_MAIL_FOLDER);

        Assert.assertTrue(MailHelper.isMailHasAttachments(message), "Attachment is not added to email!");
    }

    @Test(dependsOnMethods = "invoiceOrderTest")
    public void editOrderTest(){
        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        PartnersPages.scheduleAdvancedTab().addDatesRandomly(1);
        advancedOrderData.getOrderInformationData().setOrderPaymentMethod(null);
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "editOrderTest")
    public void makeContractIntermediateAdjustmentTest(){
        contractData.setIsAdjustmentTypeFinal(false);
        contractData.setDiscountLevel("9.0 %");
        Actions.advancedBookingActions().addContractAdjustment(contractData);
    }

    @Test(dependsOnMethods = "makeContractIntermediateAdjustmentTest")
    public void invoiceCorrectivesTest(){
        String invoiceNumber = Actions.advancedBookingActions().invoiceOrder(advancedOrderData);

        MailMatcher mailMatcher = new MailMatcher();
        mailMatcher.setMailSubject(Constants.DEFAULT_INVOICE_MAIL_SUBJECT);
        mailMatcher.setMailContentUniqueValue(invoiceNumber);
        Message message = MailHelper.waitForEmail(Constants.DEFAULT_MAIL_LOGIN, Constants.DEFAULT_MAIL_PASSWORD, mailMatcher, Constants.DEFAULT_MAIL_FOLDER);

        Assert.assertTrue(MailHelper.isMailHasAttachments(message), "Attachment is not added to email!");
    }

    @Test(dependsOnMethods = "invoiceCorrectivesTest")
    public void changeOrderRateTest(){
        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        Actions.advancedBookingActions().changeRate(DataFactory.generateRateData("1"));

        PartnersPages.priceManagementTab().clickOrderInformationTab();

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }


    @Test(dependsOnMethods = "changeOrderRateTest")
    public void invoiceOrderAfterForcingRateTest(){
        String invoiceNumber = Actions.advancedBookingActions().invoiceOrder(advancedOrderData);

        MailMatcher mailMatcher = new MailMatcher();
        mailMatcher.setMailSubject(Constants.DEFAULT_INVOICE_MAIL_SUBJECT);
        mailMatcher.setMailContentUniqueValue(invoiceNumber);
        Message message = MailHelper.waitForEmail(Constants.DEFAULT_MAIL_LOGIN, Constants.DEFAULT_MAIL_PASSWORD, mailMatcher, Constants.DEFAULT_MAIL_FOLDER);

        Assert.assertTrue(MailHelper.isMailHasAttachments(message), "Attachment is not added to email!");
    }
}
