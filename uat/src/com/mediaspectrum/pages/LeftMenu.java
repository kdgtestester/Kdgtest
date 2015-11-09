package com.mediaspectrum.pages;

import com.testmatick.base.BasePage;

public class LeftMenu extends BasePage{

    public void clickCreatePartnerButton(){
        click("Clicking create partner button", "createPartnerButton");
    }

    public void clickCreateContractButton(){
        click("Clicking create contract button", "createContractButton");
    }

    public void clickCreateActivityButton() {click("Clicking create activity button", "createActivityButton");}
}
