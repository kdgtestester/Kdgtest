package com.mediaspectrum.tests.login;

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
 * Test Name: Advanced Booking - Login with existing account (valid)
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964337
 */

public class T964337_LoginWithExistingAccount extends BaseTest{
    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test
    public void openLoginPageTest(){
        Actions.loginActions().openLoginPage();
        Assert.assertEquals("TEST SYSTEM", Pages.loginPage().getPageHeader(),
                "Page header not match to expected! See: https://jira.mediaspectrum.net/browse/XENTM-3180");
    }

    @Test(dependsOnMethods = "openLoginPageTest")
    public void systemLanguageTest(){
        Assert.assertTrue(Pages.loginPage().isSystemLanguageSelected(),
                "System language is not selected!");

        Assert.assertEquals("rgba(0, 122, 170, 1)", Pages.loginPage().getSelectedSystemLanguageBgColor(),
                "Selected language background is incorrect");

        Pages.loginPage().setSystemLanguage(Constants.DEFAULT_SYSTEM_LANGUAGE);
        Assert.assertEquals(Pages.loginPage().getSystemLanguage(), Constants.DEFAULT_SYSTEM_LANGUAGE,
                "System language is not set to " + Constants.DEFAULT_SYSTEM_LANGUAGE);

    }

    @Test(dataProvider = "loginData" ,dependsOnMethods = "systemLanguageTest")
    public void typeAccountDataTest(String login, String password){
        Pages.loginPage().typeLogin(login);
        Assert.assertEquals(login, Pages.loginPage().getLoginValue(),
                "Displayed login does not match to entered");

        Pages.loginPage().typePassword(password);
        Assert.assertTrue(Pages.loginPage().isPasswordInputFieldTypePassword(),
                "Password input type is not password");

    }

    @Test(dependsOnMethods = "typeAccountDataTest")
    public void loginTest(){
        Pages.loginPage().clickLoginButton();
        //will raise an error in case of unsuccessful login
        Pages.topMenu().waitForLoad();
    }




}
