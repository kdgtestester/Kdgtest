package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class CreatingNewSurveyActions {

    public static String fiscalYear = "";

    public void createSurvey (){
        joinOrCreateNewOrganization();
        customizeSurvey();
    }

    public void clickNewSurveyButton(){
        Pages.dashboard().waitNewSurveyButton();
        Pages.dashboard().clickNewSurveyButton();
    }

    public void joinOrCreateNewOrganization(){
        Pages.dashboard().modalBody();
        Pages.dashboard().waitFirstItemMenuWithOrgItem();
        Pages.dashboard().clickFirstItemMenuWithOrgItem();
        Pages.dashboard().waitGrantNonprofitItem();
        Pages.dashboard().clickGrantNonprofitItem();
        Pages.dashboard().modalBody();
        clickNewSurveyButton();
    }

    public void customizeSurvey(){
        Pages.profileWizard().selectFiscalYear();
        fiscalYear = Pages.profileWizard().getFiscalYear();

        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();
        Pages.profileWizard().waitFormSummaryOrgType();
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartSurveyButton();
        Pages.profileWizard().clickStartSurveyButton();
        Pages.profileWizard().wait(60);
        //Pages.profileWizard().modalBody();
        Pages.profileWizard().waitGoToDashBoard();
        Pages.profileWizard().clickGoToDashBoard();
    }
}
