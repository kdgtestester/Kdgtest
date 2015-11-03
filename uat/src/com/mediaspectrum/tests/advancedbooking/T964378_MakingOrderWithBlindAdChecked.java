package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.mediaspectrum.utils.ProductData;
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
 * Test Name: Advanced booking - Making an order with "Blind Ad" checked
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964378
 */
public class T964378_MakingOrderWithBlindAdChecked extends BaseTest{

    ProductData productData;

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
        productData.setProductName("Le Messager%17013-00");
        productData.setProductUniqueId("17013");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1 column");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(2);
        productData.setProductContentType("08 Input by profit center");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void splitProductTest(){
        Actions.advancedBookingActions().splitShoppingCartProductByContent(productData);

        Assert.assertEquals(2, PartnersPages.orderInformationTab().getShoppingCartProductsCount(productData.getProductName()),
                "Product did not split");
    }

    @Test(dependsOnMethods = "splitProductTest")
    public void checkBlindAdCheckboxAndSaveOrderTest(){

        PartnersPages.orderInformationTab().clickProductInShoppingCart(1, productData.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        PartnersPages.scheduleAdvancedTab().clickBlindAdCheckbox();


        ProductData service = new ProductData();
        service.setProductName("Blind ad");
        service.setProductUniqueId("00");

        PartnersPages.scheduleAdvancedTab().clickAddNewProductToOrder();

        Actions.advancedBookingActions().addProductToShoppingCart(service);

        PartnersPages.orderInformationTab().selectInternalProvenance(Constants.DEFAULT_INTERNAL_PROVENANCE);
        PartnersPages.orderInformationTab().selectPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);


        PartnersPages.orderInformationTab().clickSaveOrderButton();

        Assert.assertFalse(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Order contains errors");
    }
    
    @Test(dependsOnMethods = "checkBlindAdCheckboxAndSaveOrderTest")
    public void uncheckBlindAdCheckboxAndSaveOrderTest(){

        PartnersPages.orderInformationTab().clickProductInShoppingCart(1, productData.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        PartnersPages.scheduleAdvancedTab().clickBlindAdCheckbox();

        PartnersPages.orderInformationTab().clickSaveOrderButton();

        Assert.assertFalse(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Order contains errors");
    }

    @Test(dependsOnMethods = "uncheckBlindAdCheckboxAndSaveOrderTest")
    public void checkBlindAdCheckboxAndSaveOrderForAnotherProductTest(){

        PartnersPages.orderInformationTab().clickProductInShoppingCart(2
                , productData.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        PartnersPages.scheduleAdvancedTab().clickBlindAdCheckbox();

        PartnersPages.orderInformationTab().clickSaveOrderButton();

        Assert.assertFalse(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Order contains errors");
    }



}
