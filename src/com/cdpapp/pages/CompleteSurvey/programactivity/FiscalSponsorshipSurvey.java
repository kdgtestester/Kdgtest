package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class FiscalSponsorshipSurvey extends BasePage {

    public void setFiscalSponsorshipDescription(){
        type("Set Fiscal Sponsorship Description", "1", "fiscalSponsorshipDescriptionArea");
    }

    public void setSponsorshipApplicants(){
        type("Set Sponsorship Applicants", "1", "sponsorshipApplicantsField");
    }

    public void setNewSponsoredProjects(){
        type("Set New Sponsored Projects", "1", "newSponsoredProjectsField");
    }

    public void setTotalSponsoredProjects(){
        type("Set Total Sponsored Projects", "1", "totalSponsoredProjectsField");
    }

    public void setAmountDistributed(){
        type("Set Amount Distributed", "1", "amountDistributedField");
    }

}
