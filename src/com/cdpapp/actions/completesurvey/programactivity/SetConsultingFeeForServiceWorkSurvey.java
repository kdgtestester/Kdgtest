package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetConsultingFeeForServiceWorkSurvey {

    public void setConsultingFeeForServiceWorkSurvey(){

        Pages.consultingFeeForServiceWorkSurvey().setConsultingServicesDescription();

        Pages.consultingFeeForServiceWorkSurvey().checkTimePeriod();

        Pages.consultingFeeForServiceWorkSurvey().setTimeAvailable();
        Pages.consultingFeeForServiceWorkSurvey().setTimeProvided();
        Pages.consultingFeeForServiceWorkSurvey().setAdviceEntities();

        Pages.consultingFeeForServiceWorkSurvey().setFeeRangeHigh();
        Pages.consultingFeeForServiceWorkSurvey().setFeeRangeLow();
    }

}
