package com.mediaspectrum.pages.webadmin;


import com.testmatick.base.BasePage;

public class NavigatorMenu extends BasePage{

    public void wautForPageLoad() {
        waitForElementVisibility("navigatorPanel");
    }

    public void navigateToUsers(){
        waitForElementToBeClickable("listElementHeader", "Users and Security");
        click("Clicking on users and security header", "listElementHeader", "Users and Security");
        waitForElementToBeClickable("listElementSubHeader", "Users");
        click("Clicking on users header", "listElementSubHeader", "Users");
    }

}
