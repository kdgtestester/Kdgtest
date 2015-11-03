package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class RunReportsActions {

    public void runReport(){
        Pages.dashboard().modalBody();

        Pages.dashboard().waitReportsTab();
        Pages.dashboard().clickReportsTab();

        Pages.reports().waitReportHeader();
        Pages.reports().waitRunReportsButton();
        Pages.reports().clickRunReportsButton();

        Pages.reportsRun().waitReportsRunHeader();

        waitAndClickReports();
    }

    public void waitAndClickReports(){
        Pages.reportsRun().waitAnnualReport();
        Pages.reportsRun().clickAnnualReport();

        Pages.reportsRun().waitTrendReportType();
        Pages.reportsRun().clickTrendReport();

        Pages.reportsRun().waitComparisonReportType();
        Pages.reportsRun().clickComparisonReport();
    }

}
