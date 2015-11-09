package com.cdpapp.pages.completesurvey.balancesheet;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class NetAssetsSurvey extends BasePage {

    public void setUnrestrictedNetAssets(){
        type("Set Unrestricted Net Assets", "1", "otherNotesLoansNonCurrentField");
    }

    public void setTotalLiabilitiesAndNetAssets1(){
        type("Set Total Liabilities and Net Assets 1", "1", "totalLiabilitiesNetAssetsField1");
    }

    public void setTotalLiabilitiesAndNetAssets2(){
        type("Set Total Liabilities and Net Assets 2", "1", "totalLiabilitiesNetAssetsField2");
    }

    public void setTotalLiabilitiesAndNetAssets3(){
        type("Set Total Liabilities and Net Assets 3", "1", "totalLiabilitiesNetAssetsField3");
    }

}
