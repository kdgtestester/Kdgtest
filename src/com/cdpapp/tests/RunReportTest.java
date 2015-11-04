package com.cdpapp.tests;

import com.cdpapp.actions.CreatingNewSurveyActions;
import com.cdpapp.control.Actions;
import com.cdpapp.control.Pages;
import com.qatestlab.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class RunReportTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void newSurvey(String login, String password) throws InterruptedException {

        String nameSurveyTempl = "CDP 2.0 Survey  ";

        Actions.loginActions().loginWithGoogle();
        Actions.loginActions().setGoogleAccData(login, password);
        Actions.loginActions().singInGoogleAccount();

        Actions.creatingNewSurveyActions().createSurvey();

        String nameSurvey = nameSurveyTempl.concat(CreatingNewSurveyActions.fiscalYear).toLowerCase();

        Pages.dashboard().waitFirstSurvey();

        Assert.assertEquals(Pages.dashboard().getFirstSurvey(), nameSurvey);

        Actions.runReportsActions().runReport();

    }

}
