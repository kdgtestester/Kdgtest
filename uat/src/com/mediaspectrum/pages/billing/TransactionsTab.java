package com.mediaspectrum.pages.billing;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;

public class TransactionsTab extends BasePage {

    public void waitPageToLoad(){
        Reporter.log("Wait transactions page load");
        waitForElementVisibility("partnerIdInput");
    }

    public void typePartnerID(String partnerId){
        type("Typing partner id : " + partnerId, partnerId, "partnerIdInput");
        waitForElementInvisibility("partnerInputIDLoader");
    }

    public void typeOrderID(String orderID){
        type("Typing order id : " + orderID, orderID, "orderIDInput");
    }

    public void clickSearchButton(){
        waitForElementToBeClickable("searchButton");
        click("Clicking search button", "searchButton");
        waitForElementInvisibility("searchingLoader");
        waitForElementInvisibility("orderLoader");
    }

    public boolean isOrderFound(String orderID){
        Reporter.log("Checking order found");
        return isElementVisible("orderItemByIDPattern", orderID);
    }

    public void expandOrderData(String orderID){
        if(isElementPresent("selectAllCheckboxByOrderIDPattern", orderID)){ return;
        } else click("Clicking expand order button", "expandOrderItemButtonByIDpattern", orderID);
    }

    public void clickSelectAllCheckbox(String orderID){
        click("Clicking select all order items checkbox", "selectAllCheckboxByOrderIDPattern", orderID);
    }

    public void clickInvoiceNowButton(){
        click("Clicking invoice now button", "invoiceNowButton");
        waitForElementVisibility("successInvoiceGeneratingMessage");
    }

    public void clickInvoicesTab(){
        click("Clicking invoices tab", "invoicesTabLink");
    }


}
