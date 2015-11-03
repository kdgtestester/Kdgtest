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
 * Test Name: Verify rules for "Free" checkbox and dropdown in "Rate" window
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/965195
 */

public class T965195_VerifyRulesForFreeCheckboxAndDropdownInRateWindow extends BaseTest {
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
        productData.setProductName("Le Temps%00634-00");
        productData.setProductUniqueId("634");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(2);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void goPriceManagementTab(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();
    }

    @Test(dependsOnMethods = "goPriceManagementTab")
    public void checkFreeDropdownRuleTest(){
        PartnersPages.priceManagementTab().clickRateButton();
        PartnersPages.priceManagementTab().selectAllProducts();
        PartnersPages.priceManagementTab().selectRateType("Free");

        Assert.assertFalse(PartnersPages.priceManagementTab().isRateInputEnable(),
                "Rate input field is enable");
        Assert.assertEquals("0", PartnersPages.priceManagementTab().getRateInputValue(),
                "Rate value is not nulled");

        PartnersPages.priceManagementTab().clickCloseChangeRateDialog();
    }

    @Test(dependsOnMethods = "checkFreeDropdownRuleTest")
    public void checkFreeCheckboxTest(){

        PartnersPages.priceManagementTab().clickRateButton();
        PartnersPages.priceManagementTab().selectAllProducts();

        String rateBeforeAction = PartnersPages.priceManagementTab().getRateInputValue();
        String rateTypeBeforeAction = PartnersPages.priceManagementTab().getRateTypeValue();

        PartnersPages.priceManagementTab().clickFreeCheckbox();

        Assert.assertTrue(PartnersPages.priceManagementTab().isRateInputEnable(),
                "Rate input field became disabled");

        Assert.assertEquals(rateBeforeAction, PartnersPages.priceManagementTab().getRateInputValue(),
                "Rate value has been changed");

        Assert.assertTrue(PartnersPages.priceManagementTab().isRateTypeSelectorEnabled(),
                "Rate type selector field became disabled");

        Assert.assertEquals(rateTypeBeforeAction, PartnersPages.priceManagementTab().getRateTypeValue(),
                "Rate type value has been changed");

        RatesData ratesData = DataFactory.generateRateData("");
        PartnersPages.priceManagementTab().selectChangingRateReason(ratesData.getChangingRateReason());
        PartnersPages.priceManagementTab().selectChangingRateDetails(ratesData.getChangingRateDetails());

        PartnersPages.priceManagementTab().clickSaveChangesButton();
        PartnersPages.priceManagementTab().clickCloseChangeRateDialog();
    }

    @Test(dependsOnMethods = "checkFreeCheckboxTest")
    public void checkRateInputFieldEnable(){
        PartnersPages.priceManagementTab().clickRateButton();
        PartnersPages.priceManagementTab().selectAllProducts();

        Assert.assertTrue(PartnersPages.priceManagementTab().isRateInputEnable(),
                "Rate input field is disabled!");
    }
}
