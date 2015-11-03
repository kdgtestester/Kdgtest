package com.cdpapp.tests;

import com.cdpapp.control.Actions;
import com.cdpapp.control.Pages;
import com.qatestlab.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class StartSurveyTest extends BaseTest {

    private String nameOrg = "TestOrg" + com.qatestlab.utils.Random.genString(4);

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void startSurvey(String login, String password) throws InterruptedException {
        Actions.loginActions().loginWithGoogle();
        Actions.loginActions().setGoogleAccData(login, password);
        Actions.loginActions().singInGoogleAccount();
        Actions.creatingNewOrganizationActions().createOrganization(nameOrg);

        Actions.creatingNewOrganizationActions().continueAfterCreateOrganization();


        Assert.assertEquals(Pages.dashboard().availableStartSurButton(), "Start a survey".trim().toLowerCase());
    }

}
