package com.cdpapp.actions;

import com.cdpapp.control.Pages;
import com.gargoylesoftware.htmlunit.Page;
import sun.security.krb5.internal.PAData;

public class CreatingNewOrganizationActions {


    public void joinOrCreateNewOrganization(){
        Pages.dashboard().waitModalBody();

        Pages.dashboard().waitFirstItemMenuWithOrgItem();
        Pages.dashboard().clickFirstItemMenuWithOrgItem();
        Pages.dashboard().waitJoinOrCreateNewOrgItem();
        Pages.dashboard().clickJoinOrCreateNewOrgItem();
    }

    public void createOrganization (){

        joinOrCreateNewOrganization();
        searchOrganization();

        Pages.organizationSetup().waitCreateNewOrganizationButton();
        Pages.organizationSetup().clickCreateNewOrganizationButton();
        Pages.organizationSetup().waitWarningSetupCheckBox();
        Pages.organizationSetup().activateWarningSetupCheckBox();
        Pages.organizationSetup().waitStartButton();
        Pages.organizationSetup().clickStartButton();

        setupBasicInformationAboutOrganization();
        setupAddressContactInformation();
        setupLegislativeDistricts();
        setupPrimaryContactPerson();
        setupAddInfoAboutOrganization();
        summaryCreateOrganization();
    }



    public void searchOrganization(){
        Pages.organizationSetup().waitNameOrganizationField();
        Pages.organizationSetup().setNameOrganization();
        Pages.organizationSetup().selectStateOrProvinceOrganization();
        Pages.organizationSetup().clicFindMyOrganizationButton();
    }

    public void setupBasicInformationAboutOrganization(){
        Pages.organizationSetup().clickOrganizationType();
        Pages.organizationSetup().scrollToDown();
        Pages.organizationSetup().waitNextButton();
        Pages.organizationSetup().clickNextButton();
    }

    public void setupAddressContactInformation(){
        Pages.organizationSetup().waitAddressContactInformationForm();

        Pages.organizationSetup().setStreetAddressOrganization();
        Pages.organizationSetup().setCityOrganization();
//        Pages.organizationSetup().waitStateList();
//        Pages.organizationSetup().setStateOrganization();
        Pages.organizationSetup().setZipCodeOrganization();
        Pages.organizationSetup().setCountryOrganization();
        //Pages.organizationSetup().setCountry2Organization();
        Pages.organizationSetup().setPhoneOrganization();
        Pages.organizationSetup().waitNextButton();
        Pages.organizationSetup().clickNextButton();
    }

    public void setupLegislativeDistricts(){
        Pages.organizationSetup().waitLegislativeDistrictsForm();
        Pages.organizationSetup().waitNextButton();
        Pages.organizationSetup().clickNextButton();
    }

    public void setupPrimaryContactPerson(){
        Pages.organizationSetup().waitPocCheckBox();
        Pages.organizationSetup().clickPocCheckBox();
        Pages.organizationSetup().waitPocTitleField();
        Pages.organizationSetup().setPocTitleField();
        Pages.organizationSetup().setPocPhoneField();
        Pages.organizationSetup().waitNextButton();
        Pages.organizationSetup().clickNextButton();
    }

    public void setupAddInfoAboutOrganization(){
        Pages.organizationSetup().setFiscalYearEndMonthField();
        Pages.organizationSetup().setFiscalYearEndDayField();
        Pages.organizationSetup().waitNextButton();
        Pages.organizationSetup().clickNextButton();
    }

    public void summaryCreateOrganization(){
        Pages.organizationSetup().scrollToDown();
        Pages.organizationSetup().waitSetupFinishButton();
        Pages.organizationSetup().clickSetupFinishButton();
    }

    public void continueAfterCreateOrganization(){
        Pages.organizationSetup().waitContinueButtonAfterSuccessCreation();
        Pages.organizationSetup().clickContinueButtonAfterSuccessCreationButton();
        Pages.organizationSetup().scrollUp();
    }

}
