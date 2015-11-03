package com.mediaspectrum.pages.dashboard;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class OrdersPage extends BasePage{

    public void waitForPageLoad(){
        Reporter.log("Waiting order page to load");
        waitForElementVisibility("pageLabel");
        waitForElementInvisibility("searchResultsWaitLoader");
    }

    public Boolean isOrderWithIdPresent(String orderId){
        Reporter.log(String.format("Checking order id: %s visibility", orderId));
        return isElementPresent("orderByIdPattern", orderId);
    }

    public String getOrderStatus(){
        return getElementText("Getting order status", "orderStatus");
    }

}
