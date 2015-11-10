package com.cdpapp.actions.completesurvey.balancesheet;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetBalanceSheetSummarySurvey {

    public void setBalanceSheetSummarySurvey(){

        Pages.balanceSheetSummarySurvey().setTotalAssets();
        Pages.balanceSheetSummarySurvey().setTotalLiabilities();

    }

}
