package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetInvestmentIncomeSurvey{

    public void setInvestmentIncomeSurvey(){
        Pages.investmentIncomeSurvey().setUnrestrictedInvestmentIncomeNonOperating();
        Pages.investmentIncomeSurvey().setTemporarilyRestrictedInvestmentIncomeNonOperating();
        Pages.investmentIncomeSurvey().setPermanentlyRestrictedInvestmentIncomeNonOperating();
    }

}
