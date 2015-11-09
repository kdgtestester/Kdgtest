package com.mediaspectrum.pages.webadmin;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UsersTab extends BasePage{
    public void waitForPageLoad(){
        Reporter.log("Waiting Users tab to load");
        waitForElementVisibility("usersTab");
    }

    public void typeFirstName(String fname ) {
        type("Typing first name :" + fname, fname, "fnameInput");
    }

    public void typeLastName(String lname ) {
        type("Typing last name :" + lname, lname, "lnameInput");
    }

    public void typeLogin(String login ) {
        type("Typing login :" + login, login, "loginInput");
    }

    public void typePassword(String password ) {
        type("Typing password :" + password, password, "loginPasswordInput");
    }

    public void typePasswordConfirmation(String password ) {
        type("Typing password confirmation :" + password, password, "confirmPasswordInput");
    }

    public void setCheckboxIgnorePasswordAginState(Boolean state){
        setCheckboxState("Set ignore password aging state as : "+state, state, "ignorePasswordAgingCheckbox");
    }

    public void selectCompany(String company){
        selectDropDownListOptionByText("Select user company : "+company, company, "companySelector");
    }

    public void selectJobFunction(String jobFunction){
        selectDropDownListOptionByText("Select job function : "+jobFunction, jobFunction, "jobFunctionSelector");
    }

    public void clickSaveButton(){
        waitForElementToBeClickable("saveButton");
        click("Clicking save button", "saveButton");
    }

    public boolean isViewPrivilegesButtonVisible(){
        return isElementVisible("viewPrivilegesButton");
    }

    public boolean isSetAccessButtonVisible(){
        return isElementVisible("setAccessButton");
    }

    public boolean isSetGroupsButtonVisible(){
        return isElementVisible("setGroupsButton");
    }

    public boolean isSyncGroupsAccessButtonVisible(){
        return isElementVisible("viewPrivilegesButton");
    }

    public void clickSetAccessButton(){
        waitForElementToBeClickable("setAccessButton");
        click("Clicking set access button", "setAccessButton");
        waitForElementVisibility("setDataForm");
    }

    public void highlightOption(String accessRuleName){
        waitForElementToBeClickable("availibleListItem", accessRuleName);
        Actions actions = new Actions(driver);
        Reporter.log("Highlight option : " + accessRuleName);
        WebElement webElement = getElement("availibleListItem", accessRuleName);
        actions.keyDown(Keys.CONTROL).click(webElement).keyUp(Keys.CONTROL).perform();


    }

    public void addOptions(){
        click("Click move forward button", "addItemButton");
    }



    public void clickSaveSettingsButton(){
        click("Click save settings button", "saveSettings");
    }

    public void clickSetGroupsButton(){
        waitForElementToBeClickable("setGroupsButton");
        click("Clicking set groups button", "setGroupsButton");
        waitForElementVisibility("setDataForm");
    }

}
