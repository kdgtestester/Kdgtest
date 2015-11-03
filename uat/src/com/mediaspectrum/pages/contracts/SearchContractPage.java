package com.mediaspectrum.pages.contracts;


import com.mediaspectrum.utils.CustomerData;
import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

import java.util.Base64;

public class SearchContractPage extends BasePage{
    public void waitForPageToLoad(){
        Reporter.log("Wait 'Search Contracts' page loads");
        waitForElementVisibility("pageLabel");
    }

    public void selectPartner(String companyName){
        type("Typing partner name : " + companyName, companyName, "searchByPartnerInput");
        waitForElementToBeClickable("dropdownOption", companyName);
        clickByXpathWithJS("Clicking on partner's company name : " + companyName, "dropdownOption", companyName);
    }

    public void clickSearchButton(){
        click("Clicking search button", "searchButton");
    }

    public void waitForSearchResults(String companyName){
        waitForElementVisibility("contractLinkByPartnerNamePattern", companyName);
    }

    public boolean isContractFound(String companyName){
        return isElementPresent("contractLinkByPartnerNamePattern", companyName);
    }

    public void clickContractLink(String companyName){
        waitForElementToBeClickable("contractLinkByPartnerNamePattern", companyName);
        click("Clicking contract link of partner : " + companyName, "contractLinkByPartnerNamePattern", companyName);
    }

}
