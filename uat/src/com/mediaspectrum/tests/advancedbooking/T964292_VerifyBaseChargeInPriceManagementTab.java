package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify "Base charge" in "Price management" tab
 * Tast Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964292
 */
public class T964292_VerifyBaseChargeInPriceManagementTab extends BaseTest{

    private ProductData productData;

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
    public void addProductToShoppingCartTest(){
        productData = new ProductData();
        productData.setProductName("Badische Zeitung%03011-00");
        productData.setProductUniqueId("3011");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Jobs");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(3);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void checkBaseChargeTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();

        List<String> baseCharges = PartnersPages.priceManagementTab().getBaseChargeValues(productData.getProductName());
        for(String baseCharge : baseCharges){
            Assert.assertTrue(baseCharge.equals("8.88 Per unit") || baseCharge.equals("8.23 Per unit"),
                    "Incorrect base charge : " + baseCharge);
        }

        PartnersPages.priceManagementTab().clickOrderInformationTab();
    }


    @Test(dependsOnMethods = "checkBaseChargeTest")
    public void doOrderTest(){

        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        AdvancedOrderData advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(orderInformationData);



        Actions.advancedBookingActions().doOrder(advancedOrderData);
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }
}
