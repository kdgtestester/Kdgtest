package com.mediaspectrum.pages.partners;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;
import com.qatestlab.utils.Constants;

public class CreatePartnerPage extends BasePage {

    public void waitForPageToLoad() {
        Reporter.log("Waiting for Create Customers page to load");
        waitForElementVisibility("customerTypeDropdown");
    }

    public void waitCreatedCustomerPageToLoad(){
        waitForElementVisibility("generalFormHeader");
    }

    public void selectCustomerType(String customerType) {
        click("Clicking on customer type dropdown header", "customerTypeDropdown");
        click("Select customer type: "+customerType, "dropdownOption", customerType);
        waitForElementVisibility("companyNameInput");
    }

    public boolean isPartnersTypesListCorrect(){
        waitForElementToBeClickable("customerTypeDropdown");
        click("Clicking on customer type dropdown header", "customerTypeDropdown");
        for(String partnerType : Constants.DEFAULT_PARTNERS_TYPES){
            if(!isElementPresent("dropdownOption", partnerType)) return false;
        }

        return true;
    }

    public void typeCompanyName(String companyName){
        type("Typing company name :" + companyName, companyName, "companyNameInput");
    }

    public void selectCountry(String country){
        click("Clicking on country dropdown header", "countrySelector");
        waitForElementPresent("extendedDropdownOption", country);
        clickByXpathWithJS("Select country: " + country, "extendedDropdownOption", country);
    }

    public void typeRegion(String region){
        type("Typing region :" + region, region, "regionInput");
    }

    public void typeStreet(String street){
        type("Typing street :"+street, street, "streetInput");
    }

    public String getPartnerStreet() {
        return getElementAttributeValue("Getting partner street value", "value", "streetInput");
    }

    public boolean isStreetFieldVisible(){
        Reporter.log("Checking street input field visibility");
        return isElementVisible("streetInput");
    }

    public void typeStreetNumber(String streetNumber){
        type("Typing street number :" + streetNumber, streetNumber, "streetNumberInput");
    }

    public void typeZip(String zip){
        type("Typing zip :"+zip, zip, "zipInput");
    }

    public void typeCity(String city){
        type("Typing city :" + city, city, "cityInput");
    }

    public void selectPhoneType(String phoneType){
        click("Clicking on phone type header", "phoneTypeSelector");
        waitForElementPresent("extendedDropdownOption", phoneType);
        click("Select phone type: " + phoneType, "extendedDropdownOption", phoneType);
    }

    public void typePhoneNumber(String phoneNumber){
        type("Typing phone number :" + phoneNumber, phoneNumber, "phoneNumberInput");
    }

    public void clickMarketingDataTab(){
        click("Clicking marketing data tab", "marketingTab");
        waitForElementVisibility("marketingBrunchSelector");
    }

    public void selectMarketingBranch(String marketingBranch){
        click("Clicking on marketing brunch dropdown header", "marketingBrunchSelector");
        click("Select marketing branch: " + marketingBranch, "dropdownOption", marketingBranch);
    }

    public void selectMarketingSegment(String marketingSegment){
        click("Clicking on marketing segment dropdown header", "marketingSegmentSelector");
        click("Select marketing segment: "+marketingSegment, "dropdownOption", marketingSegment);
    }

    public void selectMarketingClassification(String marketingClassification){
        click("Clicking on marketing classification dropdown header", "marketingClassificationSelector");
        click("Select marketing segment: " + marketingClassification, "dropdownOption", marketingClassification);
    }

    public void clickSaveCustomerButton(){
        click("Clicking save partner button", "saveCustomerButton");
        waitForElementPresent("blockUI");
        waitForElementNotPresent("blockUI");
        waitForElementVisibility("generalFormHeader");
    }

    public boolean isPartnerIDEmpty(){
        return getElementText("Checking partner id content", "customerIDField").isEmpty();
    }

    public boolean isCompanyHRInformationEmpty(){
        return getElementText("Checking company HR information content", "companyHRInformationField").isEmpty();
    }

    public boolean isCompanyFoundingYearEmpty(){
        return getElementText("Checking company foundation year content", "companyFoundingYear").isEmpty();
    }


    public String getCustomerID(){
        return getElementText("Getting customer ID", "customerIDField");
    }

    public void clickSpecificInfoTab() {
        click("Clicking specific information tab", "specificInfoTab");
        waitForElementVisibility("profitCenterSelector");
    }

    public void selectProfitCenter(String profitCenterName){
        type("Typing profit center name : " + profitCenterName, profitCenterName, "profitCenterSelector");
        waitForElementToBeClickable("dropdownOption", profitCenterName);
        click("Clicking on profit center : " + profitCenterName, "dropdownOption", profitCenterName);
    }

