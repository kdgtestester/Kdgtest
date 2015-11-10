package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetCompetitionsSurvey {

    public void setCompetitionsSurvey(){

        Pages.competitionsSurvey().setCompetitionsDescription();
        Pages.competitionsSurvey().setCompetitionsHosted();
        Pages.competitionsSurvey().setCompetitors();
        Pages.competitionsSurvey().setEntryFee();
        Pages.competitionsSurvey().setCompetitionWinners();

    }

}
