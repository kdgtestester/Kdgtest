package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class InvestmentIncomeSurvey extends BasePage {

    public void setUnrestrictedInvestmentIncomeNonOperating(){
        type("Set unrestricted Investment Income - Non-Operating", "1", "unrestrictedInvestmentIncomeNonOperating");
    }

    public void setTemporarilyRestrictedInvestmentIncomeNonOperating(){
        type("Set Temporarily Restricted Investment Income - Non-Operating", "1", "temporarilyRestrictedInvestmentIncomeNonOperating");
    }

    public void setPermanentlyRestrictedInvestmentIncomeNonOperating(){
        type("Set Permanently Restricted Investment Income - Non-Operating", "1", "permanentlyRestrictedInvestmentIncomeNonOperating");
    }

}