package com.mediaspectrum.tests.partners;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
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
 * Test Name: Create new partner (valid)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964104
 */

public class T964104_CreateNewPartner extends BaseTest{

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
    public void createPartnerCheck(){
        CustomerData customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        Actions.partnerActions().createCustomer(customerData);
    }

    @Test(dependsOnMethods = "createPartnerCheck")
    public void checkAfterCreationLinksTest(){
        Assert.assertTrue(PartnersPages.createPartnerPage().isViewContactsLinkVisible(),
                "View contacts link is not visible!");
        Assert.assertTrue(PartnersPages.createPartnerPage().isViewContractsLinkVisible(),
                "View contracts link is not visible!");
        Assert.assertTrue(PartnersPages.createPartnerPage().isViewCampaignsLinkVisible(),
                "View campaigns link is not visible!");
        Assert.assertTrue(PartnersPages.createPartnerPage().isViewActivitiesHistoryLinkVisible(),
                "View activities history link is not visible!");
        Assert.assertTrue(PartnersPages.createPartnerPage().isProfileHistoryLinkVisible(),
                "View profile history is not visible!");
        Assert.assertTrue(PartnersPages.createPartnerPage().isAdvancedBookingLinkVisible(),
                "Advanced booking link is not visible!");
    }
}
