package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class AdvocacySurvey extends BasePage {

    public void setAdvocacyDescription(){
        type("Set Advocacy Description", "1", "advocacyDescriptionArea");
    }

    public void setMeetings(){
        type("Set Meetings", "1", "meetingsField");
    }

    public void setOfficials(){
        type("Set Officials", "1", "officialsField");
    }

    public void setTestimony(){
        type("Set Testimony", "1", "testimonyField");
    }

}
