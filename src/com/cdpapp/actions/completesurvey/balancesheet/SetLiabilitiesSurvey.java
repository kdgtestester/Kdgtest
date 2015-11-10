package com.cdpapp.actions.completesurvey.balancesheet;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetLiabilitiesSurvey {

    public void setLiabilitiesSurvey(){

        Pages.liabilitiesSurvey().setUnrestrictedAccountsPayable();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedAccountsPayable();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedAccountsPayable();

        Pages.liabilitiesSurvey().setUnrestrictedAccruedExpenses();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedAccruedExpenses();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedAccruedExpenses();

        Pages.liabilitiesSurvey().setUnrestrictedDeferredRevenue();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedDeferredRevenue();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedDeferredRevenue();

        Pages.liabilitiesSurvey().setUnrestrictedLoansCurrent();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedLoansCurrent();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedLoansCurrent();

        Pages.liabilitiesSurvey().setUnrestrictedOtherCurrentLiabilities();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedOtherCurrentLiabilities();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedOtherCurrentLiabilities();

        Pages.liabilitiesSurvey().setUnrestrictedLoansNonCurrent();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedLoansNonCurrent();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedLoansNonCurrent();

        Pages.liabilitiesSurvey().setUnrestrictedOtherNonCurrentLiabilities();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedOtherNonCurrentLiabilities();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedOtherNonCurrentLiabilities();

        Pages.liabilitiesSurvey().setUnrestrictedTotalNonCurrentLiabilities();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedTotalNonCurrentLiabilities();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedTotalNonCurrentLiabilities();

        Pages.liabilitiesSurvey().setUnrestrictedDueToDueFrom();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedDueToDueFrom();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedDueToDueFrom();

        Pages.liabilitiesSurvey().setUnrestrictedTotalLiabilities();
        Pages.liabilitiesSurvey().setTemporarilyRestrictedTotalLiabilities();
        Pages.liabilitiesSurvey().setPermanentlyRestrictedTotalLiabilities();

    }

}