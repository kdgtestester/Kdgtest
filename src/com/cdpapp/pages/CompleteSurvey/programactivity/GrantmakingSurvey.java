package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class GrantmakingSurvey extends BasePage{

    public void setGrantmakingDescription(){
        type("Set Grantmaking Description", "1", "grantmakingDescriptionArea");
    }

    public void checkGrantmakingType(){
        setCheckboxState("Check Direct", true, "grantmakingTypeDirectRadio");
    }

    public void setGrantApplicantsOrganizations(){
        type("Set Grant Applicants - Organizations", "1", "grantApplicantsOrganizationsField");
    }

    public void setGrantApplicantsArtists(){
        type("Set Grant Applicants - Artists", "1", "grantApplicantsArtistsField");
    }

    public void setGrantRecipientsOrganizations(){
        type("Set Grant Recipients - Organizations", "1", "grantRecipientsOrganizationsField");
    }

    public void setGrantRecipientsArtists(){
        type("Set Grant Recipients - Artists", "1", "grantRecipientsArtistsField");
    }

    public void setGrantsAwardedOrganizations(){
        type("Set Grants Awarded - Organizations", "1", "grantsAwardedOrganizationsField");
    }

    public void setGrantsAwardedArtists(){
        type("Set Grants Awarded - Artists", "1", "grantsAwardedArtistsField");
    }

    public void setAmountAwardedOrganizations(){
        type("Set Amount Awarded - Organizations", "1", "amountAwardedOrganizationsField");
    }

    public void setAmountAwardedArtists(){
        type("Set Amount Awarded - Artists", "1", "amountAwardedArtistsField");
    }

}
