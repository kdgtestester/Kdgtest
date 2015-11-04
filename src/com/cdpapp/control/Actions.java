package com.cdpapp.control;

import com.cdpapp.actions.*;

public class Actions {

    private static Actions actions;

    private LoginWithGoogleActions loginWithGoogleActions;
    private CreatingNewOrganizationActions creatingNewOrganizationActions;
    private CreatingNewSurveyActions creatingNewSurveyActions;
    private CompleteSurveyActions completeSurveyActions;
    private RunReportsActions runReportsActions;
    private SetSurveyPropertiesActions setSurveyPropertiesActions;

    private Actions() {
        this.loginWithGoogleActions = new LoginWithGoogleActions();
        this.creatingNewOrganizationActions = new CreatingNewOrganizationActions();
        this.creatingNewSurveyActions = new CreatingNewSurveyActions();
        this.completeSurveyActions = new CompleteSurveyActions();
        this.runReportsActions = new RunReportsActions();
        this.setSurveyPropertiesActions = new SetSurveyPropertiesActions();
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

}
