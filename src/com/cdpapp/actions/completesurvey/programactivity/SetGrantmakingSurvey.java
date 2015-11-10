package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetGrantmakingSurvey {

    public void setGrantmakingSurvey(){

        Pages.grantmakingSurvey().setGrantmakingDescription();

        Pages.grantmakingSurvey().checkGrantmakingType();

        Pages.grantmakingSurvey().setGrantApplicantsOrganizations();
        Pages.grantmakingSurvey().setGrantApplicantsArtists();

        Pages.grantmakingSurvey().setGrantRecipientsOrganizations();
        Pages.grantmakingSurvey().setGrantRecipientsArtists();

        Pages.grantmakingSurvey().setGrantsAwardedOrganizations();
        Pages.grantmakingSurvey().setGrantsAwardedArtists();

        Pages.grantmakingSurvey().setAmountAwardedOrganizations();
        Pages.grantmakingSurvey().setAmountAwardedArtists();

    }

}
