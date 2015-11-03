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
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Advanced booking - Verify dates on the child and head level
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964420
 */

public class T964420_VerifyDatesOnTheChildAndHeadLevel extends BaseTest{

    private AdvancedOrderData advancedOrderData;
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
    public void setHeadProductDataTest(){

        productData = new ProductData();
        productData.setProductName("Geschenktipp");
        productData.setProductUniqueId("11063");
        productData.setProductAdType("Ads");
        productData.setProductHeading("Recommendations");
        productData.setProductSubHeading("Base");
        productData.setProductColor("Black/White");
        productData.setProductSize("1/1");
        productData.setProductContentType("07 Without digital transmission");
        productData.setProductContentDescription("Description");

        Calendar preconditionDate = Calendar.getInstance();
        preconditionDate.set(2015, Calendar.NOVEMBER, 26);

        productData.addProductDate(preconditionDate);

        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
        PartnersPages.scheduleAdvancedTab().searchSelectProduct(productData.getProductName(), productData.getProductUniqueId());

        Actions.advancedBookingActions().setProductData(productData);
    }

    @Test(dependsOnMethods = "setHeadProductDataTest")
    public void checkSubproductsDateTest(){
        String selectedDate = PartnersPages.scheduleAdvancedTab().getSetDate();

        List<ProductData> products = new ArrayList<>(Arrays.asList(
                new ProductData("Anzeiger St. Gallen", "1052112"),
                new ProductData("Anzeiger St. Gallen", "1052104"),
                new ProductData("Anzeiger Thurgau", "1052105"),
                new ProductData("Anzeiger Stadt St.", "1052117"),
                new ProductData("St. Galler Tagblatt Gesamt", "3300154"),
                new ProductData("St. Galler Tagblatt St. Gallen/Gossau ", "3300157"),
                new ProductData("St. Galler Tagblatt Rorschach", "3300158"),
                new ProductData("Der Rheintaler", "3300160"),
                new ProductData("Appenzeller", "3300161"),
                new ProductData("Rheintalische", "3300407"),
                new ProductData("Liechtensteiner", "3302406"),
                new ProductData("Toggenburger", "3327116"),
                new ProductData("Thurgauer", "4100111"),
                new ProductData("Werdenberger", "6307009"),
                new ProductData("Wiler Zeitung", "6402132")));

        for(ProductData productData : products){
            PartnersPages.scheduleAdvancedTab().checkProductRadioButton(productData.getProductUniqueId());

            Assert.assertEquals(selectedDate, PartnersPages.scheduleAdvancedTab().getSetDate(),
                    "Date set incorrectly for child product : " + productData.getProductName());
        }
    }

    @Test(dependsOnMethods = "checkSubproductsDateTest")
    public void orderProductTest(){

        PartnersPages.scheduleAdvancedTab().clickAddToOrderButton();
        PartnersPages.orderInformationTab().waitProductAddToShoppingCart(productData.getProductName());

        Assert.assertTrue(PartnersPages.orderInformationTab().isProductInShoppingCart(productData.getProductName()),
                "Product did not add to shopping cart");

        OrderInformationData orderInformationData = new OrderInformationData();
        orderInformationData.setOrderPaymentMethod(Constants.DEFAULT_PAYMENT_METHOD);

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(orderInformationData);

        Actions.advancedBookingActions().doOrder(advancedOrderData);
    }

    @Test(dependsOnMethods = "orderProductTest")
    public void checkOrderSuccessful(){
        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
    }
}
