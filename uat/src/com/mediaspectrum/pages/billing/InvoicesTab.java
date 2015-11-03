package com.mediaspectrum.pages.billing;

import com.qatestlab.base.BasePage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class InvoicesTab extends BasePage {

    public void typePartnerID(String partnerId){
        type("Typing partner id + " + partnerId, partnerId, "partnerIdInput");
        waitForElementInvisibility("partnerInputIDLoader");
    }

    public void typeOrderID(String orderID){
        type("Typing order id" + orderID, orderID, "orderIDInput");
    }

    public void clickSearchButton(){
        click("Clicking search button", "searchButton");
        waitForElementInvisibility("searchingLoader");
    }

    public List<String> getInvoicesStatuses(String customerID){

        List<String> statuses = new ArrayList<>();

        for(WebElement element : getElements("invoiceItemStatus", customerID)){
            statuses.add(element.getText());
        }
        return statuses;
    }

    public String getInvoiceNumber(){
        return getInvoicesNumbers().get(0);
    }

    public List<String> getInvoicesNumbers(){

        List<String> invoiceNumbers = new ArrayList<>();
        for(WebElement element : getElements("invoiceNumber")){
            invoiceNumbers.add(element.getText());
        }

        return invoiceNumbers;
    }

    public void waitForInvoiceNumber(){
        for(int i = 0; i < 10; i++){

            if(getInvoiceNumber().contains("TMP")){
                clickSearchButton();
                wait(30);
            } else break;

        }
    }



}
