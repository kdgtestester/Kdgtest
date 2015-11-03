package com.cdpapp.pages;

import com.cdpapp.control.DataArtsConstans;
import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public void open(){
        Reporter.log("Opening login page");
        driver.get(DataArtsConstans.BASE_URL);
    }

    public void clickLoginWithGoogleButton(){
        click("Click login in with google button", "loginWithGoogleButton");
    }
}
