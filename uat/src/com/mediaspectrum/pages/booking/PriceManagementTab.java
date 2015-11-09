package com.mediaspectrum.pages.booking;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Constants;
import com.testmatick.utils.ListHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PriceManagementTab extends BasePage{

    public void waitPageToLoad(){
        waitForElementVisibility("rateButton");
    }

    public void clickRateButton(){
        click("Clicking rate button", "rateButton");
        waitForElementVisibility("rateDialogLabel");
    }

    public void selectAllProducts(){
        click("Clicking select all product checkbox", "selectAllProductsCheckbox");
        waitForElementVisibility("rateInput");
    }

    public void typeRate(String rate){
        typeWithWipe("Typing rate : " + rate, rate, "rateInput");
    }

    public boolean isRateInputEnable(){
        Reporter.log("Checking rate input enable");
        return !isElementHasAttribute("disabled", "rateInput");
    }

    public String getRateInputValue(){
        return getElementAttributeValue("Get rate input value", "value", "rateInput");
    }

    public void clickFreeCheckbox(){
        click("Clicking free checkbox", "freeCheckbox");
    }

    public void selectChangingRateReason(String reason){
        getElement("rateInput").sendKeys(Keys.RETURN);
        waitForElementToBeClickable("changeRateReason");
        click("Clicking on changing rate reason dropdown header", "changeRateReason");
        waitForElementToBeClickable("dropdownOption", reason);
        clickByXpathWithJS("Clicking dropdown option : " + reason, "dropdownOption", reason);
    }

    public void selectChangingRateDetails(String details){
        waitForElementToBeClickable("changeRateDetails");
        click("Clicking on changing rate details dropdown header", "changeRateDetails");
        waitForElementToBeClickable("dropdownOption", details);
        clickByXpathWithJS("Clicking dropdown option : " + details, "dropdownOption", details);
    }

    public void clickSaveChangesButton(){
        click("Clicking save changes button", "saveChangesButton");
        waitForElementInvisibility("loader");
    }

    public List<String> getForcedRateColor(){
        List<String> colors = new ArrayList<>();

        for(WebElement webElement : getElements("forcedValueField")){
            colors.add(webElement.getCssValue("color"));
        }

        return colors;
    }

    public List<String> getForcedRateValues(){
        List<String> values = new ArrayList<>();

        for(WebElement webElement : getElements("forcedValueField")){
            values.add(webElement.getText());
        }

        return values;
    }

    public void clickCloseChangeRateDialog(){
        click("Click close changing rat dialog", "closeDialogButton");
        waitForElementInvisibility("rateDialogLabel");
    }

    public List<String> getBaseChargeValues(String productName){

        List<String> values = new ArrayList<>();

        List<WebElement> expandedOrders = getElements("expandedOrders");
        for(WebElement order : expandedOrders){
            order.click();
            wait(5);
        }

         click("Clicking expand order info button of product : " + productName, "expandOrderButton", productName);
         waitForElementVisibility("baseChargePrice");

        for(WebElement webElement : getElements("baseChargePrice")){
            values.add(webElement.getText());
        }

        return values;
    }

    public List<String> getDiscountScaleValues(String productName){

        List<String> values = new ArrayList<>();

        if(!isElementPresent("discountScalePrice")){
            click("Clicking expand order info button", "expandOrderButton", productName);
        }

        if(!isElementPresent("discountScalePrice")) return values;

        for(WebElement webElement : getElements("discountScalePrice")){
            values.add(webElement.getText());
        }

        return values;
    }

    public void closeProductOrderInfo(String productName){
        click("Clicking expand order info button", "expandOrderButton", productName);
    }

    public void clickOrderInformationTab(){
        click("Clicking order information tab", "orderInformationTab");
    }

    public void clickSurchargeButton(){
        click("Clicking on surcharge button", "surchargeButton");
        waitForElementVisibility("surchargeDialogLabel");
    }

    public void appliySurcharge(String surchargeDescription){
        click("Select surcharge : " + surchargeDescription, "surchargeListItemByNamePattern", surchargeDescription);
        click("Clicking add surcharge button", "addSurchargeButton");
        waitForElementInvisibility("loader");
    }

    public boolean isSurchargeApplied(String surchargeDescription) {
        Reporter.log(String.format("Checking surcharge %s visibility", surchargeDescription));
        return isElementPresent("appliedSurchargeListByNamePattern", surchargeDescription);
    }

    public String getAppliedSurchargeAmount(String surchargeDescription, String productName){
        if(!isElementPresent("baseChargePrice")){
            wait(5);
            click("Clicking expand order info button", "expandOrderButton", productName);
            waitForElementVisibility("baseChargePrice");
        }

        return getElementText("Getting surcharge amount", "orderSurcharge", surchargeDescription);
    }

    public void clickAppliedSurcharge(String surchargeDescription){
        waitForElementToBeClickable("appliedSurchargeListByNamePattern", surchargeDescription);
        click("Clicking on applied surcharge : " + surchargeDescription, "appliedSurchargeListByNamePattern", surchargeDescription);
    }

    public void clickSaveSurchargeSettingsButton(){
        click("Clicking save surcharge changes button", "saveSurchargesChangesButton");
        waitForElementInvisibility("loader");
    }

    public void clickCloseSurchargeDialogButton() {
        waitForElementToBeClickable("closeSurchargesDialogButton");
        click("Clicking close surcharge dialog button", "closeSurchargesDialogButton");
    }

    public boolean isSurchargesPresentInOrder(String surchargeDescription, String productName){

        if(!isElementPresent("baseChargePrice")){
            click("Clicking expand order info button", "expandOrderButton", productName);
            waitForElementVisibility("baseChargePrice");
        }

        return isElementPresent("orderSurcharge", surchargeDescription);
    }

    public void clickSelectAllProductsForSurcharge(){
        click("Clicking select all products for surcharge checkbox", "selectAllProductsForSurchargeCheckbox");
        waitForElementVisibility("rateInput");
    }

    public boolean IsSaveSurchargesChangesButtonEnabled(){
        return isElementPresent("saveSurchargesChangesButtonEnabled");
    }

    public void selectSurchargeReason(String reason){
        getElement("rateInput").sendKeys(Keys.RETURN);
        waitForElementToBeClickable("surchargeReasonSelector");
        click("Clicking on changing surcharge reason dropdown header", "surchargeReasonSelector");
        waitForElementToBeClickable("dropdownOption", reason);
        clickByXpathWithJS("Clicking dropdown option : " + reason, "dropdownOption", reason);
    }

    public void selectSurchargeDetails(String details){
        waitForElementToBeClickable("surchargesDetailSelector");
        click("Clicking on changing surcharge details dropdown header", "surchargesDetailSelector");
        waitForElementToBeClickable("dropdownOption", details);
        clickByXpathWithJS("Clicking dropdown option : " + details, "dropdownOption", details);
    }

    public void selectRateType(String rateType){
        waitForElementToBeClickable("rateItemSelector");
        click("Clicking on changing surcharge rate item dropdown header", "rateItemSelector");
        waitForElementToBeClickable("dropdownOption", rateType);
        clickByXpathWithJS("Clicking dropdown option : " + rateType, "dropdownOption", rateType);
    }

    public boolean isRateTypeSelectorEnabled(){
        Reporter.log("Checking rate type selector enable");
        return !isElementHasAttribute("disabled", "rateItemSelector");
    }


    public String getRateTypeValue(){
        return getElementAttributeValue("Get rate type value", "title", "rateItemSelector");
    }

    public List<WebElement> getAvailableCheckboxesList(){
        Reporter.log("Getting available checkboxes list");
        return getElements("availableCheckboxes");
    }

    public int getCheckedCheckboxesCount(){
        Reporter.log("Getting checked checkboxes count");
        return getElementsCount("checkedCheckboxes");
    }

    public boolean isSurchargeButtonEnable(){
        Reporter.log("Checking surcharge button availability");
        return !isElementHasAttribute("disabled", "surchargeButton");
    }

    public boolean isRateButtonEnable(){
        Reporter.log("Checking rate button availability");
        return !isElementHasAttribute("disabled", "rateButton");
    }

    public void selectViewAs(String viewer){
        waitForElementToBeClickable("viewAsSelector");
        click("Clicking on view as dropdown header", "viewAsSelector");
        waitForElementToBeClickable("dropdownOption", viewer);
        clickByXpathWithJS("Clicking dropdown option : " + viewer, "dropdownOption", viewer);
    }

    public String getViewAsSelectorValue(){
        return getElementAttributeValue("Getting view as selector value", "title", "viewAsSelector");
    }

    public boolean isProductCheckboxVisible(String productName){
        Reporter.log("Checking checkbox visibility near product : " + productName);
        return isElementVisible("productCheckboxByName", productName);
    }

    public void clickProductCheckbox(String productName){
        click("Checking checkbox visibility near product : " + productName, "productCheckboxByName", productName);
    }

    public String getContractDiscountValue(){
        return getElementAttributeValue("Getting contract discount value", "value", "contractDiscount");
    }

    public String getDiscountContractName(){
        return getElementAttributeValue("Getting discount contract name", "title", "discountContractSelector");
    }

    public boolean isSurchargesListSorted(){

        Reporter.log("Checking surcharges sort order");
        List<WebElement> webElements = getElements("availableSurcharges");
        List<String> elementsText = new ArrayList<>();
        for(WebElement webElement : webElements){ elementsText.add(webElement.getText()); }

        return ListHelper.isSorted(elementsText);
    }

    public boolean isRateTypesCorrect(){
        click("Clicking on rate type dropdown header", "rateItemSelector");
        for(String partnerType : Constants.DEFAULT_RATE_TYPES){
            if(!isElementPresent("dropdownOption", partnerType)) return false;
        }
        return true;
    }

    public void setCalculationCheckboxState(boolean state){
        if(isCheckboxChecked("calculationCheckbox") != state)
            click("Set calculation checkbox state : " + state, "calculationCheckboxLink");
    }

    public String getDiscountAmount(String productName){
        if(!isElementPresent("discountScalePrice")){
            click("Clicking expand order info button", "expandOrderButton", productName);
        }
        return getElementText("Getting discount amount", "discountAmount");
    }

    public void clickShowCorrectivesLink(String productName){
        if(!isElementPresent("showCorrectivesLinkByProductNamePattern", productName)){
            click("Clicking expand order info button", "expandOrderButton", productName);
        }

        click("Clicking show correctives link", "showCorrectivesLinkByProductNamePattern", productName);
        waitForElementVisibility("correctivesFrame");
    }

    public String getSurchargeAmount(String productName){
        if(!isElementPresent("surchargeAmountTextbox")){
            click("Clicking expand order info button", "expandOrderButton", productName);
        }

        return getElementText("Getting surcharge amount to product " + productName, "surchargeAmountTextbox");

    }


    public void switchToCorrectivesFrame(){
        swithToFrame("Switching to correctives frame", "correctivesFrame");
    }

    public void expandCorrectiveItem(){
        if(!isElementVisible("correctivesFrame")) click("Clicking expand corrective button", "expandContractAdjustmentCorrectiveLik");
    }

    public String getCorrectiveOldPriceDiscountValue(){
        return getElementText("Getting corrective old price discount value", "oldPriceDiscountValueTextbox");
    }

    public String getCorrectiveNewPriceDiscountValue(){
        return getElementText("Getting corrective new price discount value", "newPriceDiscountValueTextbox");
    }

    public String getCorrectiveOldAmountDiscountValue(){
        return getElementText("Getting corrective old amount discount value", "oldAmountDiscountValueTextbox");
    }

    public String getCorrectiveNewAmountDiscountValue(){
        return getElementText("Getting corrective new amount discount value", "newAmountDiscountValueTextbox");
    }

    public String getCorrectiveDiffAmountDiscountValue(){
        return getElementText("Getting corrective old price discount value", "diffAmountDiscountValueTextbox");
    }

    public void closeCorrectivesFrame(){
        driver.switchTo().defaultContent();
        click("Clicking close corrective dialog button", "closeCorrectivesDialogButton");
    }

    public boolean isCorrectiveGenerated(){
        Reporter.log("Checking correctives present");
        return isElementVisible("correctivesItem");
    }
}
