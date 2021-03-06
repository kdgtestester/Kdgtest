package com.mediaspectrum.tests.advancedbooking;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.SerializeHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class T964388_AddSurchargeManually extends BaseTest{
    /**
     * @author Kostia Zavgorodniy
     * Email: konstantin.zavgorodniy@testmatick.com
     * Test Name: Advanced booking - Add a surcharge manually
     * https://mediaspectrum.testrail.net/index.php?/tests/view/964388
     */

    private AdvancedOrderData advancedOrderData;
    private CustomerData customerData;
    private ProductData productData;
    private OrderInformationData orderInformationData;

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
            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void orderProductCheck(){
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


        orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(productData);
        advancedOrderData.setOrderInformationData(orderInformationData);

        SurchargesData surchargesData = new SurchargesData();
        surchargesData.setSurchargeName("Surcharge");
        surchargesData.setRatesData(DataFactory.generateRateData("80"));

        advancedOrderData.setSurchargesData(surchargesData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);

    }

    @Test(dependsOnMethods = "orderProductCheck")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());

    }
}
