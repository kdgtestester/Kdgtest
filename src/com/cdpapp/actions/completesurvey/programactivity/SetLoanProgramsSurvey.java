package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetLoanProgramsSurvey {

    public void setLoanProgramsSurvey(){
        Pages.loanProgramsSurvey().setLoanProgramsDescription();
        Pages.loanProgramsSurvey().setLoanRecipients();
        Pages.loanProgramsSurvey().setLoans();
        Pages.loanProgramsSurvey().setAmountLoaned();

    }

}
