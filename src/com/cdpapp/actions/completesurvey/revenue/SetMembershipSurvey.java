package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetMembershipSurvey {

    public void setMembershipSurvey(){
        Pages.membershipSurvey().setHighPriceRangeOrganizationalMembership();
        Pages.membershipSurvey().setLowPriceRangeOrganizationalMembership();
        Pages.membershipSurvey().checkEstimatePriceRangeOrganizationalMembership();

        Pages.membershipSurvey().setOrganizationalMembersPaid();
        Pages.membershipSurvey().checkEstimateOrganizationalMembersPaid();

        Pages.membershipSurvey().setOrganizationalMembersFree();
        Pages.membershipSurvey().checkEstimateOrganizationalMembersFree();

        Pages.membershipSurvey().setHighPriceRangeAdultIndividualMembership();
        Pages.membershipSurvey().setLowPriceRangeAdultIndividualMembership();
        Pages.membershipSurvey().checkEstimatePriceRangeAdultIndividualMembership();


        Pages.membershipSurvey().setIndividualMembersPaid();
        Pages.membershipSurvey().checkEstimateIndividualMembersPaid();

        Pages.membershipSurvey().setIndividualMembersFree();
        Pages.membershipSurvey().checkEstimateIndividualMembersFree();
    }

}
