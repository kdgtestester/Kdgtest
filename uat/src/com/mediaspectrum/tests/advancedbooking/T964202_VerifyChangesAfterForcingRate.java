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

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Verify changes after forcing Rate
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964202
 */

public class T964202_VerifyChangesAfterForcingRate extends BaseTest{
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
    public void doOrderWithForcingRate(){

        productData = new ProductData();
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("2200");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(productData);
        advancedOrderData.setOrderInformationData(orderInformationData);
        advancedOrderData.setRatesData(DataFactory.generateRateData("8000"));

        Actions.advancedBookingActions().doOrder(advancedOrderData);

    }

    @Test(dependsOnMethods = "doOrderWithForcingRate")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }
}
