package com.mediaspectrum.tests.contracts;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.ContractPages;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
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
 * Created by alex on 05.10.2015.
 */

public class T1391049_VerifyAdjustmentHistoryTab extends BaseTest {

    private CustomerData customerData;
    private ProductData productData;
    private ContractData contractData;
    private AdvancedOrderData advancedOrderData;

    public T1391049_VerifyAdjustmentHistoryTab(){
        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);

        productData = new ProductData();
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("10.0 %");

        advancedOrderData = new AdvancedOrderData();
        OrderInformationData orderInformationData = new OrderInformationData();
        advancedOrderData.setOrderInformationData(orderInformationData);
        advancedOrderData.setCustomerData(customerData);
        advancedOrderData.setProduct(productData);
    }

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "seniorLogin");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String login, String password){
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
    }

    @Test(dependsOnMethods = "testLogin")
    public void createPartnerTest(){
        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        Actions.partnerActions().createCustomer(customerData);
    }

    @Test(dependsOnMethods = "createPartnerTest")
    public void createContractTest(){
        productData = new ProductData();
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002-00");

        contractData = new ContractData();
        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setStartMonth(Calendar.getInstance());
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("10.0 %");

        Actions.mainPageActions().createApproveContract(contractData);
    }

    @Test(dependsOnMethods = "createPartnerTest")
    public void placeOrderTest(){
        productData.setProductName("Le Matin%22002-00");
        productData.setProductUniqueId("22002");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("2 columns");
        productData.setProductSizeHeight("50");
        productData.setProductDatesCount(1);
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "placeOrderTest")
    public void checkOrderPlacedTest(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }

    @Test(dependsOnMethods = "checkOrderPlacedTest")
    public void makeContractIntermediateAdjustmentTest(){
        contractData.setIsAdjustmentTypeFinal(false);
        contractData.setDiscountLevel("9.0 %");
        Actions.advancedBookingActions().addContractAdjustment(contractData);
    }

    @Test(dependsOnMethods = "makeContractIntermediateAdjustmentTest")
    public void checkAdjustmentHistory(){
        Actions.advancedBookingActions().waitAdjustmentHistoryUpdated();
        Assert.assertEquals(ContractPages.manageContractPage().getOldDiscount(), "10", "Old discount has incorrect value");
        Assert.assertEquals(ContractPages.manageContractPage().getNewDiscount(), contractData.getDiscountLevel().split("\\.")[0], "New discount has incorrect value");
        Assert.assertTrue(ContractPages.manageContractPage().isDownloadLinkVisible(), "Download link is not visible");
    }
}
