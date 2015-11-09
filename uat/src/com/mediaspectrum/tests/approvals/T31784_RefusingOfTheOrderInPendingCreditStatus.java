package com.mediaspectrum.tests.approvals;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by alex on 15.10.2015.
 */
public class T31784_RefusingOfTheOrderInPendingCreditStatus extends BaseTest{

    private CustomerData customerData;
    private ProductData productData;
    private AdvancedOrderData advancedOrderData;

    public T31784_RefusingOfTheOrderInPendingCreditStatus(){
        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        customerData.setCreditLimit("1000");
        customerData.setCreditBlocked(false);

        ProductData productData = new ProductData();
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

        advancedOrderData = new AdvancedOrderData();
        advancedOrderData.setOrderInformationData(new OrderInformationData());
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
        Actions.partnerActions().createCustomer(customerData);
    }

    @Test(dependsOnMethods = "createPartnerTest")
    public void placeOrderTest(){
        Actions.partnerActions().searchPartnerByName(customerData.getCompanyName());
        Actions.partnerActions().openAdvancedBooking(customerData.getCompanyName());
        Actions.advancedBookingActions().doOrder(advancedOrderData);

        //Assert.assertEquals(Pages.ordersPage().getOrderStatus(), "(new)Pending Credit", "Incorrect order status");
    }

    @Test(dependsOnMethods = "placeOrderTest")
    public void rejectOrder() {
        Actions.advancedBookingActions().searchOrderOnApprovals(advancedOrderData.getOrderID());
        Pages.approvalsPage().expandOrder();
        Actions.advancedBookingActions().rejectOrder("Address info is missing or unclear", "test");
        Assert.assertFalse(Pages.approvalsPage().isOrderPresentOnApprovalsPage(advancedOrderData.getOrderID()));

        Actions.mainPageActions().assertOdrerPresentInDashboard(advancedOrderData.getOrderID());
        Pages.dashboardPage().clickOrderById(advancedOrderData.getOrderID());
        Assert.assertEquals(Pages.dashboardPage().getOrderStatus(), "(new)Pnd Credit KO", "Order status is invalid");
    }

}
