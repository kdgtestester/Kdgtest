package com.mediaspectrum.pages.booking.uieditor;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class FilesPage extends BasePage{
    public void waitForPageLoad(){
        Reporter.log("Waiting files page to load");
        waitForElementVisibility("pageLabel");
    }

    public void clickNextButton() {
        click("Clicking next button", "nextButton");
    }
}
