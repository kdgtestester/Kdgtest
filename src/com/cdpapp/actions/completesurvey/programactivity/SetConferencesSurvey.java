package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetConferencesSurvey {

    public void setConferencesSurvey(){

        Pages.conferencesSurvey().setConferencesDescription();
        Pages.conferencesSurvey().setConferencesHosted();
        Pages.conferencesSurvey().setHighRegistrationFee();
        Pages.conferencesSurvey().setLowRegistrationFee();
        Pages.conferencesSurvey().setConferenceCapacity();
        Pages.conferencesSurvey().setPaidAttendees();
        Pages.conferencesSurvey().setFreeAttendees();
    }

}
