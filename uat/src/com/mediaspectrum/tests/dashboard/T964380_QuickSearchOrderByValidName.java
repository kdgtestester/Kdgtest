package com.mediaspectrum.tests.dashboard;


import com.mediaspectrum.control.Actions;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Dashboard - Quick search of order by valid name
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964380
 */

public class T964380_QuickSearchOrderByValidName extends BaseTest {

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
        Actions.mainPageActions().assertOdrerPresentInDashboard(Constants.DEFAULT_SUCCESSFUL_ORDER_ID);
    }

}
