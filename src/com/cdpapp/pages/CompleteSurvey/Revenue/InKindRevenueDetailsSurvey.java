package com.cdpapp.pages.completesurvey.revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class InKindRevenueDetailsSurvey extends BasePage {

    public void setInKindIndependentContractors(){
        type("Set In-Kind Independent Contractors", "1", "inKindIndependentContractorsField");
    }

    public void setInKindProfessionalFees(){
        type("Set In-Kind Professional Fees", "1", "inKindProfessionalFeesField");
    }

    public void setInKindAdvertisingAndPromotion(){
        type("Set In-Kind Advertising and Promotion", "1", "inKindAdvertisingPromotionField");
    }

    public void setInKindConferencesAndMeetings(){
        type("Set In-Kind Conferences and Meetings", "1", "inKindConferencesMeetingsField");
    }

    public void setInKindInsurance(){
        type("Set In-Kind Insurance", "1", "inKindInsuranceField");
    }

    public void setInKindOccupancy(){
        type("Set In-Kind Occupancy", "1", "inKindOccupancyField");
    }

    public void setInKindOfficeAndAdministration(){
        type("Set In-Kind Office and Administration", "1", "inKindOfficeAdministrationField");
    }

    public void setInKindPrintingAndPostage(){
        type("Set In-Kind Printing and Postage", "1", "inKindPrintingPostageField");
    }

    public void setInKindTravel(){
        type("Set In-Kind Travel", "1", "inKindTravelField");
    }

    public void setInKindOtherExpenses(){
        type("Set In-Kind Other Expenses", "1", "inKindOtherExpensesField");
    }

    public void waitInKindOtherExpensesDescription(){
        type("Set In-Kind Other Expenses Description", "1", "inKindOtherExpensesDescriptionField");
    }

    public void setInKindLand(){
        type("Set In-Kind Land", "1", "inKindLandField");
    }

    public void setInKindBuildings(){
        type("Set In-Kind Buildings", "1", "inKindBuildingsField");
    }

    public void setInKindConstructionInProgress(){
        type("Set In-Kind Construction in Progress", "1", "inKindConstructionInProgressField");
    }

    public void setInKindCapitalizedEquipment(){
        type("Set In-Kind Capitalized Equipment", "1", "inKindCapitalizedEquipmentField");
    }

    public void setInKindLeaseholdImprovements(){
        type("Set In-Kind Leasehold Improvements", "1", "inKindLeaseholdImprovementsField");
    }

    public void setInKindOtherCapitalizedAssets(){
        type("Set In-Kind Other Capitalized Assets", "1", "inKindOtherCapitalizedAssetsField");
    }

}
