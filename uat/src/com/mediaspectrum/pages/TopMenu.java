package com.mediaspectrum.pages;

import com.qatestlab.base.BasePage;

public class TopMenu extends BasePage {

    public void waitForLoad() {
        waitForElementPresent("logoutButton");
    }

    public void clickPartnersLink() {
        super.click("Clicking on Partners link in top menu", "partnersLink");
    }

    public void clickDashBoardLink(){
        click("Clicking on dashboard link", "dashboardLink");
    }

    public void clickLogoutButton() {click("Clicking logout button", "logoutButton");}

    public void clickBillingLink() {click("Clicking billing link", "billingLink");}

    public void clickContractsLink(){
        click("Clicking contracts link", "contractsLink");
    }

    public void clickApprovalsLink(){
        click("Clicking approvals link", "approvalsLink");
    }



}
