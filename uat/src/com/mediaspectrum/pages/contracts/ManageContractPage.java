package com.mediaspectrum.pages.contracts;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;

public class ManageContractPage extends BasePage{
    public void waitForPageToLoad(){
        Reporter.log("Wait for 'Manage contract' loads");
        waitForElementVisibility("pageLabel");
    }

    public String getPrintedInsertionOrderId(){
        return getInnerHTML("Getting printed insertion order id", "insertionsOrderIDTextBox");
    }

    public String getAppliedDiscountValue(){
        return getElementText("Getting applied discount value", "appliedDiscountTextbox");
    }

    public void clickRunAdjustmentCheckbox(){
        click("Clicking run adjustment checkbox", "runAdjustmentCheckbox");
        waitForElementVisibility("adjustmentFormLabel");
    }

    public void clickIntermediateAdjustment(){
        click("Cliking intermediate adjustment", "intermediateAdjustmentRadioButton");
    }

    public void setGenerateCorrectivesCheckboxState(boolean state){
        setCheckboxState("Set generate correctives checkbox state : " + state, state, "generateCorrectivesCheckbox");
    }

    public void selecrDiscountLevel(String discountLevel){
        click("Clicking on discount levels dropdown header", "discountLevelSelector");
        waitForElementVisibility("dropdownOption", discountLevel);
        clickByXpathWithJS("Clicking on discount level : " + discountLevel, "dropdownOption", discountLevel);
    }

    public void selectDefaultAdjustmentDate(){
        click("Clicking adjustment date picked button", "adjustmentDatePickerButton");
        waitForElementToBeClickable("todayDateItem");
        click("Clicking today date", "todayDateItem");
        click("Clicking done button", "closeDatePickerFormButton");
    }

    public void typeAdjustmentNotes(String notes){
        type("Typing notes : " + notes, notes, "adjustmentNotesInput");
    }

    public void clickSaveChangesButton(){
        click("Clicking save button", "saveChangesButton");
    }

    public void refreshPage(){
        reloadPage();
        waitForPageToLoad();
    }

    public void clickAdjustmentHistoryTab() {
        click("Clicking Adjustment History tab", "adjustmentHistory");
    }

    public boolean isDownloadLinkVisible(){
        return isElementVisible("downloadLink");
    }

    public String getOldDiscount(){
        return getElement("oldDiscount").getText();
    }

    public String getNewDiscount(){
        return getElement("newDiscount").getText();
    }

}
