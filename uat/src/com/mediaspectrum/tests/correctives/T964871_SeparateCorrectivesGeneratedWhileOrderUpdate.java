package com.mediaspectrum.tests.correctives;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.SerializeHelper;
import com.qatestlab.utils.mail.MailHelper;
import com.qatestlab.utils.mail.MailMatcher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.Message;
import java.io.File;


/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Separate Correctives Generated w/ Order Update
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964871
 */

public class T964871_SeparateCorrectivesGeneratedWhileOrderUpdate extends BaseTest{

    private CustomerData customerData;
    private ProductData productData;
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
    public void selectCustomerTest(){

        customerData = SerializeHelper.deserializeObject(CustomerData.class, Constants.CUSTOMER_SERIALIZE_FILENAME);

        if(customerData == null){
            customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
            customerData.setCreditBlocked(false);
            customerData.setCreditLimit(Constants.DEFAULT_CUSTOMER_CREDIT_LIMIT);

            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void placeOrderTest(){

        productData = new ProductData();
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
    public void editOrderTest(){
        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());
        PartnersPages.scheduleAdvancedTab().selectProductSize("1/1");
        AdvancedOrderData advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }


    @Test(dependsOnMethods = "editOrderTest")
    public void checkCorrectivesGenerated(){

        Actions.advancedBookingActions().openOrderForEditing(advancedOrderData.getOrderID());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());
        PartnersPages.orderInformationTab().clickPriceManagmentTab();

        PartnersPages.priceManagementTab().clickShowCorrectivesLink(productData.getProductName());
        PartnersPages.priceManagementTab().switchToCorrectivesFrame();

        Assert.assertTrue(PartnersPages.priceManagementTab().isCorrectiveGenerated(),
                "Corrective is not generated!");
    }



}
