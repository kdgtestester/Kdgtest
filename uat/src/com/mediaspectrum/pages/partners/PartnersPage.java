package com.mediaspectrum.pages.partners;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class PartnersPage extends BasePage {

    public void waitForPageToLoad() {
        Reporter.log("Waiting for Customers page to load");
        waitForElementPresent("customersTable");
    }

    public void clickCreatePartnerButton(){
        click("Clicking create partner button", "createPartnerButton");
    }

    public void typeCompanyName(String companyName) {
        super.type("Typing searching company name :"+companyName, companyName, "searchNameInput");
    }

    public void clickSearchButton() {
        click("Clicking on search button", "searchButton");
        waitForElementInvisibility("searchResultsLoader");
        waitForElementPresent("customersTable");
    }

    public void clickAdvancedBookingLink() {
        super.waitForElementToBeClickable("tableAdvancedBookingLink");
        super.click("Clicking on Advanced Booking link", "tableAdvancedBookingLink");
        wait(10); //todo temporary
        switchToNewTab();
    }

    public boolean isPartnerFound(String content){
        Reporter.log(String.format("Checking partner with content %s is present in search results", content));
        return isElementPresent("tableRowByContentPattern", content);
    }

    public boolean isPartnerItemExpanded(String content){
        return getElementAttributeValue("Checking partner item expanded", "class", "tableRowByContentPattern", content).contains("expanded");
    }

    public void expandPartnerItem(String content){
        click("Click expand partner item arrow", "expandPartnerItemArrowByContent", content);
        waitForElementVisibility("tableAdvancedBookingLink");
    }

    public void typePartnerID(String partnerID){
        type("Typing partner id : " + partnerID, partnerID, "searchPartnerIDInput");
    }

    public void clickPartnerLink(String partnerIdentification){
        click("Clicking on partner link by content : " + partnerIdentification,
                "partnerLinkByItemContentPartner", partnerIdentification);
    }

    public void selectProfitCenter(String profitCenterName){
        waitForElementPresent("switchCompanySelector");
        click("Click on profit center dropdown header", "switchCompanySelector");
        waitForElementVisibility("dropdownOption", profitCenterName);
        clickByXpathWithJS("Clicking dropdown option " + profitCenterName, "dropdownOption", profitCenterName);
    }
}
