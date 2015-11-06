package com.cdpapp.actions;

import com.cdpapp.control.Pages;
import com.qatestlab.reporting.Reporter;
import org.openqa.selenium.TimeoutException;

public class CreatingNewSurveyActions {

    public void createSurvey (){
        clickNewSurveyButton();
    }

    public void clickNewSurveyButton(){
        Pages.dashboard().waitNewSurveyButton();
        Pages.dashboard().clickNewSurveyButton();
    }

    public String selectFiscalYearAndClickStartButton(){

        String fiscalYear = "";

        try {
            Pages.profileWizard().selectFiscalYear();
            fiscalYear = getFiscalYear();
            Pages.profileWizard().scrollToDown();
            Pages.profileWizard().waitStartButton();
            Pages.profileWizard().clickStartButton();
        } catch (TimeoutException e){
            fiscalYear = selectFiscalYearAndClickStartButton();
        }

        return fiscalYear;
    }

    public String getFiscalYear(){
        return Pages.profileWizard().getFiscalYear();
    }

    public void customizeSurvey(){

        Pages.profileWizard().scrollToDown();
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