package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 05.11.2015.
 */
public class EarnedRevenue extends BasePage {

    public void setFoodAndConcessionsRevenue(){
        type("Set Food and Concessions Revenue", "1", "foodAndConcessionsRevenueField");
    }

    public void setGiftShopAndMerchandiseFees(){
        type("Set Gift Shop And Merchandise Fees", "1", "giftShopAndMerchandiseFeesField");
    }

    public void setParkingFees(){
        type("Set Parking Fees", "1", "parkingFeesField");
    }

    public void setAdvertisingRevenue(){
        type("Set Advertising Revenue", "1", "advertisingRevenueField");
    }

    public void setSponsorshipRevenue(){
        type("Set Sponsorship Revenue", "1", "sponsorshipRevenueField");
    }

    public void setSpecialEventsRevenue(){
        type("Set Special Events Revenue", "1", "specialEventsRevenueField");
    }

    public void waitSpecialEventsRevenueDescription(){
        waitForElementVisibility("specialEventsRevenueDescriptionField");
    }

    public void setSpecialEventsRevenueDescription(){
        type("Set Special Events Revenue Description", "1", "specialEventsRevenueDescriptionField");
    }

    public void setMembershipRevenueFromIndividuals(){
        type("Set MembershipSurvey Revenue from Individuals", "1", "membershipRevenueFromIndividualsField");
    }

    public void setMembershipRevenuefromOrganizations(){
        type("Set MembershipSurvey Revenue from Organizations", "1", "membershipRevenueFromOrganizationsField");
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
        type("Set Other Program Revenue", "1", "otherProgramRevenueField");
    }

    public void setOtherProgramRevenueDescription(){
        type("Set Other Program Revenue Description", "1", "otherProgramRevenueDescriptionField");
    }

    public void setOtherEarnedRevenue(){
        type("Set Other Earned Revenue", "1", "otherEarnedRevenueField");
    }

    public void setOtherEarnedRevenueDescription(){
        type("Set Other Earned Revenue Description", "1", "otherEarnedRevenueDescriptionField");
    }

}
