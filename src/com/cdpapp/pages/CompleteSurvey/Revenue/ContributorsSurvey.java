package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class ContributorsSurvey extends BasePage {

    public void setTrusteeBoardContributors(){
        type("Set Trustee/Board Contributors", "1", "contributorsFieldTrusteeBoardContributors");
    }

    public void checkEstimateTrusteeBoardContributors(){
        setCheckboxState("Check estimate  Trustee/Board Contributors", true, "estimateCheckTrusteeBoardContributors");
    }

    public void setIndividualContributors(){
        type("Set Individual Contributors", "1", "contributorsFieldIndividualContributors");
    }

    public void checkEstimateIndividualContributors(){
        setCheckboxState("Check estimate Individual Contributors", true, "estimateCheckIndividualContributors");
    }

    public void setCorporateContributors(){
        type("Set Corporate Contributors", "1", "contributorsFieldCorporateContributors");
    }

    public void checkEstimateCorporateContributors(){
        setCheckboxState("Check estimate Corporate Contributors", true, "estimateCheckCorporateContributors");
    }

    public void setFoundationContributors(){
        type("Set Foundation Contributors", "1", "contributorsFieldFoundationContributors");
    }

    public void checkEstimateFoundationContributors(){
        setCheckboxState("Check estimate Foundation Contributors", true, "estimateCheckFoundationContributors");
    }

    public void setCityGovernmentContributors(){
        type("Set City Government Contributors", "1", "contributorsFieldCityGovernmentContributors");
    }

    public void checkEstimateCityGovernmentContributors(){
        setCheckboxState("Check estimate City Government Contributors", true, "estimateCheckCityGovernmentContributors");
    }

    public void setCountyGovernmentContributors(){
        type("Set County Government Contributors", "1", "contributorsFieldCountyGovernmentContributors");
    }

    public void checkEstimateCountyGovernmentContributors(){
        setCheckboxState("Check estimate County Government Contributors", true, "estimateCheckCountryGovernmentContributors");
    }

    public void setStateGovernmentContributors(){
        type("Set State Government Contributors", "1", "contributorsFieldStateGovernmentContributors");
    }

    public void checkEstimateStateContributors(){
        setCheckboxState("Check estimate State Government Contributors", true, "estimateCheckStateGovernmentContributors");
    }

    public void setFederalGovernmentContributors(){
        type("Set Federal Government Contributors", "1", "contributorsFieldFederalGovernmentContributors");
    }

    public void checkEstimateFederalGovernmentContributors() {
        setCheckboxState("Check estimate Federal Government Contributors", true, "estimateCheckFederalGovernmentContributors");
    }

    public void checkEstimateTotalGovernmentContributors(){
        setCheckboxState("Check estimate Total Government Contributors", true, "estimateCheckTotalGovernmentContributors");
    }

    public void setTribalContributors(){
        type("Set Tribal Contributors", "1", "contributorsFieldTribalContributors");
    }

    public void checkEstimateTribalContributors() {
        setCheckboxState("Check estimate Tribal Contributors", true, "estimateCheckTribalContributors");
    }

}
