package com.cdpapp.pages.CompleteSurvey.Revenue;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class ContributedRevenueSurvey extends BasePage {

    public void setUnrestrictedNonOperatingContributedRevenue(){
        type("Set unrestricted Non-Operating Contributed Revenue", "1", "unrestrictedFieldNonOperatingContributedRevenue");
    }

    public void setTemporarilyRestrictedNonOperatingContributedRevenue(){
        type("Set temporarily restricted Non-Operating Contributed Revenue", "1", "temporarilyRestrictedFieldNonOperatingContributedRevenue");
    }

    public void setPermanentlyRestrictedNonOperatingContributedRevenue(){
        type("Set permanently restricted Non-Operating Contributed Revenue", "1", "permanentlyRestrictedFieldNonOperatingContributedRevenue");
    }

    public void setUnrestrictedTrusteeBoardContributions(){
        type("Set unrestricted Trustee Board Contributions", "1", "unrestrictedFieldTrusteeBoardContributions");
    }

    public void setTemporarilyRestrictedTrusteeBoardContributions(){
        type("Set temporarily restricted Trustee Board Contributions", "1", "temporarilyRestrictedFieldTrusteeBoardContributions");
    }

    public void setPermanentlyRestrictedTrusteeBoardContributions(){
        type("Set permanently restricted Trustee Board Contributions", "1", "permanentlyRestrictedFieldTrusteeBoardContributions");
    }

    public void setUnrestrictedIndividualContributions(){
        type("Set unrestricted Individual Contributions", "1", "unrestrictedFieldIndividualContributions");
    }

    public void setTemporarilyRestrictedIndividualContributions(){
        type("Set temporarily restricted Individual Contributions", "1", "temporarilyRestrictedFieldIndividualContributions");
    }

    public void setPermanentlyRestrictedIndividualContributions(){
        type("Set permanently restricted Individual Contributions", "1", "permanentlyRestrictedFieldIndividualContributions");
    }

    public void setUnrestrictedCorporateContributions(){
        type("Set unrestricted Corporate Contributions", "1", "unrestrictedFieldCorporateContributions");
    }

    public void setTemporarilyRestrictedCorporateContributions(){
        type("Set temporarily restricted Corporate Contributions", "1", "temporarilyRestrictedFieldCorporateContributions");
    }

    public void setPermanentlyRestrictedCorporateContributions(){
        type("Set permanently restricted Corporate Contributions", "1", "permanentlyRestrictedFieldCorporateContributions");
    }

    public void setUnrestrictedFoundationContributions(){
        type("Set unrestricted Foundation Contributions", "1", "unrestrictedFieldFoundationContributions");
    }

    public void setTemporarilyRestrictedFoundationContributions(){
        type("Set temporarily restricted Foundation Contributions", "1", "temporarilyRestrictedField");
    }

    public void setPermanentlyRestrictedFoundationContributions(){
        type("Set permanently restricted Foundation Contributions", "1", "permanentlyRestrictedFieldFoundationContributions");
    }

    public void checkSpecialEventsRevenue(){
        setCheckboxState("Set \"yes\" Special Events Revenue", true, "yesRadioSpecialEventsRevenue");

    }

    public void setUnrestrictedCityGovernmentContributions(){
        type("Set unrestricted City Government Contributions", "1", "unrestrictedFieldCityGovernmentContributions");
    }

    public void setTemporarilyRestrictedCityGovernmentContributions(){
        type("Set temporarily restricted City Government Contributions", "1", "temporarilyRestrictedFieldCityGovernmentContributions");
    }

    public void setPermanentlyRestrictedCityGovernmentContributions(){
        type("Set permanently restricted City Government Contributions", "1", "permanentlyRestrictedFieldCityGovernmentContributions");
    }

    public void setUnrestrictedCountryGovernmentContributions(){
        type("Set unrestricted Country Government Contributions", "1", "unrestrictedFieldCountryGovernmentContributions");
    }

    public void setTemporarilyRestrictedCountryGovernmentContributions(){
        type("Set temporarily restricted Country Government Contributions", "1", "temporarilyRestrictedFieldCountryGovernmentContributions");
    }

    public void setPermanentlyRestrictedCountryGovernmentContributions(){
        type("Set permanently restricted Country Government Contributions", "1", "permanentlyRestrictedFieldCountryGovernmentContributions");
    }

    public void setUnrestrictedStateGovernmentContributions(){
        type("Set unrestricted State Government Contributions", "1", "unrestrictedFieldStateGovernmentContributions");
    }

    public void setTemporarilyRestrictedStateGovernmentContributions(){
        type("Set temporarily restricted State Government Contributions", "1", "temporarilyRestrictedFieldStateGovernmentContributions");
    }

    public void setPermanentlyRestrictedStateGovernmentContributions(){
        type("Set permanently restricted State Government Contributions", "1", "permanentlyRestrictedFieldStateGovernmentContributions");
    }

    public void setUnrestrictedFederalGovernmentContributions(){
        type("Set unrestricted Federal Government Contributions", "1", "unrestrictedFieldFederalGovernmentContributions");
    }

    public void setTemporarilyRestrictedFederalGovernmentContributions(){
        type("Set temporarily restricted FederalGovernmentContributions", "1", "temporarilyRestrictedFieldFederalGovernmentContributions");
    }

    public void setPermanentlyRestrictedFederalGovernmentContributions(){
        type("Set permanently restricted Federal Government Contributions", "1", "permanentlyRestrictedFieldFederalGovernmentContributions");
    }

    public void setUnrestrictedTribalContributions(){
        type("Set unrestricted Tribal Contributions", "1", "unrestrictedFieldTribalContributions");
    }

    public void setTemporarilyRestrictedTribalContributions(){
        type("Set temporarily restricted Tribal Contributions", "1", "temporarilyRestrictedFieldTribalContributions");
    }

    public void setPermanentlyRestrictedTribalContributions(){
        type("Set permanently restricted Tribal Contributions", "1", "permanentlyRestrictedFieldTribalContributions");
    }

    public void setUnrestrictedOtherContribution(){
        type("Set unrestricted Other Contribution", "1", "unrestrictedFieldOtherContribution");
    }

    public void setTemporarilyRestrictedOtherContribution(){
        type("Set temporarily restricted Other Contribution", "1", "temporarilyRestrictedFieldOtherContribution");
    }

    public void setPermanentlyRestrictedOtherContribution(){
        type("Set permanently restricted Other Contribution", "1", "permanentlyRestrictedFieldOtherContribution");
    }

    public void setUnrestrictedNetAssetsReleasedRestriction(){
        type("Set unrestricted Net Assets Released Restriction", "1", "unrestrictedFieldNetAssetsReleasedRestriction");
    }

    public void setTemporarilyRestrictedNetAssetsReleasedRestriction(){
        type("Set temporarily restricted Net Assets Released Restriction", "1", "temporarilyRestrictedFieldNetAssetsReleasedRestriction");
    }

    public void setPermanentlyRestrictedNetAssetsReleasedRestriction(){
        type("Set permanently restricted Net Assets Released Restriction", "1", "permanentlyRestrictedFieldNetAssetsReleasedRestriction");
    }

}
