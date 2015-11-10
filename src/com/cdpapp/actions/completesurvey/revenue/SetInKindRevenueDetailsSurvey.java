package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;
import com.gargoylesoftware.htmlunit.Page;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetInKindRevenueDetailsSurvey{

    public void setInKindRevenueDetailsSurvey(){

        Pages.inKindRevenueDetailsSurvey().setInKindIndependentContractors();
        Pages.inKindRevenueDetailsSurvey().setInKindProfessionalFees();
        Pages.inKindRevenueDetailsSurvey().setInKindAdvertisingAndPromotion();
        Pages.inKindRevenueDetailsSurvey().setInKindConferencesAndMeetings();
        Pages.inKindRevenueDetailsSurvey().setInKindInsurance();
        Pages.inKindRevenueDetailsSurvey().setInKindOccupancy();
        Pages.inKindRevenueDetailsSurvey().setInKindOfficeAndAdministration();
        Pages.inKindRevenueDetailsSurvey().setInKindPrintingAndPostage();
        Pages.inKindRevenueDetailsSurvey().setInKindTravel();
        Pages.inKindRevenueDetailsSurvey().setInKindOtherExpenses();

        Pages.inKindRevenueDetailsSurvey().waitInKindOtherExpensesDescription();

        Pages.inKindRevenueDetailsSurvey().setInKindOtherExpensesDescription();
        Pages.inKindRevenueDetailsSurvey().setInKindBuildings();
        Pages.inKindRevenueDetailsSurvey().setInKindConstructionInProgress();
        Pages.inKindRevenueDetailsSurvey().setInKindCapitalizedEquipment();
        Pages.inKindRevenueDetailsSurvey().setInKindLeaseholdImprovements();
        Pages.inKindRevenueDetailsSurvey().setInKindOtherCapitalizedAssets();
    }

}








































