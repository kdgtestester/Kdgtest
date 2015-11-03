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
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify pricing for the dates for 8.2 package
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964530
 */

public class T964530_VerifyPricingForDatesFor8Per2Package extends BaseTest {
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
        productData.setProductName("Top Vorarlberg%33011-00");
        productData.setProductUniqueId("33011");

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("Vorarlberger Nachrichten Kombi");
        subProduct1.setProductUniqueId("33008");
        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendation");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductBleed("None");
        subProduct1.setProductClientType("Standard");
        subProduct1.setProductColor("Black/White");
        subProduct1.setProductSize("1 column");
        subProduct1.setProductSizeHeight("50");
        subProduct1.setProductDatesCount(2);
        subProduct1.setProductContentType("06 Produced by publisher");
        subProduct1.setProductContentLanguage("Italian");
        subProduct1.setProductContentDescription("Description");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("N. Vorarlb. Tageszeitung Kombi");
        subProduct2.setProductUniqueId("33010");
        subProduct2.setProductAdType("Ads");
        subProduct2.setProductHeading("Erotic");
        subProduct2.setProductSubHeading("Base");
        subProduct2.setProductBleed("None");
        subProduct2.setProductSize("Lines");
        subProduct2.setProductSizeLinesCount("6");
        subProduct2.setProductColor("Black/White");
        subProduct2.setProductDatesCount(2);
        subProduct2.setProductContentType("06 Produced by publisher");
        subProduct2.setProductContentLanguage("Italian");
        subProduct2.setProductContentDescription("Description");

        productData.addSubProduct(subProduct1);
        productData.addSubProduct(subProduct2);

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void saveOrderTest(){

        PartnersPages.orderInformationTab().clickSaveOrderButton();
        PartnersPages.orderInformationTab().assertTotalPricePresent();
    }

    @Test(dependsOnMethods = "saveOrderTest")
    public void checkOrderInformationForChildPricesTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        for(ProductData subProduct : productData.getSubProducts()){
            for(String baseCharges : PartnersPages.priceManagementTab().getBaseChargeValues(subProduct.getProductName())){
                Assert.assertFalse(baseCharges.isEmpty(), "Base charge is not calculated for : " + subProduct.getProductName());
            }
        }
    }

    @Test(dependsOnMethods = "checkOrderInformationForChildPricesTest")
    public void changeChildProductsOrderDataTest(){

        PartnersPages.priceManagementTab().clickOrderInformationTab();

        PartnersPages.orderInformationTab().clickProductInShoppingCart(productData.getSubProducts().get(1).getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getSubProducts().get(1).getProductUniqueId());

        PartnersPages.scheduleAdvancedTab().selectProductClientType("1 Zeile fett, restl. Z. normal");
        PartnersPages.orderInformationTab().waitProductAddToShoppingCart(productData.getProductName());

    }

    @Test(dependsOnMethods = "checkOrderInformationForChildPricesTest")
    public void saveOrderAfterChangesTest(){

        PartnersPages.orderInformationTab().clickSaveOrderButton();
        PartnersPages.orderInformationTab().assertTotalPricePresent();
    }

    @Test(dependsOnMethods = "saveOrderAfterChangesTest")
    public void checkOrderInformationForChildPricesAfterChangeTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        for(ProductData subProduct : productData.getSubProducts()){

            List<String> baseCharges = PartnersPages.priceManagementTab().getBaseChargeValues(subProduct.getProductName());
            Assert.assertEquals(baseCharges.size(), subProduct.getProductDatesCount(),
                    "Incorrect number of date insertions!");

            for(String baseCharge : baseCharges){
                Assert.assertFalse(baseCharge.isEmpty(), "Base charge is not calculated for : " + subProduct.getProductName());
            }
        }
    }


}
