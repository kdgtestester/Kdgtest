package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.Random;
import com.qatestlab.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify Rounding method change (due to Invoicing)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/965328
 */

public class T965328_VerifyRoundingMethodChangeDueToInvoicing extends BaseTest{
    private String discount;
    private ProductData productData;
    private CustomerData customerData;

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
    public void createPartnerTest(){

        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        Actions.partnerActions().createCustomer(customerData);
    }

    @Test(dependsOnMethods = "createPartnerTest")
    public void createContractTest(){

        productData = new ProductData();
        productData.setProductName("Le Matin");
        productData.setProductUniqueId("22002-00");

        ContractData contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("10.0 %");

        Actions.mainPageActions().createApproveContract(contractData);
    }

    @Test(dependsOnMethods = "createContractTest")
    public void goToAdvancedBookingTest(){
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "goToAdvancedBookingTest")
    public void addProductToShoppingCartAndSaveItTest(){

        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");


        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().selectInternalProvenance(Constants.DEFAULT_INTERNAL_PROVENANCE);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartAndSaveItTest")
    public void forceRateTest(){
        RatesData ratesData = DataFactory.generateRateData("9870.75");
        ratesData.setRateItem("In amount");
        Actions.advancedBookingActions().changeRate(ratesData);
    }

    @Test(dependsOnMethods = "forceRateTest")
    public void addSurchargeTest(){
        RatesData ratesData = DataFactory.generateRateData("16.28");
        ratesData.setRateItem("In amount");
        SurchargesData surchargesData = new SurchargesData();
        surchargesData.setRatesData(ratesData);
        surchargesData.setSurchargeName("Surcharge");
        surchargesData.setIsCalculationEnable(false);
        Actions.advancedBookingActions().addSurcharges(surchargesData);
    }

    @Test(dependsOnMethods = "addSurchargeTest")
    public void checkRoundingChangeTest(){
        discount = PartnersPages.priceManagementTab().getDiscountAmount(productData.getProductName());
        Assert.assertEquals(discount, "CHF -988.70",
                "Incorrect discount value");
    }

    @Test(dependsOnMethods = "checkRoundingChangeTest")
    public void changeSurchargeDataTest(){
        SurchargesData surchargesData = new SurchargesData();
        RatesData ratesData = DataFactory.generateRateData(null);
        ratesData.setRateItem(null);
        surchargesData.setRatesData(ratesData);
        surchargesData.setSurchargeName("Surcharge");
        Actions.advancedBookingActions().editSurcharge(surchargesData);
    }

    @Test(dependsOnMethods = "changeSurchargeDataTest")
    public void checkDiscountChanged(){
        Assert.assertNotEquals(discount, PartnersPages.priceManagementTab().getDiscountAmount(productData.getProductName()),
                "Discount is not changed");
    }
}
