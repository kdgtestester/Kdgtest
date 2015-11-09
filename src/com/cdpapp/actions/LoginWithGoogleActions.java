package com.cdpapp.actions;

import com.cdpapp.control.Pages;

public class LoginWithGoogleActions {

    public void openGoogleAuthWindow(){
        Pages.loginPage().open();
        Pages.loginPage().clickLoginWithGoogleButton();
        Pages.loginPage().switchToNewTab();
        Pages.googleAuthPage().waitSingInGoogleAccountHeader();
    }

    public void setAuthDataGoogleAccUser(String login, String password){
        Pages.googleAuthPage().setEmailGoogleAccount(login);
        Pages.googleAuthPage().clickNextGoogleAccountAuth();
        Pages.googleAuthPage().setPasswordGoogleAccount(password);
        Pages.googleAuthPage().clickSingInGoogleAccount();
        Pages.googleAuthPage().waitApprovePermission();
        Pages.googleAuthPage().clickApprovePermission();
        Pages.googleAuthPage().switchToDefaultTab();
    }
}
