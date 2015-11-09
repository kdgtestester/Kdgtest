package com.cdpapp.pages;

import com.testmatick.base.BasePage;


public class ReportsRun extends BasePage {

    public void waitReportsRunHeader(){
        waitForElementVisibility("reportRunPageHeader");
    }

    public void waitAnnualReport(){
        waitForElementToBeClickable("annualReportType");
    }

    public void clickAnnualReport(){
        click("Select Annual type report", "annualReportType");
    }

    public void waitTrendReportType(){
        waitForElementToBeClickable("trendReportType");
    }

    public void clickTrendReport(){
        click("Select Trend type report", "trendReportType");
    }

    public void waitComparisonReportType(){
        waitForElementToBeClickable("comparisonReportType");
    }

    public void clickComparisonReport(){
        click("Select Comparison type report", "comparisonReportType");
    }

    public int getCountCheckReportType(){
        return getElements("checkTypeReport").size();
    }

}
