package com.cdpapp.pages;

import com.testmatick.base.BasePage;

public class SurveySetProperties extends BasePage {

    public void waitGridViewButton(){
        waitForElementToBeClickable("gridViewButton");
    }

    public void clickGridViewButton(){
        click("Switch to grid view", "gridViewButton");
    }

    public void clickContinueButton(){
        click("Switch to grid view", "gridViewButton");
    }

}
