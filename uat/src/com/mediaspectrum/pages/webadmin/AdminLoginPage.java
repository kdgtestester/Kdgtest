package com.mediaspectrum.pages.webadmin;


import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Constants;

public class AdminLoginPage extends BasePage{

    public void openStartPage() {
        Reporter.log("Opening login page");
        driver.get(Constants.DEFAULT_ADMIN_LOGIN_PAGE_URL);
    }

    public void setSystemLanguage(String language) {
        waitForElementVisibility("languageSelector", language);
        click("Clicking on language: "+language,"languageSelector", language);
    }

    public void typeLogin(String login) {
        waitForElementVisibility("loginInput");
        type("Typing login", login, "loginInput");
    }


    public void typePassword(String password) {
        type("Typing password", password, "passwordInput");
    }



    public void clickLoginButton() {
        click("Clicking login button", "loginButton");
    }




}
