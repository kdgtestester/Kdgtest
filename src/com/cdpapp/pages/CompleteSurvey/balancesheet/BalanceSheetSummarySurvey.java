package com.cdpapp.pages.completesurvey.balancesheet;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class BalanceSheetSummarySurvey extends BasePage{

    public void setTotalAssets(){
        type("Set Total Assets", "1", "totalAssetsField");
    }

    public void setTotalLiabilities(){
        type("Set Total Liabilities", "1", "totalLiabilitiesField");
    }

}
