package com.cdpapp.actions.completesurvey.programactivity;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetFiscalSponsorshipSurvey {

    public void setFiscalSponsorshipSurvey(){

        Pages.fiscalSponsorshipSurvey().setFiscalSponsorshipDescription();
        Pages.fiscalSponsorshipSurvey().setSponsorshipApplicants();
        Pages.fiscalSponsorshipSurvey().setNewSponsoredProjects();
        Pages.fiscalSponsorshipSurvey().setTotalSponsoredProjects();
        Pages.fiscalSponsorshipSurvey().setAmountDistributed();

    }

}
