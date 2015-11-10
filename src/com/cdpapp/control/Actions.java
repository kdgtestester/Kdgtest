package com.cdpapp.control;

import com.cdpapp.actions.*;
import com.cdpapp.actions.SetMembershipSurvey;
import com.cdpapp.actions.completesurvey.expense.SetPersonnelExpensesSurvey;
import com.cdpapp.actions.completesurvey.revenue.*;

public class Actions {

    private static Actions actions;

    private LoginWithGoogleActions loginWithGoogleActions;
    private CreatingNewOrganizationActions creatingNewOrganizationActions;
    private CreatingNewSurveyActions creatingNewSurveyActions;
    private CompleteSurveyActions completeSurveyActions;
    private RunReportsActions runReportsActions;
    private SetSurveyPropertiesActions setSurveyPropertiesActions;
    private StartSurveyActions startSurveyActions;

    private SetMembershipSurvey setMembershipSurvey;
    private SetEarnedRevenueSurvey setEarnedRevenueSurvey;
    private SetContributedRevenueSurvey setContributedRevenueSurvey;
    private SetContributorsSurvey setContributorsSurvey;
    private SetSpecialEventsSurvey setSpecialEventsSurvey;
    private SetInKindRevenueSurvey setInKindRevenueSurvey;
    private SetInKindRevenueDetailsSurvey setInKindRevenueDetailsSurvey;
    private SetInvestmentIncomeSurvey setInvestmentIncomeSurvey;
    private SetNonOperatingRevenueSurvey setNonOperatingRevenueSurvey;

    private SetPersonnelExpensesSurvey setPersonnelExpensesSurvey;

    private Actions() {
        this.loginWithGoogleActions = new LoginWithGoogleActions();
        this.creatingNewOrganizationActions = new CreatingNewOrganizationActions();
        this.creatingNewSurveyActions = new CreatingNewSurveyActions();
        this.completeSurveyActions = new CompleteSurveyActions();
        this.runReportsActions = new RunReportsActions();
        this.setSurveyPropertiesActions = new SetSurveyPropertiesActions();
        this.startSurveyActions = new StartSurveyActions();

        this.setMembershipSurvey = new SetMembershipSurvey();
        this.setEarnedRevenueSurvey = new SetEarnedRevenueSurvey();
        this.setContributedRevenueSurvey = new SetContributedRevenueSurvey();
        this.setContributorsSurvey = new SetContributorsSurvey();
        this.setSpecialEventsSurvey = new SetSpecialEventsSurvey();
        this.setInKindRevenueSurvey = new SetInKindRevenueSurvey();
        this.setInKindRevenueDetailsSurvey = new SetInKindRevenueDetailsSurvey();
        this.setInvestmentIncomeSurvey = new SetInvestmentIncomeSurvey();
        this.setNonOperatingRevenueSurvey = new SetNonOperatingRevenueSurvey();
        this.setPersonnelExpensesSurvey = new SetPersonnelExpensesSurvey();
    }

    public static void setupActions() {
        actions = new Actions();
    }

    public static LoginWithGoogleActions loginActions() {
        return actions.loginWithGoogleActions;
    }

    public static CreatingNewOrganizationActions creatingNewOrganizationActions() {return actions.creatingNewOrganizationActions;}

    public static CreatingNewSurveyActions creatingNewSurveyActions() {return actions.creatingNewSurveyActions;}

    public static CompleteSurveyActions completeSurveyActions(){return actions.completeSurveyActions;}

    public static RunReportsActions runReportsActions(){return actions.runReportsActions;}

    public static SetSurveyPropertiesActions setSurveyPropertiesActions(){return actions.setSurveyPropertiesActions;}
    public static StartSurveyActions startSurveyActions(){return actions.startSurveyActions;}
    public static SetMembershipSurvey setMembershipSurvey(){return actions.setMembershipSurvey;}
    public static SetEarnedRevenueSurvey setEarnedRevenueSurvey(){return actions.setEarnedRevenueSurvey;}
    public static SetContributedRevenueSurvey setContributedRevenueSurvey(){return actions.setContributedRevenueSurvey;}
    public static SetContributorsSurvey setContributorsSurvey(){return actions.setContributorsSurvey;}
    public static SetSpecialEventsSurvey setSpecialEventsSurvey(){return actions.setSpecialEventsSurvey;}
    public static SetInKindRevenueSurvey setInKindRevenueSurvey(){return actions.setInKindRevenueSurvey;}
    public static SetInKindRevenueDetailsSurvey setInKindRevenueDetails(){return actions.setInKindRevenueDetailsSurvey;}
    public static SetInvestmentIncomeSurvey setInvestmentIncomeSurvey(){return actions.setInvestmentIncomeSurvey;}
    public static SetNonOperatingRevenueSurvey setNonOperatingRevenueSurvey(){return actions.setNonOperatingRevenueSurvey;}
    public static SetPersonnelExpensesSurvey setPersonnelExpensesSurvey(){return actions.setPersonnelExpensesSurvey;}

}
