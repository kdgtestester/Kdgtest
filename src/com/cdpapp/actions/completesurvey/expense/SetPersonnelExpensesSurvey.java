package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetPersonnelExpensesSurvey {

    public void setPersonnelExpensesSurvey(){
        Pages.personnelExpensesSurvey().setEmployeesProgram();
        Pages.personnelExpensesSurvey().setEmployeesFundraising();
        Pages.personnelExpensesSurvey().setEmployeesGeneralAndAdministrative();

        Pages.personnelExpensesSurvey().setIndependentContractorsProgram();
        Pages.personnelExpensesSurvey().setIndependentContractorsFundraising();
        Pages.personnelExpensesSurvey().setIndependentContractorsGeneralAndAdministrative();

        Pages.personnelExpensesSurvey().setProfessionalFeesProgram();
        Pages.personnelExpensesSurvey().setProfessionalFeesFundraising();
        Pages.personnelExpensesSurvey().setProfessionalFeesGeneralAndAdministrative();

        Pages.personnelExpensesSurvey().setTotalPersonnelExpenses();

        Pages.personnelExpensesSurvey().checkArtistPayments();

    }

}
