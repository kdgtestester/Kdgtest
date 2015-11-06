package com.cdpapp.tests;

import com.cdpapp.control.Actions;
import com.cdpapp.control.Pages;
import com.qatestlab.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class JoinOrCreateNewOrganizationTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void joinCreateOrganization(String login, String password) throws InterruptedException {
        Actions.loginActions().openGoogleAuthWindow();
        Actions.loginActions().setAuthDataGoogleAccUser(login, password);
        Actions.creatingNewOrganizationActions().createOrganization();

        Assert.assertEquals(Pages.organizationSetup().continueButtonPresent(), "continue");
    }

}
