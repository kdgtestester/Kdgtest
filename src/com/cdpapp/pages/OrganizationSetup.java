package com.cdpapp.pages;

import com.qatestlab.base.BasePage;
import com.qatestlab.utils.Random;
import org.openqa.selenium.JavascriptExecutor;

public class OrganizationSetup extends BasePage {

    public void waitNameOrganizationField(){
        waitForElementVisibility("organizationNameField");
    }

    public void setNameOrganization(String orgName){
        type("Set organization name", orgName, "organizationNameField");
    }

    public void selectStateOrProvinceOrganization(){
        selectDropDownListRandomOption("Select State or Province organization", 2, 2/*getDropDownListItemsCount("Get count State or Province", "organizationStateOrProvince")*/, "organizationStateOrProvince");
    }

    public void clicFindMyOrganizationButton(){
        click("Click \"Find my organization\" Button", "findMyOrganizationButton");
    }

    public void waitCreateNewOrganizationButton(){
        waitForElementToBeClickable("createOrganizationButton");
    }

    public void clickCreateNewOrganizationButton(){
        click("Click Create a new organization", "createOrganizationButton");
    }

   public void waitWarningSetupCheckBox(){
       waitForElementVisibility("warningSetupCheckBox");
   }

    public void activateWarningSetupCheckBox(){
        setCheckboxState("Activate checkBox \"I understand that once" +
                " I begin the organization setup, there will not be" +
                " an option to stop and save my progress.\"",
                true, "warningSetupCheckBox");
    }

    public void waitStartButton(){
        waitForElementToBeClickable("startButton");
    }

    public void clickStartButton(){
        click("Click \"Start\" button", "startButton");
    }

    public void clickOrganizationType(){
        click("Select organization type", "setupTypeOrganization");
    }

    public void scrollToDown(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void waitNextButton(){
        waitForElementToBeClickable("orgSetupNextButton");
    }


    public void waitAddressContactInformationForm(){
        waitForElementVisibility("orgSetupForm2");
    }

    public void waitLegislativeDistrictsForm(){
        waitForElementVisibility("cityCouncilDistrictLabel");
    }

    public void clickNextButton(){
        click("Click \"Next\" button", "orgSetupNextButton");
    }

    public void setStreetAddressOrganization(){
        type("Set street address organization", Random.genStreet(),  "orgSetupAddressStreetField");
    }

    public void setCityOrganization(){
        String city = "City" + Random.genString(5);
        type("Set city organization", city, "orgSetupCityField");
    }

    public void waitStateList(){
        waitForElementVisibility("orgSetupAddressStateField");
    }

    public void setStateOrganization(){
        selectDropDownListRandomOption("Set state organization", 2, getDropDownListItemsCount("Get count State", "orgSetupAddressStateField"), "orgSetupAddressStateField");
    }

    public void setZipCodeOrganization(){
        type("Set Zip code organization", "" + Random.genInt(10000, 99999), "orgSetupAddressZipField");
    }

    public void setCountryOrganization(){
        selectDropDownListRandomOption("Set country organization", 2, getDropDownListItemsCount("Get count country", "orgSetupCountryField"), "orgSetupCountryField");
    }

//    public void setCountry2Organization(){
//        //selectDropDownListRandomOption("Set country2 organization", "orgSetupAddressCountryField");
//
//    }

    public void setPhoneOrganization(){
        type("Set phone organization", Random.genPhone(), "orgSetupPhoneField");
    }

    public void waitPocCheckBox(){
        waitForElementToBeClickable("orgSetupPocCheckBox");
    }

    public void clickPocCheckBox(){
        click("Click checkbox \"I am the Primary Contact for this organization.\"", "orgSetupPocCheckBox");
    }

    public void waitPocTitleField(){
        waitForElementVisibility("orgSetupPocTitleField");
    }

    public void setPocTitleField(){
        String title = "TestTitle" + Random.genString(4);
        type("Set title in \"Primary Contact Person\"", title, "orgSetupPocTitleField");
    }

    public void setPocPhoneField(){
        type("Set phone in \"Primary Contact Person\" ", Random.genPhone(), "orgSetupPocPhoneField");
    }

    public void setFiscalYearEndMonthField(){
        selectDropDownListRandomOption("Set fiscal year end month", 2, 13, "orgSetupFiscalYearEndMonthField");
    }

    public void setFiscalYearEndDayField(){
        selectDropDownListRandomOption("Set fiscal year end day", 2, getDropDownListItemsCount("Get count day current month",  "orgSetupFiscalYearEndDayField"), "orgSetupFiscalYearEndDayField");
    }

    public void waitSetupFinishButton(){
        waitForElementToBeClickable("orgSetupFinishButton");
    }

    public void clickSetupFinishButton(){
        click("Click \"Save and Finish\" button", "orgSetupFinishButton");
    }

    public void waitContinueButtonAfterSuccessCreation(){
        waitForElementToBeClickable("continueButtonAfterSuccessCreation");
    }

    public String continueButtonPresent(){
        waitForElementToBeClickable("continueButtonAfterSuccessCreation");
        return getElement("continueButtonAfterSuccessCreation").getText().trim().toLowerCase();
    }

    public void scrollUp(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0)");
    }

    public void clickContinueButtonAfterSuccessCreationButton(){
        click("Click \"Continue\" button", "continueButtonAfterSuccessCreation");
    }
}
