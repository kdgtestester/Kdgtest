package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class ConsultingFeeForServiceWorkSurvey extends BasePage {

    public void setConsultingServicesDescription(){
        type("Set Consulting Services Description", "1", "consultingServicesDescriptionArea");
    }

    public void checkTimePeriod(){
        setCheckboxState("Check Hour", true, "loanRecipientsField");
    }

    public void setTimeAvailable(){
        type("Set Time Available", "1", "timeAvailableField");
    }

    public void setTimeProvided(){
        type("Set Time Provided", "1", "timeProvidedField");
    }

    public void setAdviceEntities(){
        type("Set Advice to Entities", "1", "adviceEntitiesField");
    }

    public void setFeeRangeHigh(){
        type("Set high Fee Range", "2", "highFeeRangeField");
    }

    public void setFeeRangeLow(){
        type("Set low Fee Range", "1", "lowFeeRangeField");
    }

}
