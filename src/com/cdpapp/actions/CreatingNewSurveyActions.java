package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class CreatingNewSurveyActions {

    public static String fiscalYear = "";

    public void createSurvey (){
        Pages.dashboard().modalBody();
        clickNewSurveyButton();
        customizeSurvey();

    }

    public void clickNewSurveyButton(){
        Pages.dashboard().waitNewSurveyButton();
        Pages.dashboard().clickNewSurveyButton();
    }

//    public void joinOrCreateNewOrganization(){
//        Pages.dashboard().modalBody();
//
//        clickNewSurveyButton();
//    }

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

        Pages.profileWizard().waitModalBody();
        Pages.profileWizard().modalBody();
        Pages.profileWizard().waitGoToDashBoard();
        Pages.profileWizard().clickGoToDashBoard();

//
//        Pages.profileWizard().waitFormSummaryOrgType();
//        Pages.profileWizard().scrollToDown();
//        Pages.profileWizard().waitStartSurveyButton();
//        Pages.profileWizard().clickStartSurveyButton();
//        Pages.profileWizard().wait(60);
//        //Pages.profileWizard().modalBody();
//        Pages.profileWizard().waitGoToDashBoard();
//        Pages.profileWizard().clickGoToDashBoard();
    }

    public void waitAndClickGoToDashboardLink(){
        Pages.profileWizard().waitGoToDashBoard();
        Pages.profileWizard().clickGoToDashBoard();
    }


}
