package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.ContractData;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.mediaspectrum.utils.ProductData;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.Random;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify view for Contract Discount on 8/2 Package
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964409
 */

public class T964409_VerifyVewForContractDiscountOn8Per2Package extends BaseTest {

    private CustomerData customerData;
    private ProductData productData;
    private ProductData subProduct1;
    private ContractData contractData;

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

        subProduct1 = new ProductData();
        subProduct1.setProductName("TV 8 (RomandieMax Family)");
        subProduct1.setProductUniqueId("18410");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(subProduct1);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("24.0 %");

        Actions.mainPageActions().createApproveContract(contractData);
    }

    @Test(dependsOnMethods = "createContractTest")
    public void goToAdvancedBookingTest(){
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "goToAdvancedBookingTest")
    public void addProductToShoppingCartAndSaveItTest(){

        productData = new ProductData();
        productData.setProductName("RomandieMAX Family");
        productData.setProductUniqueId("22606");

        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendations");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductColor("Black/White");
        subProduct1.setProductSize("1/1");
        subProduct1.setProductDatesCount(1);
        subProduct1.setProductContentType("07 Without digital transmission");
        subProduct1.setProductContentDescription("Description");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("Illustr");
        subProduct2.setProductUniqueId("29404");
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

        PartnersPages.orderInformationTab().clickSaveOrderButton();
    }

    @Test(dependsOnMethods = "addProductToShoppingCartAndSaveItTest")
    public void checkAdvertiserViewTest() {
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        Assert.assertEquals("Advertiser", PartnersPages.priceManagementTab().getViewAsSelectorValue(),
                "Incorrect viewer!");


        for(ProductData subproduct : productData.getSubProducts()){
            Assert.assertTrue(PartnersPages.priceManagementTab().isProductCheckboxVisible(subproduct.getProductName()));

            Assert.assertEquals(PartnersPages.priceManagementTab().getDiscountScaleValues(subproduct.getProductName()).get(0),
                    contractData.getDiscountLevel().substring(0,2), "Incorrect discount");

            PartnersPages.priceManagementTab().closeProductOrderInfo(subproduct.getProductName());

        }

        Assert.assertFalse(PartnersPages.priceManagementTab().isProductCheckboxVisible(
                productData.getProductName() + " " + productData.getProductUniqueId()));

        Assert.assertTrue(PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName() +
                " " + productData.getProductUniqueId()).isEmpty(),  "Head product contains discount value");

        PartnersPages.priceManagementTab().closeProductOrderInfo(productData.getProductName() + " " + productData.getProductUniqueId());

    }

    @Test(dependsOnMethods = "checkAdvertiserViewTest")
    public void checkPublisherViewTest(){
        PartnersPages.priceManagementTab().selectViewAs("Publisher");

        Assert.assertFalse(PartnersPages.priceManagementTab().isProductCheckboxVisible(
                productData.getProductName() + " " + productData.getProductUniqueId()));

        for(ProductData subproduct : productData.getSubProducts()){
            Assert.assertTrue(PartnersPages.priceManagementTab().isProductCheckboxVisible(subproduct.getProductName()));

            Assert.assertEquals(PartnersPages.priceManagementTab().getDiscountScaleValues(subproduct.getProductName()).get(0),
                    contractData.getDiscountLevel().substring(0,2), "Incorrect discount");

            PartnersPages.priceManagementTab().closeProductOrderInfo(subproduct.getProductName());

        }

        Assert.assertTrue(PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName() +
                        " " + productData.getProductUniqueId()).isEmpty(),  "Head product contains discount value");

        Assert.assertFalse(PartnersPages.priceManagementTab().isRateButtonEnable(), "Rate button is enable");
        Assert.assertFalse(PartnersPages.priceManagementTab().isSurchargeButtonEnable(), "Surcharge button is enable");
    }

    @Test(dependsOnMethods = "checkPublisherViewTest")
    public void checkContractDiscountPresent(){

        PartnersPages.priceManagementTab().clickProductCheckbox(productData.getSubProducts().get(0).getProductName());
        PartnersPages.priceManagementTab().clickRateButton();

        PartnersPages.priceManagementTab().selectAllProducts();

        Assert.assertEquals(contractData.getAssignmentName(), PartnersPages.priceManagementTab().getDiscountContractName());

        Assert.assertEquals(contractData.getDiscountLevel().substring(0,2), PartnersPages.priceManagementTab().getContractDiscountValue(),
                "Incorrect discount value!");
    }
}
