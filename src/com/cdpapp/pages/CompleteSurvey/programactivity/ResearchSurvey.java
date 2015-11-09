package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class ResearchSurvey extends BasePage {

    public void setResearchDescription(){
        type("Set Research Description", "1", "researchDescriptionArea");
    }

    public void setSurveys(){
        type("Set Surveys", "1", "surveysField");
    }

    public void setReports(){
        type("Set Reports", "1", "reportsField");
    }

}
