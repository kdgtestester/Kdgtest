package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetEarnedRevenueSurvey {

    public void setEarnedRevenue(){
        Pages.earnedRevenueSurvey().setFoodAndConcessionsRevenue();
        Pages.earnedRevenueSurvey().setGiftShopAndMerchandiseFees();;
        Pages.earnedRevenueSurvey().setParkingFees();
        Pages.earnedRevenueSurvey().setAdvertisingRevenue();
        Pages.earnedRevenueSurvey().setSponsorshipRevenue();
        Pages.earnedRevenueSurvey().setSpecialEventsRevenue();
        Pages.earnedRevenueSurvey().waitSpecialEventsRevenueDescription();;
        Pages.earnedRevenueSurvey().setSpecialEventsRevenueDescription();;
        Pages.earnedRevenueSurvey().setMembershipRevenueFromIndividuals();;
        Pages.earnedRevenueSurvey().setMembershipRevenuefromOrganizations();
        Pages.earnedRevenueSurvey().setOtherRentals();
        Pages.earnedRevenueSurvey().checkSetsCostumesProps();
        Pages.earnedRevenueSurvey().setContractedServices();
        Pages.earnedRevenueSurvey().setLoanInterest();
        Pages.earnedRevenueSurvey().setApplicationFees();
        Pages.earnedRevenueSurvey().setFiscalSponsorshipAdministrationFees();;
        Pages.earnedRevenueSurvey().setTuitionAndRegistrationFees();
        Pages.earnedRevenueSurvey().setOtherProgramRevenue();
        Pages.earnedRevenueSurvey().waitOtherProgramRevenueDescription();
        Pages.earnedRevenueSurvey().setOtherEarnedRevenue();
        Pages.earnedRevenueSurvey().waitOtherEarnedRevenueDescription();
        Pages.earnedRevenueSurvey().setOtherEarnedRevenueDescription();
    }

}
