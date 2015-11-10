package com.cdpapp.pages.completesurvey.revenue;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 05.11.2015.
 */
public class EarnedRevenueSurvey extends BasePage {

    public void setFoodAndConcessionsRevenue(){
        type("Set Food and Concessions revenue", "1", "foodAndConcessionsRevenueField");
    }

    public void setGiftShopAndMerchandiseFees(){
        type("Set Gift Shop And Merchandise Fees", "1", "giftShopAndMerchandiseFeesField");
    }

    public void setParkingFees(){
        type("Set Parking Fees", "1", "parkingFeesField");
    }

    public void setAdvertisingRevenue(){
        type("Set Advertising revenue", "1", "advertisingRevenueField");
    }

    public void setSponsorshipRevenue(){
        type("Set Sponsorship revenue", "1", "sponsorshipRevenueField");
    }

    public void setSpecialEventsRevenue(){
        type("Set Special Events revenue", "1", "specialEventsRevenueField");
    }

    public void waitSpecialEventsRevenueDescription(){
        waitForElementVisibility("specialEventsRevenueDescriptionField");
    }

    public void setSpecialEventsRevenueDescription(){
        type("Set Special Events revenue Description", "1", "specialEventsRevenueDescriptionField");
    }

    public void setMembershipRevenueFromIndividuals(){
        type("Set MembershipSurvey revenue from Individuals", "1", "membershipRevenueFromIndividualsField");
    }

    public void setMembershipRevenuefromOrganizations(){
        type("Set MembershipSurvey revenue from Organizations", "1", "membershipRevenueFromOrganizationsField");
    }

    public void setOtherRentals(){
        type("Set Other Rentals", "1", "otherRentalsField");
    }

    public void checkSetsCostumesProps(){
        setCheckboxState("Check Sets/Costumes/Props Item", true, "checkCostumesPropsItem");
    }

    public void setContractedServices(){
        type("Set Contracted Services", "1", "contractedServicesField");
    }

    public void setLoanInterest(){
        type("Set Loan Interest", "1", "loanInterestField");
    }

    public void setApplicationFees(){
        type("Set Application Fees", "1", "applicationFeesField");
    }

    public void setFiscalSponsorshipAdministrationFees(){
        type("Set Fiscal Sponsorship Administration Fees", "1", "fiscalSponsorshipAdministrationFeesField");
    }

    public void setTuitionAndRegistrationFees(){
        type("Set Tuition and Registration Fees", "1", "tuitionAndRegistrationFeesField");
    }

    public void setOtherProgramRevenue(){
        type("Set Other Program revenue", "1", "otherProgramRevenueField");
    }

    public void waitOtherProgramRevenueDescription(){
        waitForElementVisibility("otherProgramRevenueDescriptionField");
    }

    public void setOtherProgramRevenueDescription(){
        type("Set Other Program revenue Description", "1", "otherProgramRevenueDescriptionField");
    }

    public void setOtherEarnedRevenue(){
        type("Set Other Earned revenue", "1", "otherEarnedRevenueField");
    }

    public void waitOtherEarnedRevenueDescription(){
        waitForElementVisibility("otherEarnedRevenueDescriptionField");
    }

    public void setOtherEarnedRevenueDescription(){
        type("Set Other Earned revenue Description", "1", "otherEarnedRevenueDescriptionField");
    }

}
