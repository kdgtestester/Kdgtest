package com.cdpapp.pages.completesurvey.revenue;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class NonOperatingRevenueSurvey extends BasePage {

    public void setUnrestrictedTransfersAndReclassifications(){
        type("Set Unrestricted Transfers and Reclassifications", "1", "unrestrictedTransfersReclassifications");
    }

    public void setTemporarilyRestrictedTransfersAndReclassifications(){
        type("Set Temporarily Restricted Transfers and Reclassifications", "1", "temporarilyRestrictedTransfersReclassifications");
    }

    public void setPermanentlyRestrictedTransfersAndReclassifications(){
        type("Set Permanently Restricted Transfers and Reclassifications", "1", "permanentlyRestrictedTransfersReclassifications");
    }

    public void setUnrestrictedPriorPeriodAdjustments(){
        type("Set Unrestricted Prior Period Adjustments", "1", "unrestrictedPriorPeriodAdjustments");
    }

    public void setTemporarilyRestrictedPriorPeriodAdjustments(){
        type("Set Temporarily Restricted Prior Period Adjustments", "1", "temporarilyRestrictedPriorPeriodAdjustments");
    }

    public void setPermanentlyRestrictedPriorPeriodAdjustments(){
        type("Set Permanently Restricted Prior Period Adjustments", "1", "permanentlyRestrictedPriorPeriodAdjustments");
    }

    public void setUnrestrictedOtherNonOperatingRevenue(){
        type("Set Unrestricted Other Non-Operating revenue", "1", "unrestrictedOtherNonOperatingRevenue");
    }

    public void setTemporarilyRestrictedOtherNonOperatingRevenue(){
        type("Set Temporarily Restricted Other Non-Operating revenue", "1", "temporarilyRestrictedOtherNonOperatingRevenue");
    }

    public void setPermanentlyRestrictedOtherNonOperatingRevenue(){
        type("Set Permanently Restricted Other Non-Operating revenue", "1", "permanentlyRestrictedOtherNonOperatingRevenue");
    }

    public void setUnrestrictedNonOperatingNetAssetsReleasedFromRestriction(){
        type("Set Unrestricted Non-Operating Net Assets Released from Restriction", "1", "unrestrictedNonOperatingNetAssetsReleasedRestriction");
    }

    public void setTemporarilyRestrictedNonOperatingNetAssetsReleasedFromRestriction(){
        type("Set Temporarily Restricted Non-Operating Net Assets Released from Restriction", "1", "temporarilyRestrictedNonOperatingNetAssetsReleasedRestriction");
    }

    public void setPermanentlyRestrictedNonOperatingNetAssetsReleasedFromRestriction(){
        type("Set Permanently Restricted Non-Operating Net Assets Released from Restriction", "1", "permanentlyRestrictedNonOperatingNetAssetsReleasedRestriction");
    }

}
