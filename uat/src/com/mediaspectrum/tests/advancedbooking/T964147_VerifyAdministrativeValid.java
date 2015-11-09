package com.mediaspectrum.tests.advancedbooking;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify "Administrative" (valid)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964147
 */

public class T964147_VerifyAdministrativeValid extends BaseTest{

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
        advancedOrderData = new AdvancedOrderData();

        CustomerData customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        Address subAddress = DataFactory.generateDefaultAddress();
        subAddress.setAddressType("Order Confirmation");
        customerData.setSubAddresses(new ArrayList<>(Arrays.asList(subAddress)));
        Actions.partnerActions().createCustomer(customerData);
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());

        advancedOrderData.setCustomerData(customerData);
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void addProductToShoppingCart(){

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

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
    }

    @Test(dependsOnMethods = "addProductToShoppingCart")
    public void changeAddressTest(){
        PartnersPages.orderInformationTab().clickAdministrativeButton();
        PartnersPages.orderInformationTab().selectProposalAddress(advancedOrderData.getCustomerData().getSubAddresses().get(0));
        PartnersPages.orderInformationTab().clickApllyAdministrativeButton();
    }

    @Test(dependsOnMethods = "changeAddressTest")
    public void doOrderTest(){
        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(orderInformationData);
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "doOrderTest")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

}
