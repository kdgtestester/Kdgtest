package com.mediaspectrum.tests.correctives;

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
 * Test Name: Publisher statement - Leased product Exception Surcharge
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/965533
 */

public class T965533_LeasedProductExceptionSurcharge extends BaseTest{

    private ProductData productData;
    private final String surchargesNeme = "Surcharge rate";

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
            customerData.setCreditBlocked(false);
            customerData.setCreditLimit(Constants.DEFAULT_CUSTOMER_CREDIT_LIMIT);

            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void addProductToShoppingCartTest(){

        productData = new ProductData();
        productData.setProductName("Impartial%28003-00");
        productData.setProductUniqueId("28003");
        productData.setProductAdType("Inserts");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductRateType("National");
        productData.setProductColor("Black/White");
        productData.setProductSize("25 grams");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void addSurchargeTest(){

        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();
        PartnersPages.priceManagementTab().clickSurchargeButton();

        PartnersPages.priceManagementTab().appliySurcharge(surchargesNeme);

        Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargeApplied(surchargesNeme),
                "Surcharge is not applied");

        PartnersPages.priceManagementTab().clickSaveSurchargeSettingsButton();
        PartnersPages.priceManagementTab().clickCloseSurchargeDialogButton();

    }

    @Test(dependsOnMethods = "addSurchargeTest")
    public void verifySurchargeAppliedCorrectTest(){
        Assert.assertEquals("CHF 1,207.80", PartnersPages.priceManagementTab().getSurchargeAmount(productData.getProductName()),
                "Incorrect surcharge amount value on advertiser view!");
        PartnersPages.priceManagementTab().selectViewAs("Publisher");

        Assert.assertEquals("84 %", PartnersPages.priceManagementTab().
                getAppliedSurchargeAmount(surchargesNeme, productData.getProductName()),
                "Surcharge discount is incorrect");

        Assert.assertEquals("CHF -1,014.55", PartnersPages.priceManagementTab().getSurchargeAmount(productData.getProductName()),
                "Incorrect surcharge amount value on publisher view!");
    }








}
