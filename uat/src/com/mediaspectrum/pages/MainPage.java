package com.mediaspectrum.pages;


import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Constants;


public class MainPage extends BasePage {

    public void openPage() {
        Reporter.log("Opening main page");
        driver.get("https://qad-xentivesales.mediaspectrum.net/adsalespro/controller/home");
    }

    public void clickCustomersTab() {
        click("Clicking partners tab", "customersTab");
    }

    public void typeCustomerNameToFilter(String customerName) {
        type("Typing customer name to filter", customerName, "customerNameInSearchFilter");
    }

    public void clickSearchButton() {
        click("Clicking search button", "searchButton");
    }

    public void waitForAllCustomersLoaded() {
        waitForElementPresent("allCustomersLoaded");
    }

    public void clickAdvancedBookingLink() {
        //works only for filtered and unfurled customer
        waitForElementVisibility("advancedBookingLink");
        waitForElementToBeClickable("advancedBookingLink");
        wait(Constants.ELEMENT_MICRO_TIMEOUT_SECONDS);
        click("Clicking advanced booking link", "advancedBookingLink");
        switchToNewTab();
    }

}
