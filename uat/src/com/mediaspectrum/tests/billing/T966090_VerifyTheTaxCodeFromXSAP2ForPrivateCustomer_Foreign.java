package com.mediaspectrum.tests.billing;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.AdvancedOrderData;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.OrderInformationData;
import com.mediaspectrum.utils.ProductData;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.XMLParser;
import com.testmatick.utils.mail.MailHelper;
import com.testmatick.utils.mail.MailMatcher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.Message;
import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Verify the taxCode from XSAP2 for private customer (foreign)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/966090
 */

public class T966090_VerifyTheTaxCodeFromXSAP2ForPrivateCustomer_Foreign extends BaseTest{

    private AdvancedOrderData advancedOrderData;
    private CustomerData customerData;
    private String invoiceNumber;

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
    public void createCustomerTest(){
        customerData = new CustomerData();
        customerData.setCustomerID("10-2010677");
        Actions.partnerActions().searchPartnerByID(customerData.getCustomerID());
        PartnersPages.partnersPage().clickAdvancedBookingLink();
        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
    }

    @Test(dependsOnMethods = "createCustomerTest")
    public void doOrderTest(){
        ProductData productData = new ProductData();
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
        advancedOrderData.setCustomerData(customerData);
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        advancedOrderData.setProduct(productData);
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }


    @Test(dependsOnMethods = "doOrderTest")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

    @Test(dependsOnMethods = "checkOrderSuccessful")
    public void makeInvoiceTest(){
        invoiceNumber = Actions.advancedBookingActions().invoiceOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "makeInvoiceTest")
    public void verifyMailTest(){
        MailMatcher mailMatcher = new MailMatcher();
        mailMatcher.setMailSubject(Constants.DEFAULT_INVOICE_MAIL_SUBJECT);
        mailMatcher.setMailContentUniqueValue(invoiceNumber);
        Message message = MailHelper.waitForEmail(Constants.DEFAULT_MAIL_LOGIN, Constants.DEFAULT_MAIL_PASSWORD, mailMatcher, Constants.DEFAULT_MAIL_FOLDER);

        Assert.assertTrue(MailHelper.isMailHasAttachments(message), "Attachment is not added to email!");

        for(String taxCode : XMLParser.getNodeValue("taxCode", MailHelper.getMailAttachment(message))){
            Assert.assertEquals(taxCode, "DE", "Incorrect tax code in invoice.xml");
        }
    }
}
