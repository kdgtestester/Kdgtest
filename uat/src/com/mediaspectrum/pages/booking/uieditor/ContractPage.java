package com.mediaspectrum.pages.booking.uieditor;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;

public class ContractPage extends BasePage{
    public void waitForPageLoad(){
        Reporter.log("Waiting contacts page to load");
        waitForElementVisibility("pageLabel");
    }

    public void clickNextButton() {
        click("Clicking next button", "nextButton");
    }
}
