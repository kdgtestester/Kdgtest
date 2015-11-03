package com.cdpapp.pages;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;

public class Reports extends BasePage {

    public void waitReportHeader(){
        waitForElementVisibility("reportPageHeader");
    }

    public void waitRunReportsButton(){
        waitForElementToBeClickable("runReportsButton");
    }

    public void clickRunReportsButton(){
        click("Click \"Run a report\" button", "runReportsButton");
    }

}
