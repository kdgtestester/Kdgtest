package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Make a booking with an upsell product
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964391
 */
public class T964391_MakeBookingWithUpsellProduct extends BaseTest {

    AdvancedOrderData advancedOrderData;
    ProductData productData;
    ProductData upsellProduct;

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
        productData.setProductName("La Gruy%17010-00");
        productData.setProductUniqueId("17010");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(2);

        Actions.advancedBookingActions().addProductToShoppingCart(productData);

        upsellProduct = new ProductData("LocalPoint","1701007");

        Assert.assertTrue(PartnersPages.orderInformationTab().isProductInShoppingCart(upsellProduct.getProductName()),
                "Upsell product did not add to shopping cart");

        Assert.assertTrue(PartnersPages.orderInformationTab().getProductPrice(productData.getProductName()) > 0,
                String.format("Price for %s is not set.", productData.getProductName()));

        Assert.assertTrue(PartnersPages.orderInformationTab().getProductPrice(upsellProduct.getProductName()) > 0,
                String.format("Price for %s is not set.", upsellProduct.getProductName()));

    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void checkVoucherCheckboxTest() {
        PartnersPages.orderInformationTab().clickProductInShoppingCart(upsellProduct.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(upsellProduct.getProductUniqueId());
        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isVoucherCheckboxVisible(),
                "Voucher checkbox is visible for upsell product");
    }

    @Test(dependsOnMethods = "checkVoucherCheckboxTest")
    public void saveOrderWithoutSettingProductContentTest(){
        PartnersPages.orderInformationTab().clickSaveOrderButton();
        Assert.assertTrue(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Shopping cart does not contain errors");
    }

    @Test(dependsOnMethods = "checkVoucherCheckboxTest")
    public void setProductContentData(){

        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");
        PartnersPages.orderInformationTab().clickProductInShoppingCart(productData.getProductName());

        PartnersPages.scheduleAdvancedTab().selectProductContentType(productData.getProductContentType());
        PartnersPages.scheduleAdvancedTab().typeProductContentDescription(productData.getProductContentDescription());
        PartnersPages.orderInformationTab().waitProductAddToShoppingCart(productData.getProductName());
    }

    @Test(dependsOnMethods = "setProductContentData")
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
