package com.mediaspectrum.pages.contracts;


import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Random;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SearchCreateContractPage extends BasePage {

    public void waitForPageLoad(){
        Reporter.log("Wait for search create contracts page to load");
        waitForElementToBeClickable("partnerSelector");
    }

    public void selectPartner(String partnerName){
        waitForElementToBeClickable("partnerSelector");
        type("Typing partner name : " + partnerName, partnerName, "partnerSelector");
        waitForElementToBeClickable("dropdownOption", partnerName);
        clickByXpathWithJS("Clicking on partner name : " + partnerName, "dropdownOption", partnerName );
    }

    public void clearPartnerField(){
        waitForElementToBeClickable("partnerSelector");
        Reporter.log("Clearing partner field.");
        getElement("partnerSelector").clear();
    }

    public void selectProduct(String productName, String productUniqueID){
        waitForElementToBeClickable("productSelector");
        type("Typing product name : " + productName, productName, "productSelector");
        waitForElementToBeClickable("productNameWithUniqueID", productName, productUniqueID);
        clickByXpathWithJS("Clicking on partner name : " + productName, "productNameWithUniqueID", productName, productUniqueID);
    }

    public void selectRandomDate(){
        click("Clicking on dates button", "dateBoxButton");
        waitForElementInvisibility("monthSelector");

        List<WebElement> elements = getElements("activeDatesLink");
        elements.get(Random.genInt(0, elements.size())).click();
    }

    public void clickSearchButton() {
        waitForElementToBeClickable("searchButton");
        click("Clicking search button", "searchButton");
        waitForElementVisibility("discountScaleList");
    }

    public void highlightDiscountScale(){
        waitForElementToBeClickable("discountScaleItem");
        click("Clicking on discount scale element", "discountScaleItem");
        waitForElementVisibility("createContractButton");
    }

    public void clickCreateContractButton(){
        waitForElementToBeClickable("createContractButton");
        click("Clicking create contract button", "createContractButton");
        waitForElementVisibility("assignmentNameInput");
    }

    public void typeAssignmentName(String name){
        type("Typing assignment name : " + name, name, "assignmentNameInput");
    }

    public void selectDiscountScaleLevel(String discountLevel){
        waitForElementToBeClickable("discountLevelSelector");
        click("Clicking on discount scale level header", "discountLevelSelector");
        waitForElementToBeClickable("dropdownOption", discountLevel);
        clickByXpathWithJS("Clicking on discount level : " + discountLevel, "dropdownOption", discountLevel);
    }

    public void clickSaveContractButton(){
        waitForElementToBeClickable("saveContractButton");
        click("Clicking save contract level", "saveContractButton");
        waitForElementInvisibility("savingIsInProgressMessage");
        waitForElementVisibility("assignmentNameInput");
    }

    public boolean isContractStatusDraft(){
        Reporter.log("Checking contract status");
        return getElementText("Getting page label text", "pageLabel").contains("Draft");
    }

    public boolean isErrorsPresent(){
        Reporter.log("Checking errors visibility");
        return isElementVisible("errors");
    }

    public int getErrorsCount(){
        Reporter.log("Getting errors count");
        return getElementsCount("errors");
    }

    public void typeNotes(String description){
        type("Typing notes : " + description, description, "descriptionInput");
    }

    public void clickHoldingInformationHeader() {
        waitForElementToBeClickable("holdingInformationHeader");
        click("Clicking on holding information header", "holdingInformationHeader");
    }

    public void clickFinalAdjustmentHeader() {
        waitForElementToBeClickable("finalAdjustmentHeader");
        click("Clicking on final adjustment header", "finalAdjustmentHeader");
    }

    public Boolean isHoldingContractCheckboxVisible(){
        Reporter.log("Checking holding contract checkbox visibility");
        return isElementVisible("holdingContractCheckbox");
    }


    public Boolean isFollowHoldingRulesCheckboxVisible(){
        Reporter.log("Checking follow holdingRules checkbox visibility");
        return isElementVisible("followHoldingRulesCheckbox");
    }

    public Boolean isStandardFinalAdjustmentCheckboxVisible(){
        Reporter.log("Checking standard final adjustment checkbox visibility");
        return isElementVisible("standardFinalAdjustmentCheckbox");
    }
    public Boolean isWithCorrectivesCheckboxVisible(){
        Reporter.log("Checking with correctives checkbox visibility");
        return isElementVisible("withCorrectivesCheckbox");
    }

    public void setStandardFinalAdjustmentCheckboxState(boolean state){
        setCheckboxState("Set standard final adjustment checkbox state : " + state, state, "standardFinalAdjustmentCheckbox");
    }

    public Boolean isWithCorrectivesCheckboxEnable(){
        Reporter.log("Checking with correctives checkbox availability");
        return !isElementHasAttribute("disabled", "withCorrectivesCheckbox");
    }

    public void selectFirstMonthDay(Calendar conditionDate){
        click("Clicking on dates button", "dateBoxButton");
        waitForElementInvisibility("monthSelector");

        click(String.format("Select the first day of moth %s, year: %d", conditionDate.getDisplayName
                        (Calendar.MONTH, Calendar.LONG, Locale.US), conditionDate.get(Calendar.YEAR)), "firstDayOfMonthLink",
                conditionDate.get(Calendar.YEAR), conditionDate.get(Calendar.MONTH));
    }

    public void clickApproveButton(){
        waitForElementToBeClickable("approveButton");
        click("Clicking approve button", "approveButton");
        waitForElementVisibility("pageLabel");
    }

}
