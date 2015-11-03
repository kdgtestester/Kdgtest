package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BasePage;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.SerializeHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Make a booking for the 3/8 product
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964390
 */

public class T964390_MakeBookingFor8per3Product extends BaseTest{
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

        ProductData productData = new ProductData();
        productData.setProductName("Impartial Plus%10946-00");
        productData.setProductUniqueId("10946");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(2);

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("Impartial");
        subProduct1.setProductUniqueId("2800330");
        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendations");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductColor("Black/White");
        subProduct1.setProductSize("1/1");
        subProduct1.setProductDatesCount(2);
        subProduct1.setProductContentType("07 Without digital transmission");
        subProduct1.setProductContentDescription("Description");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("Courrier");
        subProduct2.setProductUniqueId("2802402");
        subProduct2.setProductAdType("Ads");
        subProduct2.setProductHeading("Recommendations");
        subProduct2.setProductSubHeading("Base");
        subProduct2.setProductColor("Black/White");
        subProduct2.setProductSize("1/1");
        subProduct2.setProductDatesCount(2);
        subProduct2.setProductContentType("07 Without digital transmission");
        subProduct2.setProductContentDescription("Description");

        productData.addSubProduct(subProduct1);
        productData.addSubProduct(subProduct2);

        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(productData);
        advancedOrderData.setOrderInformationData(orderInformationData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "orderProductCheck")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }
}
