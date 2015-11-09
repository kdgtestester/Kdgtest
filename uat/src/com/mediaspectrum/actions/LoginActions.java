package com.mediaspectrum.actions;


import com.mediaspectrum.control.Pages;
import com.testmatick.base.BaseActions;


public class LoginActions extends BaseActions {

    public void openLoginPage() {
        Pages.loginPage().openStartPage();
    }

    public void doLogin(String login, String password) {
        Pages.loginPage().typeLogin(login);
        Pages.loginPage().typePassword(password);
        Pages.loginPage().clickLoginButton();
        Pages.topMenu().waitForLoad();
    }

    public void doLogin(String login, String password, String systemLanguage) {
        Pages.loginPage().setSystemLanguage(systemLanguage);
        doLogin(login, password);
    }

    public void logout(){
        Pages.topMenu().clickLogoutButton();
    }

}
