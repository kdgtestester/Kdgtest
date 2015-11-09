package com.mediaspectrum.pages.booking.uieditor;


import com.testmatick.base.BasePage;

public class OnlineContentPage extends BasePage{
    public void switchToUIEditorFrame(){
        waitForElementPresent("uiEditorFrame");
        swithToFrame("Switching to uieditor frame", "uiEditorFrame");
        waitForElementInvisibility("pageLabel");
    }

    public void selectContentLanguage(String language){
        selectDropDownListOptionByText("Select content language :"+language, language, "languageSelector");
    }

    public void selectContentOperation(String operation) {
        selectDropDownListOptionByText("Select content operation :"+operation, operation, "operationSelector");
    }

    public void typeJobTitle(String jobTitle){
        type("Typing job title :"+ jobTitle, jobTitle, "jobTitleInput");
    }

    public void typeJobDescription(String jobDescription){

        swithToFrame("Switching text editor frame", "jobInfoFrame");
        type("Typing job description" + jobDescription, jobDescription, "jobDescriptionInput");
        driver.switchTo().defaultContent();
        switchToUIEditorFrame();
    }

    public void selectCountry(String country){
        selectDropDownListOptionByText("Selecting country : "+country, country, "countrySelector");
    }

    public void typeZip(String zip){
        type("Typing zip : " + zip, zip, "zipInput");
    }

    public void typeCity(String city){
        type("Typing city : " + city, city, "cityInput");
    }

    public void typeStreet(String street){
        type("Typing street : " + street, street, "streetInput");
    }

    public void typeStreetNumber(String streetNumber){
        type("Typing street number: " + streetNumber, streetNumber, "streetNumberInput");
    }

    public void clickNextButton() {
        click("Clicking next button", "nextButton");
    }

}
