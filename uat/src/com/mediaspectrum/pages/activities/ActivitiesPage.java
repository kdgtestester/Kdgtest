package com.mediaspectrum.pages.activities;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class ActivitiesPage extends BasePage {

    public void waitPageToLoad(){
        Reporter.log("Waiting activities page loads");
        waitForElementVisibility("pageLabel");
        waitForElementToBeClickable("profitCenterSelector");
    }

    public String getFilteredByUsername(){
        return getElementAttributeValue("Getting filtered by username", "value", "filteredByInput");
    }

    public boolean isActivitiesPresent(){
        Reporter.log("Checking activities availability.");
        return getElementsCount("userActivityCalendarItem") > 0;
    }
}
