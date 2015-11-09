package com.cdpapp.pages.completesurvey.revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class MembershipSurvey extends BasePage {

    public void setHighPriceRangeOrganizationalMembership(){
        type("Set High Price Range - Organizational Membership", "2", "priceRangeOrganizationalMembershipHighField");
    }

    public void setLowPriceRangeOrganizationalMembership(){
        type("Set Low Price Range - Organizational Membership", "1", "priceRangeOrganizationalMembershipLowField");
    }

    public void checkEstimatePriceRangeOrganizationalMembership(){
        setCheckboxState("Check Estimate Price Range Organizational Membership", true, "priceRangeOrganizationalMembershipCheckEstimate");
    }

    public void setOrganizationalMembersPaid(){
        type("Set Organizational Members - Paid", "1", "organizationalMembersPaidField");
    }

    public void checkEstimateOrganizationalMembersPaid(){
        setCheckboxState("Check Estimate Organizational Members Paid", true, "organizationalMembersPaidCheckEstimate");
    }

    public void setOrganizationalMembersFree(){
        type("Set Organizational Members - Free", "1", "organizationalMembersFreeField");
    }

    public void checkEstimateOrganizationalMembersFree(){
        setCheckboxState("Check Estimate Organizational Members Free", true, "organizationalMembersFreeCheckEstimate");
    }

    public void setHighPriceRangeAdultIndividualMembership(){
        type("Set High Price Range - Adult Individual Membership", "2", "priceRangeAdultIndividualMembershipHighField");
    }

    public void setLowPriceRangeAdultIndividualMembership(){
        type("Set Low Price Range - Adult Individual Membership", "1", "priceRangeAdultIndividualMembershipLowField");
    }

    public void checkEstimatePriceRangeAdultIndividualMembership(){
        setCheckboxState("Check Estimate Price Range Organizational Membership", true, "priceRangeAdultIndividualMembershipCheckEstimate");
    }

    public void setIndividualMembersPaid(){
        type("Set Individual Members - Paid", "1", "individualMembersPaidField");
    }

    public void checkEstimateIndividualMembersPaid(){
        setCheckboxState("Check Estimate Price Range Organizational Membership", true, "individualMembersPaidCheckEstimate");
    }

    public void setIndividualMembersFree(){
        type("Set Individual Members - Paid", "1", "individualMembersFreeField");
    }

    public void checkEstimateIndividualMembersFree(){
        setCheckboxState("Check Estimate Price Range Organizational Membership", true, "individualMembersFreeCheckEstimate");
    }




}
