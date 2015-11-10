package com.cdpapp.control;

import com.cdpapp.pages.*;


public class Pages {
    private static Pages pages;

    private LoginPage loginPage;
    private GoogleAuthPage googleAuthPage;
    private Dashboard dashboard;
    private OrganizationSetup organizationSetup;
    private ProfileWizard profileWizard;
    private Reports reports;
    private ReportsRun reportsRun;
    private SurveySetProperties surveySetProperties;

    private Pages() {
        this.loginPage = new LoginPage();
        this.googleAuthPage = new GoogleAuthPage();
        this.dashboard = new Dashboard();
        this.organizationSetup = new OrganizationSetup();
        this.profileWizard = new ProfileWizard();
        this.reports = new Reports();
        this.reportsRun = new ReportsRun();
        this.surveySetProperties = new SurveySetProperties();
    }

    public static void setupPages() {
        pages = new Pages();
    }

    public static LoginPage loginPage() {
        return pages.loginPage;
    }
    public static GoogleAuthPage googleAuthPage(){
        return pages.googleAuthPage;
    }
    public static Dashboard dashboard(){
        return pages.dashboard;
    }
    public static OrganizationSetup organizationSetup(){
        return pages.organizationSetup;
    }
    public static ProfileWizard profileWizard(){
        return pages.profileWizard;
    }
    public static Reports reports(){return pages.reports;}
    public static ReportsRun reportsRun(){return pages.reportsRun;}
    public static SurveySetProperties surveySetSetting(){return pages.surveySetProperties;}
}
