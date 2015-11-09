package com.mediaspectrum.pages;


import com.mediaspectrum.control.AdSalesConstants;
import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;


public class LoginPage extends BasePage {

    public void openStartPage() {
        Reporter.log("Opening login page");
        driver.get(AdSalesConstants.BASE_URL);
    }

    public void setSystemLanguage(String language) {
        waitForElementVisibility("langButton", language);
        click("Clicking on language: "+language,"langButton", language);
    }

    public Boolean isSystemLanguageSelected(){
        return isElementPresent("selectedLanguage");
    }

    public String getSystemLanguage(){
        return getElementAttributeValue("Getting system default language", "title", "selectedLanguage");
    }

    public String getSelectedSystemLanguageBgColor(){
        return getElementCssValue("Getting system selected language bg color", "background-color", "selectedLanguage");
    }

    public String getPageHeader(){
        return getElementText("Getting login page title", "pageLabel");
    }

    public void typeLogin(String login) {
        waitForElementVisibility("loginField");
        type("Typing login", login, "loginField");
    }

    public String getLoginValue() {
        return getElementAttributeValue("Getting login value", "value", "loginField");
    }

    public void typePassword(String password) {
        type("Typing password", password, "passwordField");
    }

    public Boolean isPasswordInputFieldTypePassword() {
        return getElementAttributeValue("Getting password input field type", "type", "passwordField").equals("password");
    }

    public void clickLoginButton() {
        click("Clicking login button", "loginButton");
    }




}
