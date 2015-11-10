package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetNonOperatingRevenueSurvey {

    public void setNonOperatingRevenueSurvey(){
        Pages.nonOperatingRevenueSurvey().setUnrestrictedTransfersAndReclassifications();
        Pages.nonOperatingRevenueSurvey().setTemporarilyRestrictedTransfersAndReclassifications();
        Pages.nonOperatingRevenueSurvey().setPermanentlyRestrictedTransfersAndReclassifications();

        Pages.nonOperatingRevenueSurvey().setUnrestrictedPriorPeriodAdjustments();
        Pages.nonOperatingRevenueSurvey().setTemporarilyRestrictedPriorPeriodAdjustments();
        Pages.nonOperatingRevenueSurvey().setPermanentlyRestrictedPriorPeriodAdjustments();

        Pages.nonOperatingRevenueSurvey().setUnrestrictedOtherNonOperatingRevenue();
        Pages.nonOperatingRevenueSurvey().setTemporarilyRestrictedOtherNonOperatingRevenue();
        Pages.nonOperatingRevenueSurvey().setPermanentlyRestrictedOtherNonOperatingRevenue();

        Pages.nonOperatingRevenueSurvey().setUnrestrictedNonOperatingNetAssetsReleasedFromRestriction();
        Pages.nonOperatingRevenueSurvey().setTemporarilyRestrictedNonOperatingNetAssetsReleasedFromRestriction();
        Pages.nonOperatingRevenueSurvey().setPermanentlyRestrictedNonOperatingNetAssetsReleasedFromRestriction();
    }

}
