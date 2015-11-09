package com.mediaspectrum.actions;


import com.mediaspectrum.control.WebAdminPages;
import com.mediaspectrum.utils.UserData;
import com.testmatick.base.BaseActions;
import com.testmatick.utils.Constants;

public class WebAdminActions extends BaseActions{

    public void goLogin(String login, String password){
        WebAdminPages.adminLoginPage().openStartPage();
        WebAdminPages.adminLoginPage().setSystemLanguage(Constants.DEFAULT_SYSTEM_LANGUAGE);
        WebAdminPages.adminLoginPage().typeLogin(login);
        WebAdminPages.adminLoginPage().typePassword(password);
        WebAdminPages.adminLoginPage().clickLoginButton();
        WebAdminPages.navigatorMenu().wautForPageLoad();
    }

    public void createUser(UserData userData){

        WebAdminPages.navigatorMenu().navigateToUsers();
        WebAdminPages.usersTab().waitForPageLoad();
        WebAdminPages.usersTab().typeFirstName(userData.getFirstName());
        WebAdminPages.usersTab().typeLastName(userData.getLastName());
        WebAdminPages.usersTab().typeLogin(userData.getLogin());
        WebAdminPages.usersTab().typePassword(userData.getPassword());
        WebAdminPages.usersTab().typePasswordConfirmation(userData.getConfirmPassword());
        WebAdminPages.usersTab().setCheckboxIgnorePasswordAginState(userData.isIgnorePasswordAging());
        WebAdminPages.usersTab().selectCompany(userData.getCompany());
        if(isNotNull(userData.getJobFunction())) WebAdminPages.usersTab().selectJobFunction(userData.getJobFunction());
        WebAdminPages.usersTab().clickSaveButton();

        if(!userData.getAccessRules().isEmpty()){
            WebAdminPages.usersTab().clickSetAccessButton();
            for(String accessRule : userData.getAccessRules()){WebAdminPages.usersTab().highlightOption(accessRule);}
            WebAdminPages.usersTab().addOptions();
            WebAdminPages.usersTab().clickSaveSettingsButton();
        }

        if(isNotNull(userData.getGroups())){
            WebAdminPages.usersTab().clickSetGroupsButton();
            for(String group : userData.getGroups()){WebAdminPages.usersTab().highlightOption(group);}
            WebAdminPages.usersTab().addOptions();
            WebAdminPages.usersTab().clickSaveSettingsButton();
        }

        WebAdminPages.usersTab().clickSaveButton();
    }

}
