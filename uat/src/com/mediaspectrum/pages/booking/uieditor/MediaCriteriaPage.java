package com.mediaspectrum.pages.booking.uieditor;


import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class MediaCriteriaPage extends BasePage{

    public void waitForPageLoad(){
        Reporter.log("Waiting criteria page to load");
        waitForElementVisibility("pageLabel");
    }

    public void selectCategory(String category){
        selectDropDownListOptionByText("Selecting category : " + category, category, "categorySelector");
    }

    public void selectSubCategory(String subCategory){
        selectDropDownListOptionByText("Selecting sub category : " + subCategory, subCategory, "subCategorySelector");
    }

    public void clickSaveButtonAanSwitchToMainFrame() {
        click("Clicking save button", "saveButton");
        driver.switchTo().defaultContent();
    }
}
