package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetResearchSurvey {

    public void setResearchSurvey(){

        Pages.researchSurvey().setResearchDescription();
        Pages.researchSurvey().setSurveys();
        Pages.researchSurvey().setReports();

    }

}
