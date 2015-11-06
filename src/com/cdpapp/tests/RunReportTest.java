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

        Actions.loginActions().openGoogleAuthWindow();
        Actions.loginActions().setAuthDataGoogleAccUser(login, password);
        Actions.creatingNewSurveyActions().createSurvey();

        String fisclalYear = Actions.creatingNewSurveyActions().selectFiscalYearAndClickStartButton();

        String nameSurvey = "CDP 2.0 Survey  ".concat(fisclalYear).toLowerCase();

        Actions.creatingNewSurveyActions().customizeSurvey();

        Pages.dashboard().waitFirstSurvey();

        Assert.assertEquals(Pages.dashboard().getFirstSurvey(), nameSurvey);




        Actions.runReportsActions().runReport();

        Pages.reportsRun().waitAnnualReport();
        Pages.reportsRun().clickAnnualReport();

        Assert.assertEquals(Pages.reportsRun().getCountCheckReportType(), 1);


        Pages.reportsRun().waitTrendReportType();
        Pages.reportsRun().clickTrendReport();

        Assert.assertEquals(Pages.reportsRun().getCountCheckReportType(), 1);

        Pages.reportsRun().waitComparisonReportType();
        Pages.reportsRun().clickComparisonReport();

        Assert.assertEquals(Pages.reportsRun().getCountCheckReportType(), 1);

    }

}
