package com.mediaspectrum.tests.correctives;

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
import java.util.Calendar;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: "Correctives" form (contract INTERMEDIATE adjustment)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964928
 */

public class T964928_CorrectivesFormContractIntermediateAdjustment extends BaseTest{
    private CustomerData customerData;
    private ProductData productData;
    private ContractData contractData;
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
    public void placeOrderTest(){

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

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        advancedOrderData.setCustomerData(customerData);
        advancedOrderData.setProduct(productData);

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
    public void makeContractIntermediateAdjustmentTest(){
        contractData.setIsAdjustmentTypeFinal(false);
        contractData.setDiscountLevel("9.0 %");
        Actions.advancedBookingActions().addContractAdjustment(contractData);
    }


    @Test(dependsOnMethods = "makeContractIntermediateAdjustmentTest")
    public void checkAdjustmentAppliedTest(){
        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        Assert.assertEquals(contractData.getDiscountLevel().substring(0, 1),
                PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName()).get(0),
                "Contract adjustment is not applied!");
    }

    @Test(dependsOnMethods = "checkAdjustmentAppliedTest")
    public void placeOrderAgainTest(){
        PartnersPages.priceManagementTab().clickOrderInformationTab();
        AdvancedOrderData advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "placeOrderAgainTest")
    public void openPlacedOrderTest() {
        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
    }

    @Test(dependsOnMethods = "openPlacedOrderTest")
    public void verifyCorrectivesTest(){
        PartnersPages.priceManagementTab().clickShowCorrectivesLink(productData.getProductName());
        PartnersPages.priceManagementTab().switchToCorrectivesFrame();
        PartnersPages.priceManagementTab().expandCorrectiveItem();

        Assert.assertFalse(PartnersPages.priceManagementTab().getCorrectiveOldPriceDiscountValue().isEmpty(),
                "Old price discount value is not shown");

        Assert.assertFalse(PartnersPages.priceManagementTab().getCorrectiveNewPriceDiscountValue().isEmpty(),
                "New price discount value is not shown");

        Assert.assertFalse(PartnersPages.priceManagementTab().getCorrectiveOldAmountDiscountValue().isEmpty(),
                "Old amount discount value is not shown");

        Assert.assertFalse(PartnersPages.priceManagementTab().getCorrectiveNewAmountDiscountValue().isEmpty(),
                "New amount discount value is not shown");

        Assert.assertFalse(PartnersPages.priceManagementTab().getCorrectiveDiffAmountDiscountValue().isEmpty(),
                "Amount discount difference value is not shown");
    }



}
