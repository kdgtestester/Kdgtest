package com.mediaspectrum.tests.billing;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Billing - Transactions - Verify manual invoicing of an order with agency billing address
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/965342
 */

public class T965342_VerifyManuaInvoicingOfOrderWithAgencyBillingAddress extends BaseTest {

    private AdvancedOrderData advancedOrderData;
    private CustomerData customerData;

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
        customerData.setCustomerID("10-2011106");
        Actions.partnerActions().searchPartnerByID(customerData.getCustomerID());
        PartnersPages.partnersPage().clickAdvancedBookingLink();
        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
    }

    @Test(dependsOnMethods = "createCustomerTest")
    public void addProductToShoppingCartTest(){
        ProductData productData = new ProductData();
        productData.setProductName("Zeitung Schweizer Ausgabe");
        productData.setProductUniqueId("44264");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);

        PartnersPages.orderInformationTab().selectPrimatyAgency("TESTCASE AGENCY 54");
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void changeBillingAddressTest(){
        PartnersPages.orderInformationTab().clickAdministrativeButton();
        PartnersPages.orderInformationTab().selectBillingAddress("Mölbach, 223");
        PartnersPages.orderInformationTab().clickApllyAdministrativeButton();
    }

    @Test(dependsOnMethods = "changeBillingAddressTest")
    public void doOrderTest(){
        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setCustomerData(customerData);
        advancedOrderData.setOrderInformationData(new OrderInformationData());
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "doOrderTest")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

    @Test(dependsOnMethods = "checkOrderSuccessful")
    public void makeInvoiceTest(){
        Actions.advancedBookingActions().invoiceOrder(advancedOrderData);
    }





}
