package com.cdpapp.actions.completesurvey.balancesheet;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetLoanDetailsSurvey {

    public void setLoanDetailsSurvey(){

        Pages.loanDetailsSurvey().setLineCreditLimit();
        Pages.loanDetailsSurvey().setLineCreditBalance();
        Pages.loanDetailsSurvey().setMortgageCurrent();
        Pages.loanDetailsSurvey().setMortgageNonCurrent();
        Pages.loanDetailsSurvey().setBondsPayableCurrent();
        Pages.loanDetailsSurvey().setBondsPayableNonCurrent();
        Pages.loanDetailsSurvey().setOtherNotesLoansCurrent();
        Pages.loanDetailsSurvey().setOtherNotesLoansNonCurrent();

    }

}