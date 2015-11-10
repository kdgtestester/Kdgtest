package com.cdpapp.actions;

import com.cdpapp.control.Pages;
import com.gargoylesoftware.htmlunit.Page;

/**
 * Created by Petr on 04.11.2015.
 */
public class SetSurveyPropertiesActions {


    public void completeSurvey(){
        Pages.surveySetSetting().waitGridViewButton();
        Pages.surveySetSetting().clickGridViewButton();

        Pages.setupPages();

    }


    public void setEarnedRevenue(){}

}
