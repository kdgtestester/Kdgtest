package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetPaymentsArtistsAndPerformersSurvey {

    public void setPaymentsArtistsAndPerformersSurvey(){
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersEmployeesVisualArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersEmployeesPerformingArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersEmployeesOtherArtists();

        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersIndependentContractorsVisualArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersIndependentContractorsPerformingArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersIndependentContractorsOtherArtists();

        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersProfessionalFeesVisualArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersProfessionalFeesPerformingArtists();
        Pages.paymentsArtistsAndPerformersSurvey().setArtistsAndPerformersProfessionalFeesOtherArtists();
    }

}
