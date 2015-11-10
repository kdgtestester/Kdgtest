package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetWorkSpaceSurvey {

    public void setWorkSpaceSurvey(){

        Pages.workSpaceSurvey().setWorkspaceNameOptional();
        Pages.workSpaceSurvey().setStreetAddress();
        Pages.workSpaceSurvey().setStreetAddressCont_D();
        Pages.workSpaceSurvey().setZipCode();

        Pages.workSpaceSurvey().checkWorkplaceStatus();

        Pages.workSpaceSurvey().checkWorkplaceType();

        Pages.workSpaceSurvey().checkADACompliance();

        Pages.workSpaceSurvey().setTotalGrossSquareFootage();

        Pages.workSpaceSurvey().checkAdditionalWorkspaces();
    }
}