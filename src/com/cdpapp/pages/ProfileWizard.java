package com.cdpapp.pages;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

public class ProfileWizard extends BasePage {

    public String getHeaderProfileWizard(){
        return getElement("headerProfileWizard").getText().trim().toLowerCase();
    }

    public void selectFiscalYear1(){
        selectDropDownListOptionByText("Select fiscal year working on", "1958", "listFiscalYear");
    }

    public void selectFiscalYear(){
        selectDropDownListRandomOption("Select fiscal year working on", 2, getDropDownListItemsCount("Get count fiscal year", "listFiscalYear"), "listFiscalYear");
    }

    public String getFiscalYear(){
        Reporter.log(getDropDownListSelectedValueText("Get fiscal year", "listFiscalYear"));
        return getDropDownListSelectedValueText("Get fiscal year", "listFiscalYear");
    }

    public void waitStartButton(){
        waitForElementToBeClickable("startButton");
    }

    public void clickStartButton(){
        click("Click \"Start\" button in select a year from", "startButton");
    }

    public void waitEditSurveyButton(){
        waitForElementToBeClickable("editSurveyButton");
    }

    public void clickEditSurveyButton(){
        click("Click \"Edit Survey\" button in select a year from", "editSurveyButton");
    }



    public void waitSurveyProviders(){
        waitForElementVisibility("surveyProvidersItem");
    }

    public void clickSurveyProviders(){
        click("Select survey providers", "surveyProvidersItem");
    }

    public void waitConfirmWizardCheckbox(){
        waitForElementToBeClickable("confirmWizardCheckbox");
    }

    public void clickConfirmWizardCheckbox(){
        click("Click confirm wizard", "confirmWizardCheckbox");
    }

    public void waitOrgTypeForm(){
        waitForElementVisibility("listOrganizationType");
    }

    public void waitDisciplineForm(){
        waitForElementVisibility("nteeClassificationList");
    }

    public void selectNTEE(){
        selectDropDownListRandomOption("Select NTEE", 2, 2/*getDropDownListItemsCount("Get count discipline", "nteeClassificationList")*/, "nteeClassificationList");
    }

    public void selectDiscipline(){
        selectDropDownListRandomOption("Select discipline", 2, 2 /*getDropDownListItemsCount("Get discipline count", "disciplineList")*/, "disciplineList");
    }

    public void selectSpecialty(){
        selectDropDownListRandomOption("Select specialty", 2, getDropDownListItemsCount("Get specialty count", "specialtyList"), "specialtyList");
    }

    public void selectInstitutionType(){
        selectDropDownListRandomOption("Select institution type", 2, 2 /*getDropDownListItemsCount("Get institution type", "institutionTypeList")*/, "institutionTypeList");
    }


    public void selectOrgType(){
        selectDropDownListRandomOption("Select organization type", 2, 2 /*getDropDownListItemsCount("Get count organization type", "listOrganizationType")*/, "listOrganizationType");
    }

    public void waitProgramActivityForm(){
        waitForElementVisibility("programActivityHeader");
    }

    public void waitFinInfoHeader(){
        waitForElementVisibility("financialInfoHeader");
    }

    public void clickAuditorCompleteTrue(){
        click("Click \"Yes\" audit question", "auditedCompleteTrueRadio");
    }

    public void selectRestrictedRevenue(){
        click("Click restricted revenue", "restrictedRevenueCheck");
    }


    public void waitFormSummaryOrgType(){
        waitForElementVisibility("formSummaryOrgType");
    }

    public void waitStartSurveyButton(){
        waitForElementToBeClickable("startSurveyButton");
    }

    public void clickStartSurveyButton(){
        click("Click \"Start Survey\" button", "startSurveyButton");
    }


    public void waitModalBody(){
        waitForElementVisibility("modalBody");
    }

    public void waitGoToDashBoard(){
        waitForElementToBeClickable("goToDashboardButton");
    }

    public void clickGoToDashBoard(){
        click("Click \"Go to dashBoard\" link", "goToDashboardButton");
    }

    public void waitRevenueCheckTrue(){
        waitForElementToBeClickable("nonOperatingRevenueCheckTrue");
    }

    public void clickRevenueCheckTrue(){
        click("Select true non operating revenue", "nonOperatingRevenueCheckTrue");
    }

    public void clickOperatingExpenseCheckTrue(){
        click("Select true non operating expense", "nonOperatingExpenseCheckTrue");
    }

    public void clickEndowmentReserveCheckTrue(){
        click("Select endowment reserve check true", "endowmentReserveCheckTrue");
    }

    public void waitMembershipProgramCheckTrue(){
        waitForElementToBeClickable("membershipProgramCheckTrue");
    }


    public void clickMembershipProgramCheckTrue(){
        click("Click true membership program", "membershipProgramCheckTrue");
    }

    public void waitSaveFinishButton(){
        waitForElementToBeClickable("saveFinisButton");
    }

    public void clickSaveFinishButton(){
        click("Click \"Save & Finish\" button", "saveFinisButton");
    }

    public void acceptAlert(){
        alertAccept();
    }

    public void waitContinueButton(){
        waitForElementToBeClickable("continueButton");
    }

    public void clickContinueButton(){
        click("Click \"Continue\" button", "continueButton");
    }

    public void scrollToDown(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Reporter.log("Scroll down.");
    }

}
