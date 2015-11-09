package com.cdpapp.tests;

import com.cdpapp.control.Actions;
import com.cdpapp.control.Pages;
import com.testmatick.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test
    public void openGoogleFormAuthTest() throws InterruptedException {
        Actions.loginActions().openGoogleAuthWindow();

        Assert.assertNotNull(Pages.googleAuthPage().headerSingIn());

    }
}
