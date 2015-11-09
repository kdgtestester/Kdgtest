package com.cdpapp.pages.completesurvey.expense;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class WorkSpaceSurvey extends BasePage {

    public void setWorkspaceNameOptional(){
        type("Set Workspace Name (Optional)", "1", "workspaceNameOptionalField");
    }

    public void setStreetAddress(){
        type("Set Street Address", "1", "streetAddressField");
    }

    public void setStreetAddressCont_D(){
        type("Set Street Address (cont'd)", "1", "streetAddressContDField");
    }

    public void setZipCode(){
        type("Set Zip Code", "1", "zipCodeDField");
    }

    public void checkWorkplaceStatus(){
        setCheckboxState("Check \"Own\" Workplace Status", true, "ownRadioWorkplaceStatus");
    }

    public void checkWorkplaceType(){
        setCheckboxState("Check \"Administrative\" Workplace Type", true, "administrativeRadioWorkplaceType");
    }

    public void checkADACompliance(){
        setCheckboxState("Check \"Yes\" Workplace Status", true, "yesRadioADACompliance");
    }

    public void setTotalGrossSquareFootage(){
        type("Set Total Gross Square Footage", "1", "totalGrossSquareFootageField");
    }

    public void checkAdditionalWorkspaces(){
        setCheckboxState("Check \"No\" Workplace Status", true, "noRadioAdditionalWorkspaces");
    }

}
