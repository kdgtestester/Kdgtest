package com.mediaspectrum.tests.activities;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.Pages;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Create activity - UI - Verify the "Filtered by" field
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964593
 */

public class T964593_VerifyFilteredByField extends BaseTest{

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
    public void navigateToActivitiesPageTest(){
        Pages.topMenu().clickPartnersLink();
        Pages.leftMenu().clickCreateActivityButton();
        Pages.activitiesPage().waitPageToLoad();
    }

    @Test(dependsOnMethods = "navigateToActivitiesPageTest")
    public void checkFilterByUserNameTest(){
        Assert.assertEquals(Constants.DEFAULT_USER_NAME, Pages.activitiesPage().getFilteredByUsername(),
                "Wrong username displayed by default");
    }

    @Test(dependsOnMethods = "checkFilterByUserNameTest")
    public void checkActivitiesPresentText(){
        Assert.assertTrue(Pages.activitiesPage().isActivitiesPresent(), "Activities are not present in user calendar");
    }
}
