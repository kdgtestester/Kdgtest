package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetInKindRevenueSurvey {

    public void setInKindRevenueSurvey(){

        Pages.inKindRevenueSurvey().setUnrestrictedInKindRevenueOperating();
        Pages.inKindRevenueSurvey().setTemporarilyRestrictedInKindRevenueOperating();
        Pages.inKindRevenueSurvey().setPermanentlyRestrictedInKindRevenueOperating();

        Pages.inKindRevenueSurvey().setUnrestrictedInKindRevenueNonOperating();
        Pages.inKindRevenueSurvey().setTemporarilyRestrictedInKindRevenueNonOperating();
        Pages.inKindRevenueSurvey().setPermanentlyRestrictedInKindRevenueNonOperating();

    }

}
