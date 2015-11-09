package com.cdpapp.pages.completesurvey.expense;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class PaymentsArtistsAndPerformersSurvey extends BasePage {

    public void setArtistsAndPerformersEmployeesVisualArtists(){
        type("Set Artists and Performers - Employees Visual Artists", "1", "artistsAndPerformersEmployeesVisualArtistsField");
    }

    public void setArtistsAndPerformersEmployeesPerformingArtists(){
        type("Set Artists and Performers - Employees Performing Artists", "1", "artistsAndPerformersEmployeesPerformingArtistsField");
    }

    public void setArtistsAndPerformersEmployeesOtherArtists(){
        type("Set Artists and Performers - Employees Other Artists", "1", "artistsAndPerformersEmployeesOtherArtistsField");
    }

    public void setArtistsAndPerformersIndependentContractorsVisualArtists(){
        type("Set Artists and Performers - Independent Contractors Visual Artists", "1", "artistsAndPerformersEmployeesVisualArtistsField");
    }

    public void setArtistsAndPerformersIndependentContractorsPerformingArtists(){
        type("Set Artists and Performers - Independent Contractors Performing Artists", "1", "artistsAndPerformersEmployeesPerformingArtistsField");
    }

    public void setArtistsAndPerformersIndependentContractorsOtherArtists(){
        type("Set Artists and Performers - Independent Contractors Other Artists", "1", "artistsAndPerformersEmployeesOtherArtistsField");
    }

    public void setArtistsAndPerformersProfessionalFeesVisualArtists(){
        type("Set Artists and Performers - Professional Fees VisualArtists", "1", "artistsAndPerformersEmployeesVisualArtistsField");
    }

    public void setArtistsAndPerformersProfessionalFeesPerformingArtists(){
        type("Set Artists and Performers - Professional Fees PerformingArtists", "1", "artistsAndPerformersEmployeesPerformingArtistsField");
    }

    public void setArtistsAndPerformersProfessionalFeesOtherArtists(){
        type("Set Artists and Performers - Professional Fees OtherArtists", "1", "artistsAndPerformersEmployeesOtherArtistsField");
    }

}
