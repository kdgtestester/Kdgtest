package com.mediaspectrum.tests.billing;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.AdvancedOrderData;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.OrderInformationData;
import com.mediaspectrum.utils.ProductData;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Billing - Verify, that "Invoices" view checks AREXCEPTIONS table
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/965287
 */

public class T965287_VerifyInvoicesViewChecksArexceptionsTable extends BaseTest {

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
    public void selectCustomerTest(){

        customerData = new CustomerData();
        customerData.setCustomerID("10-2006699");
        Actions.partnerActions().searchPartnerByID(customerData.getCustomerID());
        PartnersPages.partnersPage().clickAdvancedBookingLink();
        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();

    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void orderProductCheck(){

        ProductData productData = new ProductData();
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderAgency("TESTCASE AGENCY 51");

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(productData);
        advancedOrderData.setOrderInformationData(orderInformationData);

        advancedOrderData.setCustomerData(customerData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "orderProductCheck")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

    @Test(dependsOnMethods = "checkOrderSuccessful")
    public void makeInvoiceTest(){
        Actions.advancedBookingActions().invoiceOrder(advancedOrderData);
    }





}
