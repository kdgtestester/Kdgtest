package com.cdpapp.actions.completesurvey.revenue;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetContributorsSurvey {

    public void setContributorsSurvey(){

        Pages.contributorsSurvey().setTrusteeBoardContributors();
        Pages.contributorsSurvey().checkEstimateTrusteeBoardContributors();

        Pages.contributorsSurvey().setIndividualContributors();
        Pages.contributorsSurvey().checkEstimateIndividualContributors();

        Pages.contributorsSurvey().setCorporateContributors();
        Pages.contributorsSurvey().checkEstimateCorporateContributors();

        Pages.contributorsSurvey().setFoundationContributors();
        Pages.contributorsSurvey().checkEstimateFoundationContributors();

        Pages.contributorsSurvey().setCityGovernmentContributors();
        Pages.contributorsSurvey().checkEstimateCityGovernmentContributors();

        Pages.contributorsSurvey().setCountyGovernmentContributors();
        Pages.contributorsSurvey().checkEstimateCountyGovernmentContributors();

        Pages.contributorsSurvey().setStateGovernmentContributors();
        Pages.contributorsSurvey().checkEstimateStateContributors();

        Pages.contributorsSurvey().setFederalGovernmentContributors();
        Pages.contributorsSurvey().checkEstimateFederalGovernmentContributors();

        Pages.contributorsSurvey().checkEstimateTotalGovernmentContributors();

        Pages.contributorsSurvey().setTribalContributors();
        Pages.contributorsSurvey().checkEstimateTribalContributors();



    }

}