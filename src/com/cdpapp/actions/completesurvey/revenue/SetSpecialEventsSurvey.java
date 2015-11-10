package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetSpecialEventsSurvey {

    public void setSpecialEventsSurvey(){
        Pages.specialEventsSurvey().setDescriptionOfSpecialEvents();

        Pages.specialEventsSurvey().setIndividualContributorsUnderwritersSponsors();
        Pages.specialEventsSurvey().setCorporateContributorsUnderwritersSponsors();
        Pages.specialEventsSurvey().setOtherContributorsUnderwritersSponsors();

        Pages.specialEventsSurvey().checkTrusteesBoard();
    }
}