    public void selectAgency(String agencyName){
        type("Typing agency name : " + agencyName, agencyName, "advertiserAgencySelector");
        waitForElementToBeClickable("dropdownOption", agencyName);
        click("Clicking agency center : " + agencyName, "dropdownOption", agencyName);
    }

    public void clickGeneralInfoTab() {
        click("Clicking generic information tab", "genericInfoTab");
        waitForElementVisibility("generalFormHeader");
    }

    public boolean isMWSTRulesListCorrect(){
        click("Clicking on mwst rules selector", "mwstRuleSelector");
        waitForElementToBeClickable("dropdownOption", "Standard Rate");

        if(!isElementVisible("dropdownOption", "Standard Rate with exceptions") ||
                !isElementVisible("dropdownOption", "Exempt (National Customer)")){
            return false;
        }
        click("Clicking MWST rule standart", "dropdownOption", "Standard Rate");
        return true;
    }

    public boolean isViewContactsLinkVisible(){
        Reporter.log("Checking view contacts link visibility");
        return isElementPresent("viewContactsLink");
    }

    public boolean isViewContractsLinkVisible(){
        Reporter.log("Checking view contracts link visibility");
        return isElementPresent("viewContractsLink");
    }

    public boolean isViewCampaignsLinkVisible(){
        Reporter.log("Checking view campaigns link visibility");
        return isElementPresent("viewCampaignsLink");
    }

    public boolean isViewActivitiesHistoryLinkVisible(){
        Reporter.log("Checking view activities history link visibility");
        return isElementPresent("viewActivitiesHistoryLink");
    }

    public boolean isProfileHistoryLinkVisible(){
        Reporter.log("Checking view profile history link visibility");
        return isElementPresent("profileHistoryLink");
    }

    public boolean isAdvancedBookingLinkVisible(){
        Reporter.log("Checking advanced booking link visibility");
        return isElementPresent("advancedBookingLink");
    }

    public void clickLaPostValidationButton(){
        click("Clicking La Post validation button", "laPostValidationButton");
    }

    public boolean isErrorsPresent(){
        Reporter.log("Checking errors caused.");
        return getElementsCount("errors") > 0;
    }

    public void clickAddPartnerModificationRequestLink(){
        waitForElementToBeClickable("addPartnerModificationRequestLink");
        try {
            waitForElementPresent("blockUI");
            waitForElementNotPresent("blockUI");
        }
        catch (Exception e)
        {}
        click("Clicking add partner modification request link", "addPartnerModificationRequestLink");
    }

    public void selectModificationRequestType(String requestType){
        waitForElementToBeClickable("requestTypeSelector");
        click("Clicking modification request type selector", "requestTypeSelector");
        waitForElementToBeClickable("dropdownOption", requestType);
        click("Clicking on requst type : " + requestType, "dropdownOption", requestType);
    }

    public void typeRequestDescription(String requestDescription){
        type("Typing request description", requestDescription, "requestDescriptionInput");
    }

    public String getCustomerStatus(){
        return getElementText("Getting customer status", "customerStatusField");
    }

    public void processRequest(String requestType, String processAs){
        click("Clicking on unprocessed request with type : " + requestType,
                "unprocessedModificationRequestItemByTypePattern", requestType);

        waitForElementToBeClickable("processedOptionSelector");
        click("Clicking process ", "processedOptionSelector");
        waitForElementToBeClickable("dropdownOption", processAs);
        click("Clicking on process as : " + processAs, "dropdownOption", processAs);
    }

    public void waitModificationRequestItem(String requestType){
        Reporter.log("Wait modification item appears");
        waitForElementVisibility("modificationRequestItemByTypePattern", requestType);
    }

    public boolean isRequestInProcessingState(String requestType){
        Reporter.log("Checking modification request presentation");
        return isElementPresent("unprocessedModificationRequestItemByTypePattern", requestType);
    }

    public void clickAddAddressFormButton(){
        click("Clicking add addresses button", "addAddressLink");
    }

    public void selectAddressType(String addressType){
        waitForElementToBeClickable("addressTypeSelector");
        click("Clicking address dropdown header", "addressTypeSelector");
        waitForElementToBeClickable("dropdownOption", addressType);
        click("Clicking on address type : " + addressType, "dropdownOption", addressType);
    }

    public void clickFinancialDataTab(){
        click("Clicking financial data tab", "financialTab");
        waitForElementVisibility("creditBlockedCheckbox");
    }

    public void setCreditBlockedCheckboxState(boolean state){
        setCheckboxState("Set checkbox state " + state, state, "creditBlockedCheckbox");
    }

    public void typeCreditLimit(String limit){
        type("Typing credit limit : " + limit, limit, "creditLimitInput");
    }
}
