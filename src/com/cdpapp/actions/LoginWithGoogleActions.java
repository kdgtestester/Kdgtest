package com.cdpapp.actions;

import com.cdpapp.control.Pages;
import com.qatestlab.base.BasePage;

public class LoginWithGoogleActions {

    public void loginWithGoogle(){
        Pages.loginPage().open();
        Pages.loginPage().clickLoginWithGoogleButton();
        Pages.loginPage().switchToNewTab();
        Pages.googleAuthPage().waitSingInGoogleAccountHeader();
    }

    public void setGoogleAccData(String login, String password){
        Pages.googleAuthPage().setEmailGoogleAccount(login);
        Pages.googleAuthPage().clickNextGoogleAccountAuth();
        Pages.googleAuthPage().setPasswordGoogleAccount(password);
    }

    public void singInGoogleAccount(){
        Pages.googleAuthPage().clickSingInGoogleAccount();
        Pages.googleAuthPage().waitApprovePermission();
        Pages.googleAuthPage().clickApprovePermission();
        Pages.googleAuthPage().switchToDefaultTab();
    }
}
