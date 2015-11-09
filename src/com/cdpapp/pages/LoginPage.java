package com.cdpapp.pages;

import com.cdpapp.control.DataArtsConstans;
import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;

public class LoginPage extends BasePage {

    public void open(){
        Reporter.log("Opening login page");
        driver.get(DataArtsConstans.BASE_URL);
    }

    public void clickLoginWithGoogleButton(){
        click("Click login in with google button", "loginWithGoogleButton");
    }
}
