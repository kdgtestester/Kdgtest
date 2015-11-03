package com.cdpapp.pages;

import com.qatestlab.base.BasePage;

public class GoogleAuthPage extends BasePage {

    public void waitSingInGoogleAccountHeader(){
       waitForElementEnable("signInGoogleAccountHeader");
    }

    public String headerSingIn(){
        return getElement("signInGoogleAccountHeader").getText().trim();
    }

    public void setEmailGoogleAccount(String email){
        type("Type email google account", email, "emailField");
    }

    public void clickNextGoogleAccountAuth(){
        click("Click next button", "nextButton");
    }

    public void setPasswordGoogleAccount(String password){
        type("Type password google account", password, "passwordField");
    }

    public void clickSingInGoogleAccount(){
        click("Click Sing In button", "singInButtonByGoogleAcc");
    }

    public void waitApprovePermission(){
        waitForElementToBeClickable("approveAccessButton");
    }

    public void clickApprovePermission(){
        click("Click allow button in request for permission window", "approveAccessButton");
    }


}
