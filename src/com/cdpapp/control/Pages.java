package com.cdpapp.control;

import com.cdpapp.pages.*;
import com.cdpapp.pages.completesurvey.expense.PaymentsArtistsAndPerformersSurvey;
import com.cdpapp.pages.completesurvey.expense.PersonnelExpensesSurvey;
import com.cdpapp.pages.completesurvey.revenue.*;


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

    private EarnedRevenueSurvey earnedRevenueSurvey;
    private MembershipSurvey membershipSurvey;
    private ContributedRevenueSurvey contributedRevenueSurvey;
    private ContributorsSurvey contributorsSurvey;
    private SpecialEventsSurvey specialEventsSurvey;
    private InKindRevenueSurvey inKindRevenueSurvey;
    private InKindRevenueDetailsSurvey inKindRevenueDetailsSurvey;
    private InvestmentIncomeSurvey investmentIncomeSurvey;
    private NonOperatingRevenueSurvey nonOperatingRevenueSurvey;

    private PersonnelExpensesSurvey personnelExpensesSurvey;
    private PaymentsArtistsAndPerformersSurvey paymentsArtistsAndPerformersSurvey;

    private Pages() {
        this.loginPage = new LoginPage();
        this.googleAuthPage = new GoogleAuthPage();
        this.dashboard = new Dashboard();
        this.organizationSetup = new OrganizationSetup();
        this.profileWizard = new ProfileWizard();
        this.reports = new Reports();
        this.reportsRun = new ReportsRun();
        this.surveySetProperties = new SurveySetProperties();

        this.earnedRevenueSurvey = new EarnedRevenueSurvey();
        this.membershipSurvey = new MembershipSurvey();
        this.contributedRevenueSurvey = new ContributedRevenueSurvey();
        this.contributorsSurvey = new ContributorsSurvey();
        this.specialEventsSurvey = new SpecialEventsSurvey();
        this.inKindRevenueSurvey = new InKindRevenueSurvey();
        this.inKindRevenueDetailsSurvey = new InKindRevenueDetailsSurvey();
        this.investmentIncomeSurvey = new InvestmentIncomeSurvey();
        this.nonOperatingRevenueSurvey = new NonOperatingRevenueSurvey();

        this.personnelExpensesSurvey = new PersonnelExpensesSurvey();
        this.paymentsArtistsAndPerformersSurvey = new PaymentsArtistsAndPerformersSurvey();
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

    public static EarnedRevenueSurvey earnedRevenueSurvey(){return pages.earnedRevenueSurvey;}
    public static MembershipSurvey membershipSurvey(){return pages.membershipSurvey;}
    public static ContributedRevenueSurvey contributedRevenueSurvey(){return pages.contributedRevenueSurvey;}
    public static ContributorsSurvey contributorsSurvey(){return pages.contributorsSurvey;}
    public static SpecialEventsSurvey specialEventsSurvey(){return pages.specialEventsSurvey;}
    public static InKindRevenueSurvey inKindRevenueSurvey(){return pages.inKindRevenueSurvey;}
    public static InKindRevenueDetailsSurvey inKindRevenueDetailsSurvey(){return pages.inKindRevenueDetailsSurvey;}
    public static InvestmentIncomeSurvey investmentIncomeSurvey(){return pages.investmentIncomeSurvey;}
    public static NonOperatingRevenueSurvey nonOperatingRevenueSurvey(){return pages.nonOperatingRevenueSurvey;}

    public static PersonnelExpensesSurvey personnelExpensesSurvey(){return pages.personnelExpensesSurvey;}
    public static PaymentsArtistsAndPerformersSurvey paymentsArtistsAndPerformersSurvey(){return pages.paymentsArtistsAndPerformersSurvey;}

}
