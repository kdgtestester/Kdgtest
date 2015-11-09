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
 * Test Name: Advanced booking - Verify view for Contract Discount on 8/3 Package
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964211
 */

public class T964211_VerifyVewForContractDiscountOn8Per3Package extends BaseTest {

    private CustomerData customerData;
    private ProductData productData;
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

        productData = new ProductData();
        productData.setProductName("Top Matin%01998");
        productData.setProductUniqueId("1998");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("25.0 %");

        Actions.mainPageActions().createApproveContract(contractData);
    }

    @Test(dependsOnMethods = "createContractTest")
    public void goToAdvancedBookingTest(){
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
    }

    @Test(dependsOnMethods = "goToAdvancedBookingTest")
    public void addProductToShoppingCartAndSaveItTest(){

        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2/1");
        productData.setProductDatesCount(1);

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("Le Matin dimanche");
        subProduct1.setProductUniqueId("10000");
        subProduct1.setProductAdType("Ads");
        subProduct1.setProductHeading("Recommendations");
        subProduct1.setProductSubHeading("Base");
        subProduct1.setProductColor("Black/White");
        subProduct1.setProductSize("2/1");
        subProduct1.setProductDatesCount(1);
        subProduct1.setProductContentType("07 Without digital transmission");
        subProduct1.setProductContentDescription("Description");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("Le Matin semaine");
        subProduct2.setProductUniqueId("22002");
        subProduct2.setProductAdType("Ads");
        subProduct2.setProductHeading("Recommendations");
        subProduct2.setProductSubHeading("Base");
        subProduct2.setProductColor("Black/White");
        subProduct2.setProductSize("2/1");
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

        Assert.assertTrue(PartnersPages.priceManagementTab().isProductCheckboxVisible(productData.getProductName()));

        for(ProductData subproduct : productData.getSubProducts()){
            Assert.assertFalse(PartnersPages.priceManagementTab().isProductCheckboxVisible(subproduct.getProductName()));

            Assert.assertTrue(PartnersPages.priceManagementTab().getDiscountScaleValues(subproduct.getProductName()).isEmpty(),
                    "Child product contains discount value");

            PartnersPages.priceManagementTab().closeProductOrderInfo(subproduct.getProductName());

        }

        Assert.assertEquals(PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName() +
                " " + productData.getProductUniqueId()).get(0), contractData.getDiscountLevel().substring(0,2), "Incorrect discount");

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
