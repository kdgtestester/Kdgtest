package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class ConferencesSurvey extends BasePage {

    public void setConferencesDescription(){
        type("Set Conferences Description", "1", "conferencesDescriptionArea");
    }

    public void setConferencesHosted(){
        type("Set Conferences Hosted", "1", "conferencesHostedField");
    }

    public void setHighRegistrationFee(){
        type("Set high Registration Fee", "2", "highRegistrationFeeField");
    }

    public void setLowRegistrationFee(){
        type("Set low Conferences Hosted", "1", "lowRegistrationFeeField");
    }

    public void setConferenceCapacity(){
        type("Set Conference Capacity", "1", "conferenceCapacityField");
    }

    public void setPaidAttendees(){
        type("Set Paid Attendees", "1", "paidAttendeesField");
    }

    public void setFreeAttendees(){
        type("Set Free Attendees", "1", "freeAttendeesField");
    }


}
