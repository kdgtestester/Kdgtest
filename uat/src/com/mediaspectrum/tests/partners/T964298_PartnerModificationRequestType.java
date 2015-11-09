package com.mediaspectrum.tests.partners;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Create new partner - Partner Modification request type
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964298
 */

public class T964298_PartnerModificationRequestType extends BaseTest{

    CustomerData customerData;
    String modificationRequestType;

    @DataProvider
    public Object[][] juniorLoginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "juniorLogin");
    }

    @DataProvider
    public Object[][] seniorLoginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "seniorLogin");
    }

    @Test(dataProvider = "seniorLoginData")
    public void prepareCustomerTest(String login, String password){

        customerData = SerializeHelper.deserializeObject(CustomerData.class, Constants.CUSTOMER_SERIALIZE_FILENAME);

        if(customerData == null){

            Actions.loginActions().openLoginPage();
            Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);

            customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);

            Actions.loginActions().logout();
        }
    }

    @Test(dataProvider = "juniorLoginData", dependsOnMethods = "prepareCustomerTest")
    public void sendModificationRequestTest(String login, String password){

        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);

        modificationRequestType = "General";
        Actions.partnerActions().sendPartnerModificationRequest(customerData.getCustomerID(), modificationRequestType);

        Actions.loginActions().logout();
    }

    @Test(dataProvider = "seniorLoginData", dependsOnMethods = "sendModificationRequestTest")
    public void approveModificationRequestType(String login, String password){
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
        Actions.partnerActions().approveModificationRequest(customerData.getCustomerID(), modificationRequestType);

        Actions.loginActions().logout();
    }

    @Test(dataProvider = "juniorLoginData", dependsOnMethods = "approveModificationRequestType")
    public void checkPartnerStatusTest(String login, String password){
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
        Actions.partnerActions().openPartnerPageByID(customerData.getCustomerID());

        PartnersPages.createPartnerPage().waitModificationRequestItem(modificationRequestType);
        Assert.assertEquals(PartnersPages.createPartnerPage().getCustomerStatus(), "Live",
                "Customer status in not live.");
    }

}
