package com.cdpapp.control;

import com.cdpapp.pages.*;
import com.cdpapp.pages.completesurvey.balancesheet.*;
import com.cdpapp.pages.completesurvey.expense.*;
import com.cdpapp.pages.completesurvey.programactivity.*;
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
    private SalariesAndBenefitsSurvey salariesAndBenefitsSurvey;
    private NonPersonnelExpensesSurvey nonPersonnelExpensesSurvey;
    private WorkforceSurvey workforceSurvey;
    private WorkSpaceSurvey workSpaceSurvey;
    private MarketingAndSocialMediaSurvey marketingAndSocialMediaSurvey;

    private AssetsSurvey assetsSurvey;
    private EndowmentAndReserveFundsSurvey endowmentAndReserveFundsSurvey;
    private LiabilitiesSurvey liabilitiesSurvey;
    private LoanDetailsSurvey loanDetailsSurvey;
    private NetAssetsSurvey netAssetsSurvey;
    private BalanceSheetSummarySurvey balanceSheetSummarySurvey;

    private AdvocacySurvey advocacySurvey;
    private GrantmakingSurvey grantmakingSurvey;
    private FiscalSponsorshipSurvey fiscalSponsorshipSurvey;
    private LoanProgramsSurvey loanProgramsSurvey;
    private ConsultingFeeForServiceWorkSurvey consultingFeeForServiceWorkSurvey;
    private ResearchSurvey researchSurvey;
    private CompetitionsSurvey competitionsSurvey;
    private ConferencesSurvey conferencesSurvey;

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
        this.salariesAndBenefitsSurvey = new SalariesAndBenefitsSurvey();
        this.nonPersonnelExpensesSurvey = new NonPersonnelExpensesSurvey();
        this.workforceSurvey = new WorkforceSurvey();
        this.workSpaceSurvey = new WorkSpaceSurvey();
        this.marketingAndSocialMediaSurvey = new MarketingAndSocialMediaSurvey();

        this.assetsSurvey = new AssetsSurvey();
        this.endowmentAndReserveFundsSurvey = new EndowmentAndReserveFundsSurvey();
        this.liabilitiesSurvey = new LiabilitiesSurvey();
        this.loanDetailsSurvey = new LoanDetailsSurvey();
        this.netAssetsSurvey = new NetAssetsSurvey();
        this.balanceSheetSummarySurvey = new BalanceSheetSummarySurvey();

        this.advocacySurvey = new AdvocacySurvey();
        this.grantmakingSurvey = new GrantmakingSurvey();
        this.fiscalSponsorshipSurvey = new FiscalSponsorshipSurvey();
        this.loanProgramsSurvey = new LoanProgramsSurvey();
        this.consultingFeeForServiceWorkSurvey = new ConsultingFeeForServiceWorkSurvey();
        this.researchSurvey = new ResearchSurvey();
        this.competitionsSurvey = new CompetitionsSurvey();
        this.conferencesSurvey = new ConferencesSurvey();
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
    public static SalariesAndBenefitsSurvey salariesAndBenefitsSurvey(){return pages.salariesAndBenefitsSurvey;}
    public static NonPersonnelExpensesSurvey nonPersonnelExpensesSurvey(){return pages.nonPersonnelExpensesSurvey;}
    public static WorkforceSurvey workforceSurvey(){return pages.workforceSurvey;}
    public static WorkSpaceSurvey workSpaceSurvey(){return pages.workSpaceSurvey;}
    public static MarketingAndSocialMediaSurvey marketingAndSocialMediaSurvey(){return pages.marketingAndSocialMediaSurvey;}

    public static AssetsSurvey assetsSurvey(){return pages.assetsSurvey;}
    public static EndowmentAndReserveFundsSurvey endowmentAndReserveFundsSurvey(){return pages.endowmentAndReserveFundsSurvey;}
    public static LiabilitiesSurvey liabilitiesSurvey(){return pages.liabilitiesSurvey;}
    public static LoanDetailsSurvey loanDetailsSurvey(){return pages.loanDetailsSurvey;}
    public static NetAssetsSurvey netAssetsSurvey(){return pages.netAssetsSurvey;}
    public static BalanceSheetSummarySurvey balanceSheetSummarySurvey(){return pages.balanceSheetSummarySurvey;}

    public static AdvocacySurvey advocacySurvey(){return pages.advocacySurvey;}
    public static GrantmakingSurvey grantmakingSurvey(){return pages.grantmakingSurvey;}
    public static FiscalSponsorshipSurvey fiscalSponsorshipSurvey(){return pages.fiscalSponsorshipSurvey;}
    public static LoanProgramsSurvey loanProgramsSurvey(){return pages.loanProgramsSurvey;}
    public static ConsultingFeeForServiceWorkSurvey consultingFeeForServiceWorkSurvey(){return pages.consultingFeeForServiceWorkSurvey;}
    public static ResearchSurvey researchSurvey(){return pages.researchSurvey;}
    public static CompetitionsSurvey competitionsSurvey(){return pages.competitionsSurvey;}
    public static ConferencesSurvey conferencesSurvey(){return pages.conferencesSurvey;}

}
