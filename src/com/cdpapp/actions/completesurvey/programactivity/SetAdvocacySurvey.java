package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetAdvocacySurvey {

    public void setAdvocacySurvey(){

        Pages.advocacySurvey().setAdvocacyDescription();
        Pages.advocacySurvey().setMeetings();
        Pages.advocacySurvey().setOfficials();
        Pages.advocacySurvey().setTestimony();

    }

}
