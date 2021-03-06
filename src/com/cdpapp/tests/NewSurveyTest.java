package com.cdpapp.tests;

import com.cdpapp.control.Actions;
import com.cdpapp.control.Pages;
import com.testmatick.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class NewSurveyTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void newSurvey(String login, String password) throws InterruptedException {

        Actions.loginActions().openGoogleAuthWindow();
        Actions.loginActions().setAuthDataGoogleAccUser(login, password);

        Actions.startSurveyActions().startSurvey();
        Actions.creatingNewSurveyActions().waitAndClickGoToDashboardLink();

        Actions.creatingNewSurveyActions().createSurvey();

        String fisclalYear = Actions.creatingNewSurveyActions().selectFiscalYearAndClickStartButton();

        String nameSurvey = "CDP 2.0 Survey  ".concat(fisclalYear).toLowerCase();

        Actions.creatingNewSurveyActions().customizeSurvey();
        Pages.dashboard().waitNewSurveyButton();



        Assert.assertEquals(Pages.dashboard().getFirstSurvey(), nameSurvey);

        Actions.creatingNewSurveyActions().clickNewSurveyButton();

        Assert.assertEquals(Pages.profileWizard().getHeaderProfileWizard(), "Customize Your Survey".toLowerCase());

    }

}