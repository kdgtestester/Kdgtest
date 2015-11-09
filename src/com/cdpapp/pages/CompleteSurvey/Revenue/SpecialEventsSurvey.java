package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class SpecialEventsSurvey extends BasePage {

    public void setDescriptionOfSpecialEvents(){
        type("Set Description of Special Events", "Description of Special Events", "areaDescriptionSpecialEvents");
    }

    public void setIndividualContributorsUnderwritersSponsors(){
        type("Set Individual Contributors/Underwriters/Sponsors", "1", "individualContributorsUnderwritersSponsorsField");
    }

    public void setCorporateContributorsUnderwritersSponsors(){
        type("Set Corporate Contributors/Underwriters/Sponsors", "1", "corporateContributorsUnderwritersSponsorsField");
    }

    public void setOtherContributorsUnderwritersSponsors(){
        type("Set Other Contributors/Underwriters/Sponsors", "1", "otherContributorsUnderwritersSponsorsField");
    }

    public void checkTrusteesBoard(){
        setCheckboxState("Check Trustees/Board", true, "contributedRevenueLinesContainingSpecialEventsRevenue");
    }

}
