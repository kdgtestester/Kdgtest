package com.mediaspectrum.tests.advancedbooking;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.ContractData;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.mediaspectrum.utils.ProductData;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.Random;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify view for Contract Discount on 8/1 Package
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964369
 */

public class T964369_VerifyVewForContractDiscountOn8Per1Package extends BaseTest {

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
        productData.setProductName("24 Heures");
        productData.setProductUniqueId("22001-00");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
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

        productData.setProductName("24 Heures%22001-00");
        productData.setProductUniqueId("22001");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        ProductData subProduct1 = new ProductData();
        subProduct1.setProductName("24 Heures Lausanne");
        subProduct1.setProductUniqueId("2200124");

        ProductData subProduct2 = new ProductData();
        subProduct2.setProductName("24 Heures R");
        subProduct2.setProductUniqueId("2200133");

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
            Assert.assertFalse(PartnersPages.priceManagementTab().isProductCheckboxVisible(subproduct.getProductName()));

            Assert.assertTrue(PartnersPages.priceManagementTab().getDiscountScaleValues(subproduct.getProductName()).isEmpty(),
                    "Child product contains discount");

            PartnersPages.priceManagementTab().closeProductOrderInfo(subproduct.getProductName());

        }

        Assert.assertTrue(PartnersPages.priceManagementTab().isProductCheckboxVisible(
                productData.getProductName() + " " + productData.getProductUniqueId()));

        Assert.assertEquals(PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName() +
                        " " + productData.getProductUniqueId()).get(0), contractData.getDiscountLevel().substring(0,2),
                "Incorrect discount value");

        PartnersPages.priceManagementTab().closeProductOrderInfo(productData.getProductName() + " " + productData.getProductUniqueId());

    }

    @Test(dependsOnMethods = "checkAdvertiserViewTest")
    public void checkPublisherViewTest(){
        PartnersPages.priceManagementTab().selectViewAs("Publisher");

        Assert.assertTrue(PartnersPages.priceManagementTab().isProductCheckboxVisible(
                productData.getProductName() + " " + productData.getProductUniqueId()));

        for(ProductData subproduct : productData.getSubProducts()){
            Assert.assertFalse(PartnersPages.priceManagementTab().isProductCheckboxVisible(subproduct.getProductName()));

            Assert.assertTrue(PartnersPages.priceManagementTab().getDiscountScaleValues(subproduct.getProductName()).isEmpty(),
                    "Child product contains discount");

            PartnersPages.priceManagementTab().closeProductOrderInfo(subproduct.getProductName());

        }

        Assert.assertEquals(PartnersPages.priceManagementTab().getDiscountScaleValues(productData.getProductName() +
                        " " + productData.getProductUniqueId()).get(0), contractData.getDiscountLevel().substring(0,2),
                "Incorrect discount value");

        PartnersPages.priceManagementTab().closeProductOrderInfo(productData.getProductName() + " " + productData.getProductUniqueId());
    }

    @Test(dependsOnMethods = "checkPublisherViewTest")
    public void checkContractDiscountPresent(){

        PartnersPages.priceManagementTab().clickProductCheckbox(productData.getProductName() + " " + productData.getProductUniqueId());
        PartnersPages.priceManagementTab().clickRateButton();

        PartnersPages.priceManagementTab().selectAllProducts();

        Assert.assertEquals(contractData.getAssignmentName(), PartnersPages.priceManagementTab().getDiscountContractName());

        Assert.assertEquals(contractData.getDiscountLevel().substring(0,2), PartnersPages.priceManagementTab().getContractDiscountValue(),
                "Incorrect discount value!");
    }
}
