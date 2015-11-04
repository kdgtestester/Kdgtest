package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class RunReportsActions {

    public void runReport(){
        Pages.dashboard().waitModalBody();

        Pages.dashboard().waitReportsTab();
        Pages.dashboard().clickReportsTab();

        Pages.reports().waitReportHeader();
        Pages.reports().waitRunReportsButton();
        Pages.reports().clickRunReportsButton();

        Pages.reportsRun().waitReportsRunHeader();

    }

    public void waitAndClickReports(){

    }

}
