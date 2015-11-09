package com.mediaspectrum.pages.dashboard;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Constants;
import com.testmatick.utils.Random;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DashboardPage extends BasePage{
    public void waitPageLoad(){
        Reporter.log("Waiting dashboard page loaded");
        waitForElementVisibility("searchCriteriaSelector");
        waitForElementInvisibility("searchResultsWaitLoader");
    }

    public void selectSearchCriteria(String orderSearchCriteria) {
        waitForElementToBeClickable("searchCriteriaSelector");
        click("Clicking on search criteria dropdown header", "searchCriteriaSelector");
        clickByXpathWithJS("Select search criteria: "+orderSearchCriteria, "dropdownOption", orderSearchCriteria);
    }

    public void selectSearchEqualsTypeCriteria(){
        waitForElementToBeClickable("searchTypeSelector");
        click("Clicking on search type dropdown header", "searchTypeSelector");
        waitForElementToBeClickable("searchOrderNumTypeOption");
        click("Select search type equals.", "searchOrderNumTypeOption");
    }

    public void selectSearchCriteriaType(String criteriaType){
        waitForElementToBeClickable("searchTypeSelector");
        click("Clicking on search type dropdown header", "searchTypeSelector");
        waitForElementToBeClickable("criteriaTypeDropdownOption", criteriaType);
        clickByXpathWithJS("Select search type equals.", "criteriaTypeDropdownOption", criteriaType);
    }

    public void typeSearchKeyWord(String keyWords){
        type("Typing keywords to search input: " + keyWords, keyWords, "searchKeyWordsInput");
        Reporter.log("Wait until search completed");
        waitForElementInvisibility("searchResultsWaitLoader");
    }

    public Boolean isOrderWithIdPresent(String orderId){
        Reporter.log(String.format("Checking order id: %s visibility", orderId));
        return isElementPresent("orderByIdPattern", orderId);
    }

    public void clickSearchButton() {
        click("Clicking search button", "searchButton");
        waitForElementInvisibility("searchResultsWaitLoader");
    }

    public Boolean isOrdersPresent(){
        return getElements("orders").size() > 0;
    }

    public void clickSelectDateButton(){
        clickByXpathWithJS("Clicking on select date button", "selectDateButton");
        waitForElementVisibility("firstMonthTable");
    }

    public void switchToPreviousMonth(){

        Calendar currentMonth = Calendar.getInstance();

        DateFormat dateFormat = new SimpleDateFormat("MMM", Locale.US);
        Calendar dateTableMonth = Calendar.getInstance();
        try {
            dateTableMonth.setTime(dateFormat.parse(getElementText("", "firstMonthTable")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (dateTableMonth.get(Calendar.MONTH) >= currentMonth.get(Calendar.MONTH)){
            click("Clicking previous month button", "previousMonthButton");
            waitForElementToBeClickable("firstMonthTable");
            if(dateTableMonth.get(Calendar.MONTH) == 0) break;
            try {
                dateTableMonth.setTime(dateFormat.parse(getElementText("", "firstMonthTable")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public Calendar selectRandomDate(){
        List<WebElement> elements = getElements("dateItem");
        int index = Random.genInt(0, elements.size()-1);

        Calendar selectedDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy");

        try {
            selectedDate.setTime(dateFormat.parse(elements.get(index).getAttribute("class")));
            elements.get(index).click();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        selectedDate.add(Calendar.MONTH, 1);
        return selectedDate;
    }

    public boolean isSearchResultsHasCorrectDate(Calendar calendar){
        int iteration = 0;

        Calendar orderDate = Calendar.getInstance();
        DateFormat orderDateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.US);

        // Calculate difference between UCT and CET
        long currentTime = System.currentTimeMillis();
        int cetOffset = TimeZone.getTimeZone("CET").getOffset(currentTime);
        int defaultOffset = TimeZone.getDefault().getOffset(currentTime);
        int zonesDifference = (cetOffset - defaultOffset);

        while(isOrdersPresent()){
            iteration++;
            List<WebElement> webElements = getElements("ordersCreationTime");

            for(WebElement webElement : webElements){
                try {
                    String orderDateString = webElement.getText();
                    orderDate.setTime(orderDateFormat.parse(orderDateString));
                    orderDate.add(Calendar.MILLISECOND, zonesDifference);
                    Reporter.log("Checking : " + orderDateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if((calendar.get(Calendar.DAY_OF_YEAR))!=(orderDate.get(Calendar.DAY_OF_YEAR))){
                    return false;
                }
            }

            if(iteration > 10 || !isElementVisible("nextResultsPageButton")) break;

            click("Clicking next results button", "nextResultsPageButton");
            waitForElementInvisibility("searchResultsWaitLoader");
        }
        return true;
    }

    public void clickOrderById(String orderId){
        click("Clicking order with id : " + orderId, "orderByIdPattern", orderId);
        waitForElementVisibility("orderInfoTitle");
    }

    public String getOrderStatus(){
        return getElementText("Getting order status", "orderStatus");
    }

    public boolean isProductDisplayedInOrderInfo(String productName){
        Reporter.log(String.format("Check product %s is present in order information", productName));
        return isElementPresent("orderedProductByNamePattern", productName);
    }

    public void clickEditOrderButton(){
        waitForElementToBeClickable("editOrderButton");
        click("Clicking edit order button", "editOrderButton");
    }

    public void waitOrderInvoiced(){
        long startTime = System.currentTimeMillis(); //fetch starting time
        while (!isElementVisible("editOrderButton") && ((System.currentTimeMillis() - startTime) / 1000) < Constants.ELEMENT_MEGA_EXTRALONG_TIMEOUT_SECONDS) {
            wait(10);
            driver.navigate().refresh();
        }
    }


}
