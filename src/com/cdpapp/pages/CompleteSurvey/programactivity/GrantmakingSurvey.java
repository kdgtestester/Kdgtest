package com.cdpapp.pages.completesurvey.programactivity;

import com.qatestlab.base.BasePage;

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

}
