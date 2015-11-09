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

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Add a surcharge with the limit (mm)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964187
 */

public class T964187_AddSurchargeWithTheLimit extends BaseTest{

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
    public void addProductToOrder(){
        productData = new ProductData();
        productData.setProductName("Il Mattino della Domenica");
        productData.setProductUniqueId("24206");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("B/W + 3 colors");
        productData.setProductPrescriptionSize("Full material");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToOrder")
    public void checkSurchargeTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        Assert.assertEquals(PartnersPages.priceManagementTab().getAppliedSurchargeAmount(
                "In color", productData.getProductName()), "100 In amount CHF 100.00","Incorrect surcharge amount");
    }

    @Test(dependsOnMethods = "checkSurchargeTest")
    public void changeProductOrderDataTest(){
        PartnersPages.priceManagementTab().clickOrderInformationTab();
        PartnersPages.orderInformationTab().clickProductInShoppingCart(productData.getProductName());
        PartnersPages.scheduleAdvancedTab().waitForProductPageLoad(productData.getProductUniqueId());

        productData.setProductSize("10 columns");
        productData.setProductSizeHeight("80");

        Actions.advancedBookingActions().setProductData(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "changeProductOrderDataTest")
    public void testCheckUpdatedSurchargeTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        Assert.assertEquals("200 In amount CHF 200.00", PartnersPages.priceManagementTab().getAppliedSurchargeAmount(
                "In color", productData.getProductName()),"Incorrect surcharge amount");
    }
}
