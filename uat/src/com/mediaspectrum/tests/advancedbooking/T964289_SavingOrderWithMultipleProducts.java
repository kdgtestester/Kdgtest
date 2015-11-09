package com.mediaspectrum.tests.advancedbooking;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.SerializeHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Saving order with multiple products
 * Tast Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964289
 */

public class T964289_SavingOrderWithMultipleProducts extends BaseTest{

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

        CustomerData customerData = SerializeHelper.deserializeObject(CustomerData.class, Constants.CUSTOMER_SERIALIZE_FILENAME);

        if(customerData == null){
            customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void orderProductCheck(){
        ProductData productData2 = new ProductData();
        productData2.setProductName("Impartial%28003-00");
        productData2.setProductUniqueId("28003");
        productData2.setProductAdType("Ads");
        productData2.setProductHeading("Recommendations");
        productData2.setProductSubHeading("Base");
        productData2.setProductColor("Black/White");
        productData2.setProductSize("1/1");
        productData2.setProductDatesCount(2);
        productData2.setProductContentType("07 Without digital transmission");
        productData2.setProductContentDescription("Description");

        ProductData productData1 = new ProductData();
        productData1.setProductName("DUO%11292-00");
        productData1.setProductUniqueId("11292");
        productData1.setProductAdType("Ads");
        productData1.setProductHeading("Recommendations");
        productData1.setProductSubHeading("Base");
        productData1.setProductColor("Black/White");
        productData1.setProductSize("1/1");
        productData1.setProductDatesCount(2);
        productData1.setProductContentType("07 Without digital transmission");
        productData1.setProductContentDescription("Description");

        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(productData1);
        advancedOrderData.setProduct(productData2);
        advancedOrderData.setOrderInformationData(orderInformationData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "orderProductCheck")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }


}
