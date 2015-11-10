package com.cdpapp.actions.completesurvey.balancesheet;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetNetAssetsSurvey {

    public void setNetAssetsSurvey(){

        Pages.netAssetsSurvey().setUnrestrictedNetAssets();

        Pages.netAssetsSurvey().setTotalLiabilitiesAndNetAssets1();
        Pages.netAssetsSurvey().setTotalLiabilitiesAndNetAssets2();
        Pages.netAssetsSurvey().setTotalLiabilitiesAndNetAssets3();
    }

}
