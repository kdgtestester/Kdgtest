package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class CreatingNewSurveyActions {

    public void createSurvey (){
        Pages.dashboard().waitModalBody();
        clickNewSurveyButton();
    }

    public void clickNewSurveyButton(){
        Pages.dashboard().waitNewSurveyButton();
        Pages.dashboard().clickNewSurveyButton();
        Pages.profileWizard().selectFiscalYear();
    }

    public String getFiscalYear(){
        return Pages.profileWizard().getFiscalYear();
    }

    public void customizeSurvey(){

        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitFormSummaryOrgType();
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartSurveyButton();
        Pages.profileWizard().clickStartSurveyButton();

        Pages.profileWizard().waitModalBody();
        waitAndClickGoToDashboardLink();

    }

    public void waitAndClickGoToDashboardLink(){
        Pages.profileWizard().waitGoToDashBoard();
        Pages.profileWizard().clickGoToDashBoard();
    }


}