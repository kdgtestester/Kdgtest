package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.SerializeHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify the "Surcharge" button for Insertion and Order Level checkboxes are chosen
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964525
 */

public class T964525_VerifySurchargeButtonForInsertionAndOrderCheckboxesChosen extends BaseTest{

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

        ProductData productData = new ProductData();
        productData.setProductName("Impartial Plus%10946");
        productData.setProductUniqueId("10946");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("Impartial/Impartial Plus");
        subProduct1.setProductUniqueId("28003");
        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendations");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductColor("Black/White");
        subProduct1.setProductSize("1/1");
        subProduct1.setProductDatesCount(1);
        subProduct1.setProductContentType("07 Without digital transmission");
        subProduct1.setProductContentDescription("Description");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("Courrier NE Haut");
        subProduct2.setProductUniqueId("28024");
        subProduct2.setProductAdType("Ads");
        subProduct2.setProductHeading("Recommendations");
        subProduct2.setProductSubHeading("Base");
        subProduct2.setProductColor("Black/White");
        subProduct2.setProductSize("1/1");
        subProduct2.setProductDatesCount(1);
        subProduct2.setProductContentType("07 Without digital transmission");
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
    public void checkCheckboxesTest(){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        Assert.assertEquals(1, PartnersPages.priceManagementTab().getCheckedCheckboxesCount(),
                "No checkboxes checked");

        for(WebElement webElement : PartnersPages.priceManagementTab().getAvailableCheckboxesList()){
            webElement.click();

            Assert.assertEquals(1, PartnersPages.priceManagementTab().getCheckedCheckboxesCount(),
                    "No checkboxes checked");

            Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargeButtonEnable(),
                    "Surcharge button is not available");
        }
    }

    @Test(dependsOnMethods = "checkCheckboxesTest")
    public void checkPublisherViewTest(){
        PartnersPages.priceManagementTab().selectViewAs("Publisher");

        Assert.assertEquals(0, PartnersPages.priceManagementTab().getCheckedCheckboxesCount(),
                "No checkboxes checked");

        Assert.assertFalse(PartnersPages.priceManagementTab().isSurchargeButtonEnable(),
                "Surcharge button is available");

    }

}
