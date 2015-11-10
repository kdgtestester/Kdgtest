package com.cdpapp.actions;

import com.cdpapp.control.Pages;

/**
 * Created by Petr on 06.11.2015.
 */
public class StartSurveyActions {

    public void startSurvey(){
        Pages.dashboard().waitModalBody();
        Pages.dashboard().waitStartSurveyButton();
        Pages.dashboard().clickStartSurveyButton();

        Pages.profileWizard().selectFiscalYear();
        Pages.profileWizard().clickStartButton();
        Pages.profileWizard().waitConfirmWizardCheckbox();
        Pages.profileWizard().clickConfirmWizardCheckbox();
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().clickStartButton();
        Pages.profileWizard().waitOrgTypeForm();
        Pages.profileWizard().selectOrgType(); // select "501(C)(3)"
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitSurveyProviders();
        Pages.profileWizard().clickSurveyProviders(); // select "Americans for the Arts"
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitDisciplineForm();
        Pages.profileWizard().selectNTEE();  // Select "Alliances & Advocacy"
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().selectDiscipline(); //* select "Dance"
        Pages.profileWizard().selectSpecialty(); //
        Pages.profileWizard().selectInstitutionType(); // "Individual Artist"
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitProgramActivityForm();
        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitFinInfoHeader();

        Pages.profileWizard().clickAuditorCompleteTrue();
        Pages.profileWizard().selectRestrictedRevenue();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitRevenueCheckTrue();
        Pages.profileWizard().clickRevenueCheckTrue();
        Pages.profileWizard().clickOperatingExpenseCheckTrue();
        Pages.profileWizard().clickEndowmentReserveCheckTrue();

        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitMembershipProgramCheckTrue();
        Pages.profileWizard().clickMembershipProgramCheckTrue();

        Pages.profileWizard().scrollToDown();
        Pages.profileWizard().waitStartButton();
        Pages.profileWizard().clickStartButton();

        Pages.profileWizard().waitFormSummaryOrgType();

        Pages.profileWizard().scrollToDown();

        Pages.profileWizard().waitSaveFinishButton();
        Pages.profileWizard().clickSaveFinishButton();

        Pages.profileWizard().acceptAlert();

        Pages.profileWizard().waitModalBody();
    }

}
