package com.mediaspectrum.tests.advancedbooking;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify coping of "Profit Center" to new order (blue button)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964454
 */

public class T964454_VerifyProfitCenterCopingToNewOrderBlueButton extends BaseTest{

    private AdvancedOrderData advancedOrderData;

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

        CustomerData customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        customerData.setPartnerProfitCenter("(10-014) PUB - DELEMONT");

        Actions.partnerActions().createCustomer(customerData);
        Actions.partnerActions().searchCustomer(customerData);
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setCustomerData(customerData);
    }

    @Test(dependsOnMethods = "selectCustomerTest")
    public void checkProfitCenterDropdownValue(){
        Assert.assertEquals(advancedOrderData.getCustomerData().getPartnerProfitCenter(),
                PartnersPages.orderInformationTab().getSelectedProfitCenter(), "Incorrect profit center");
    }

    @Test(dependsOnMethods = "checkProfitCenterDropdownValue")
    public void addProductToShoppingCart(){

        productData = new ProductData();
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
        PartnersPages.orderInformationTab().selectPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);
        PartnersPages.orderInformationTab().selectInternalProvenance(Constants.DEFAULT_INTERNAL_PROVENANCE);

        PartnersPages.orderInformationTab().clickSaveOrderButton();
        PartnersPages.orderInformationTab().assertTotalPricePresent();

        Assert.assertFalse(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Shopping cart contains errors");

        Assert.assertFalse(PartnersPages.orderInformationTab().getOrderID().isEmpty(),
                "Order number is not generated");
    }

    @Test(dependsOnMethods = "addProductToShoppingCart")
    public void createNewOrderViaYellowMenuTest(){
        PartnersPages.orderInformationTab().clickNewOrderButton();
        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
    }

    @Test(dependsOnMethods = "createNewOrderViaYellowMenuTest")
    public void checkProfitCenterDropdownValueAfterYellowMenuActionTest(){
        Assert.assertEquals(advancedOrderData.getCustomerData().getPartnerProfitCenter(),
                PartnersPages.orderInformationTab().getSelectedProfitCenter(), "Incorrect profit center");
    }

    @Test(dependsOnMethods = "createNewOrderViaYellowMenuTest")
    public void doNewOrderTest(){
        ProductData newProductData = new ProductData();
        newProductData.setProductName("24 Heures%22001-00");
        newProductData.setProductUniqueId("22001");
        newProductData.setProductAdType("Ads");
        newProductData.setProductHeading("Recommendations");
        newProductData.setProductSubHeading("Base");
        newProductData.setProductColor("Black/White");
        newProductData.setProductSize("1/1");
        newProductData.setProductDatesCount(1);
        newProductData.setProductContentType("07 Without digital transmission");
        newProductData.setProductContentDescription("Description");

        orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setProduct(newProductData);
        advancedOrderData.setOrderInformationData(orderInformationData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "doNewOrderTest")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }




}
