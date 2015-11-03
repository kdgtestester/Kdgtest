package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced Booking - Verify that "Product Name" is shown in Dashboard when booking 8/2 product with prescription
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/966071
 */

public class T966071_VerifyProductNameIsShownInDashboardWhenBooking8per2ProductWithPrescription extends BaseTest {

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
        productData.setProductName("RomandieMAX Family");
        productData.setProductUniqueId("22606");

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("TV 8");
        subProduct1.setProductUniqueId("18410");
        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendations");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductColor("3 colors");
        subProduct1.setProductSize("1/1");
        subProduct1.setProductDatesCount(1);
        subProduct1.setProductContentType("07 Without digital transmission");
        subProduct1.setProductContentDescription("Description");
        subProduct1.setProductPrescriptionGroup("Color");
        subProduct1.setProductPrescription("04 - Color");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("Illustr");
        subProduct2.setProductUniqueId("29404");
        subProduct2.setProductAdType("Ads");
        subProduct2.setProductHeading("Recommendations");
        subProduct2.setProductSubHeading("Base");
        subProduct2.setProductColor("3 colors");
        subProduct2.setProductSize("1/1");
        subProduct2.setProductDatesCount(1);
        subProduct2.setProductContentType("07 Without digital transmission");
        subProduct2.setProductContentDescription("Description");
        subProduct2.setProductPrescriptionGroup("Color");
        subProduct2.setProductPrescription("04 - Color");

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
        Pages.dashboardPage().clickOrderById(advancedOrderData.getOrderID());

        for(ProductData product : advancedOrderData.getProducts()){
            Assert.assertTrue(Pages.dashboardPage().isProductDisplayedInOrderInfo(product.getProductName()),
                    String.format("Product %s is not present in shopping cart", product.getProductName()));
        }


    }
}
