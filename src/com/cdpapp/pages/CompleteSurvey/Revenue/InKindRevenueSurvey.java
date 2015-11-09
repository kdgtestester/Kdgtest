package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class InKindRevenueSurvey extends BasePage {

    public void setUnrestrictedInKindRevenueOperating(){
        type("Set unrestricted In-Kind Revenue Operating", "1", "unrestrictedFieldInKindRevenueOperating");
    }

    public void setTemporarilyRestrictedInKindRevenueOperating(){
        type("Set Temporarily Restricted In-Kind Revenue Operating", "1", "temporarilyUnrestrictedFieldInKindRevenueOperating");
    }

    public void setPermanentlyRestrictedInKindRevenueOperating(){
        type("Set Permanently Restricted In-Kind Revenue Operating", "1", "permanentlyUnrestrictedFieldInKindRevenueOperating");
    }

    public void setUnrestrictedInKindRevenueNonOperating(){
        type("Set unrestricted In-Kind Revenue - Non-Operating", "1", "unrestrictedFieldInKindRevenueNonOperating");
    }

    public void setTemporarilyRestrictedInKindRevenueNonOperating(){
        type("Set Temporarily Restricted In-Kind Revenue - Non-Operating", "1", "temporarilyUnrestrictedFieldInKindRevenueNonOperating");
    }

    public void setPermanentlyRestrictedInKindRevenueNonOperating(){
        type("Set Permanently Restricted In-Kind Revenue - Non-Operating", "1", "permanentlyUnrestrictedFieldInKindRevenueNonOperating");
    }

}
