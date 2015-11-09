package com.mediaspectrum.tests.dashboard;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.Pages;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Dashboard - Search orders by valid creation date, using listed days
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964075
 */

public class T964075_SearchOrderByCreationDay extends BaseTest {

    Calendar calendar;

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
    public void searchOrderTest(){

        Pages.topMenu().clickDashBoardLink();
        Pages.dashboardPage().waitPageLoad();
        Pages.dashboardPage().selectSearchCriteria("Creation Date");
        Pages.dashboardPage().selectSearchCriteriaType("is");
        Pages.dashboardPage().clickSelectDateButton();
        Pages.dashboardPage().switchToPreviousMonth();
        calendar = Pages.dashboardPage().selectRandomDate();
        Pages.dashboardPage().clickSearchButton();
    }

    @Test(dependsOnMethods = "searchOrderTest")
    public void checkResultsTest(){
        Assert.assertTrue(Pages.dashboardPage().isSearchResultsHasCorrectDate(calendar),
                "Search results contain incorrect dates!");
    }

}
