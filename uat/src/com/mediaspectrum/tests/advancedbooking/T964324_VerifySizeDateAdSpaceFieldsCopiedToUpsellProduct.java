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
 * Test Name: Verify that "Size", "Dates" and "AdSpace" Fields Care copied to Upsell Product
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964324
 */

public class T964324_VerifySizeDateAdSpaceFieldsCopiedToUpsellProduct extends BaseTest{
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
        productData.setProductSubHeading("Im Schaufenster");
        productData.setProductColor("Black/White");
        productData.setProductSize("1 field");
        productData.setProductDatesCount(1);
        productData.setProductPrescriptionSize("Full material");
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);

        upsellProduct = new ProductData("LocalPoint","1701007");
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void checkDateCopiedToUpsellProductTest(){

        PartnersPages.orderInformationTab().clickProductInShoppingCart(productData.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        String selectedDate = PartnersPages.scheduleAdvancedTab().getSetDate();
        PartnersPages.orderInformationTab().clickProductInShoppingCart(upsellProduct.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(upsellProduct.getProductUniqueId());
        Assert.assertEquals(selectedDate, PartnersPages.scheduleAdvancedTab().getSetDate(),
                "Date is not copied to upsell product");
    }

    @Test(dependsOnMethods = "checkDateCopiedToUpsellProductTest")
    public void checkAsSpaceCopiedToUpsellProductTest(){
        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isProductTypeSelectorAvailable(),
                "Product ad type selector is available");

        Assert.assertEquals(productData.getProductAdType(), PartnersPages.scheduleAdvancedTab().getProductTypeSelectedValue(),
                "Product ad type is not copied to upsell product");

        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isProductHeadingSelectorAvailable(),
                "Product heading selector is available");

        Assert.assertEquals(productData.getProductHeading(), PartnersPages.scheduleAdvancedTab().getProductHeadingSelectedValue(),
                "Product heading is not copied to upsell product");

        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isProductSubHeadingSelectorAvailable(),
                "Product sub heading selector is available");

        Assert.assertEquals(productData.getProductSubHeading().toLowerCase(),
                PartnersPages.scheduleAdvancedTab().getProductSubHeadingSelectedValue().toLowerCase(),
                "Product sub heading is not copied to upsell product");
    }

    @Test(dependsOnMethods = "checkAsSpaceCopiedToUpsellProductTest")
    public void checkSizeCopiedToUpsellProductTest() {

        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isProductSizeSelectorAvailable(),
                "Product size selector is available");

        Assert.assertTrue(PartnersPages.scheduleAdvancedTab().getProductSizeSelectedValue().contains(productData.getProductSize()),
                "Product heading is not copied to upsell product");
    }

    @Test(dependsOnMethods = "checkSizeCopiedToUpsellProductTest")
    public void checkPrescriptionSizeCopiedToUpsellProduct() {
        Assert.assertFalse(PartnersPages.scheduleAdvancedTab().isProductPrescriptionSizeSelectorAvailable(),
                "Product prescription size selector is available");

        Assert.assertEquals(productData.getProductPrescriptionSize(), PartnersPages.scheduleAdvancedTab().getProductPrescriptionSizeSelectedValue(),
                "Product prescription size is not copied to upsell product");
    }



    @Test(dependsOnMethods = "checkPrescriptionSizeCopiedToUpsellProduct")
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