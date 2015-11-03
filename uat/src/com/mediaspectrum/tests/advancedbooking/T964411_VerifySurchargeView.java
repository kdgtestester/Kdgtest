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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify "Surcharge" view
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964411
 */

public class T964411_VerifySurchargeView extends BaseTest{

    private ProductData productData;
    private List<SurchargesData> surcharges;


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
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("2200");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.advancedBookingActions().addProductToShoppingCart(productData);
        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartTest")
    public void addSurchargesTest(){

        surcharges = new ArrayList<>();
        surcharges.add(new SurchargesData("Surcharge", DataFactory.generateRateData("20")));
        surcharges.add(new SurchargesData("Surcharge", DataFactory.generateRateData("10")));
        surcharges.add(new SurchargesData("Surcharge", DataFactory.generateRateData("15")));

        Actions.advancedBookingActions().addSurcharges(surcharges);
    }

    @Test(dependsOnMethods = "addSurchargesTest")
    public void checkSurchargesInPriceManagementTabTest(){
        for(SurchargesData surchargesData : surcharges){
            Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargesPresentInOrder(
                    surchargesData.getSurchargeName(), productData.getProductName()), String.format(
                    "Surcharge %s is not present in order", surchargesData.getSurchargeName()));
        }
    }

}
