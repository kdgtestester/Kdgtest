package com.mediaspectrum.pages.booking;

import com.testmatick.base.BasePage;
import com.testmatick.reporting.Reporter;
import com.testmatick.utils.Constants;
import com.testmatick.utils.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScheduleAdvancedTab extends BasePage {

    public void waitForPageToLoad() {
        waitForElementInvisibility("loaderWidget");
        waitForElementVisibility("scheduleBookingTab");

    }

    public void searchSelectProduct(String product, String productUniqueID) {
        waitForElementVisibility("productSearchInput");
        type(String.format("Search product <b>%s</b>", product), product, "productSearchInput");
        product = product.split("%")[0];
        wait(5);
        waitForElementToBeClickable("productNameWithUniqueID", product, productUniqueID);
        click("Clicking on searched product", "productNameWithUniqueID", product, productUniqueID);
        waitForElementPresent("selectedProduct", productUniqueID);
    }

    public void selectProductType(String productType) {
        if(getElementAttributeValue("Checking product type selected value", "title",
                "productTypeSelector").equals(productType)) return;
        waitForElementToBeClickable("productTypeSelector");
        click("Clicking on select product type dropdown header", "productTypeSelector");
        waitForElementPresent("dropdownOption", productType);
        click("Select product product type: " + productType, "dropdownOption", productType);
    }

    public String getProductTypeSelectedValue(){
        return getElementAttributeValue("Checking product type selected value", "title","productTypeSelector");
    }

    public boolean isProductTypeSelectorAvailable(){
        Reporter.log("Checking product type selector availability");
        return !isElementHasAttribute("disabled", "productTypeSelector");
    }

    public Boolean isProductSelected(String productName, String productUniqueID){
        Reporter.log(String.format("Checking product %s is selected", productName));
        return isElementPresent("selectedProduct", productName, productUniqueID);
    }

    public void checkProductRadioButton(String productUniqueID){
        setCheckboxState(String.format("Check product with id: %s checkbox", productUniqueID),
                true, "selectedProduct", productUniqueID);
    }

    public void waitForProductPageLoad(String productUniqueID){
        waitForElementVisibility("selectedProduct", productUniqueID);
    }

    public void selectProductHeading(String productHeading) {
        if(getElementAttributeValue("Checking product heading selected value", "title",
                "productHeaderSelector").equals(productHeading)) return;
        waitForElementToBeClickable("productHeaderSelector");
        // Wait to prevent bug when dropdown disappears in few seconds after click
        wait(10);
        click("Clicking on select product heading dropdown header", "productHeaderSelector");
        waitForElementPresent("dropdownOption", productHeading);
        clickByXpathWithJS("Select product heading: " + productHeading, "dropdownOption", productHeading);
    }

    public String getProductHeadingSelectedValue(){
        return getElementAttributeValue("Checking product heading selected value", "title","productHeaderSelector");
    }

    public boolean isProductHeadingSelectorAvailable(){
        Reporter.log("Checking product heading selector availability");
        return !isElementHasAttribute("disabled", "productHeaderSelector");
    }

    public void selectProductTextBorder(String textBorder) {
        if(getElementAttributeValue("Checking product text border selected value", "title",
                "productTextBorderSelector").equals(textBorder)) return;
        waitForElementToBeClickable("productTextBorderSelector");
        click("clicking on select product text border heading dropdown", "productTextBorderSelector");
        waitForElementPresent("dropdownOption", textBorder);
        click("Select product text border " + textBorder, "dropdownOption", textBorder);
    }

    public void selectProductSubHeading(String productSubHeading) {
        if(getElementAttributeValue("Checking product sub-heading selected value", "title",
                "productSubHeaderSelector").equals(productSubHeading)) return;
        waitForElementToBeClickable("productSubHeaderSelector");
        click("Clicking on select product sub-heading dropdown header", "productSubHeaderSelector");
        waitForElementPresent("dropdownOption", productSubHeading);
        click("Select product product sub-heading: " + productSubHeading, "dropdownOption", productSubHeading);
    }

    public String getProductSubHeadingSelectedValue(){
        return getElementAttributeValue("Checking product sub heading selected value", "title","productSubHeaderSelector");
    }

    public boolean isProductSubHeadingSelectorAvailable(){
        Reporter.log("Checking product sub heading selector availability");
        return !isElementHasAttribute("disabled", "productSubHeaderSelector");
    }

    public void selectProductCompositePosition(String productCompositePosition) {
        if(getElementAttributeValue("Checking product composite position selected value", "title",
                "productCompositePositionSelector").equals(productCompositePosition)) return;
        waitForElementToBeClickable("productCompositePositionSelector");
        click("Clicking on select product composite position dropdown header", "productCompositePositionSelector");
        waitForElementPresent("dropdownOption", productCompositePosition);
        click("Select product product composite position: " + productCompositePosition, "dropdownOption", productCompositePosition);
    }

    public void selectProductAdStructure(String productAdStructure) {
        if(getElementAttributeValue("Checking product  ad structure selected value", "title",
                "productAdStructureSelector").equals(productAdStructure)) return;
        waitForElementToBeClickable("productAdStructureSelector");
        click("Clicking on select product ad structure dropdown header", "productAdStructureSelector");
        waitForElementPresent("dropdownOption", productAdStructure);
        click("Select product product ad structure: " + productAdStructure, "dropdownOption", productAdStructure);
    }

    public void selectProductBleed(String productBleed) {
        if(getElementAttributeValue("Checking product bleed selected value", "title",
                "productBleedSelector").equals(productBleed)) return;
        waitForElementToBeClickable("productBleedSelector");
        click("Clicking on select product bleed dropdown header", "productBleedSelector");
        waitForElementPresent("dropdownOption", productBleed);
        click("Select product bleed: " + productBleed, "dropdownOption", productBleed);
    }

    public void selectProductRateType(String productRateType) {

        waitForElementToBeClickable("productRateTypeSelector");
        click("Clicking on select product rate type dropdown header", "productRateTypeSelector");
        waitForElementPresent("dropdownOption", productRateType);
        click("Select product rate type: " + productRateType, "dropdownOption", productRateType);
    }

    public void selectProductClientType(String productClientType) {
        if(getElementAttributeValue("Checking product client type selected value", "title",
                "productClientTypeSelector").equals(productClientType)) return;
        waitForElementToBeClickable("productClientTypeSelector");
        click("Clicking on select product client type dropdown header", "productClientTypeSelector");
        waitForElementPresent("dropdownOption", productClientType);
        click("Select product client type: " + productClientType, "dropdownOption", productClientType);
    }

    public void selectProductColor(String productColor) {
        if(getElementAttributeValue("Checking product color selected value", "title",
                "productColorSelector").contains(productColor)) return;
        waitForElementToBeClickable("productColorSelector");
        click("Clicking on select product color dropdown header", "productColorSelector");
        waitForElementPresent("dropdownOption", productColor);
        click("Select product color: " + productColor, "dropdownOption", productColor);
    }

    public void selectProductSize(String productSize) {
        if(getElementAttributeValue("Checking product size selected value", "title",
                "productSizeSelector").contains(productSize)) return;
        waitForElementToBeClickable("productSizeSelector");
        click("Clicking on select product size dropdown header", "productSizeSelector");
        waitForElementPresent("dropdownOption", productSize);
        click("Select product size: " + productSize, "dropdownOption", productSize);
    }

    public String getProductSizeSelectedValue(){
        return getElementAttributeValue("Checking product size selected value", "title","productSizeSelector");
    }

    public boolean isProductSizeSelectorAvailable(){
        Reporter.log("Checking product size selector availability");
        return !isElementHasAttribute("disabled", "productSizeSelector");
    }

    public void selectProductPrescriptionSize(String productPrescriptionSize) {
        if(getElementAttributeValue("Checking product prescription size selected value", "title",
                "prescriptionSizeSelector").equals(productPrescriptionSize)) return;
        waitForElementToBeClickable("prescriptionSizeSelector");
        click("Clicking on select product prescription size dropdown header", "prescriptionSizeSelector");
        waitForElementPresent("dropdownOption", productPrescriptionSize);
        click("Select product prescription size: " + productPrescriptionSize, "dropdownOption", productPrescriptionSize);
    }

    public String getProductPrescriptionSizeSelectedValue(){
        return getElementAttributeValue("Checking product prescription size selected value", "title", "prescriptionSizeSelector");
    }

    public boolean isProductPrescriptionSizeSelectorAvailable(){
        Reporter.log("Checking product prescription size selector availability");
        return !isElementHasAttribute("disabled", "prescriptionSizeSelector");
    }

    public void selectDatesRandomly(int count){
        waitForElementToBeClickable("orderDatesSelector");
        click("Clicking on dates table header", "orderDatesSelector");
        waitForElementPresent("calendarView");
        click("Clicking clear dates button", "clearDatesButton");
        List<WebElement> elements = getElements("calendarActiveElement");
        for(int i =0; i < count; i++){
            wait(2);
            ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].click();" ,elements.get(Random.genInt(0, elements.size()-1)));
        }

        Assert.assertEquals(count, getElementsCount("calendarSelectedDayElement"),
                "Dates set incorrectly");

        click("Clicking apply selected dates button", "applyDatesButton");
    }

    public void addDatesRandomly(int count){
        waitForElementToBeClickable("orderDatesSelector");
        click("Clicking on dates table header", "orderDatesSelector");
        waitForElementPresent("calendarView");
        List<WebElement> elements = getElements("calendarActiveElement");
        for(int i =0; i < count; i++){
            wait(2);
            ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].click();", elements.get(Random.genInt(0, elements.size() - 1)));
        }
        click("Clicking apply selected dates button", "applyDatesButton");
    }

    public void selectRandomOnlineDate(){
        waitForElementToBeClickable("orderDatesSelector");
        click("Clicking on dates table header", "orderDatesSelector");
        List<WebElement> elements = getElements("calendarItemForOnlineProduct");
        ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].click();" ,elements.get(Random.genInt(0, elements.size()-1)));
    }


    public void setDates(List<Calendar> dates){
        waitForElementToBeClickable("orderDatesSelector");
        click("Clicking on dates table header", "orderDatesSelector");
        waitForElementPresent("calendarView");
        click("Clicking clear dates button", "clearDatesButton");
        for(Calendar date : dates){
            moveCalendarFormToMonth(date);

            click("Clicking on date: " + date.getTime().toString(), "calendarDayElementWithPattern",
                    date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        }

        Assert.assertEquals(dates.size(), getElementsCount("calendarSelectedDayElement"),
                "Dates set incorrectly");

        click("Clicking apply selected dates button", "applyDatesButton");
    }

    public void setDateWithExtendedCirculation(){
        waitForElementToBeClickable("orderDatesSelector");
        click("Clicking on dates table header", "orderDatesSelector");
        click("Clicking clear dates button", "clearDatesButton");
        getElements("calendarExtendedActiveElement").get(0).click();
        click("Clicking apply selected dates button", "applyDatesButton");
    }

    public void moveCalendarFormToMonth(Calendar date){
        DateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.US);
        Calendar currentCalendarPosition = Calendar.getInstance();
        do {

            try {
                currentCalendarPosition.setTime(dateFormat.parse(String.format("%s %s",
                        getElementText("Getting current calendar month", "lastCalendarMonth"),
                        getElementText("Getting current calendar year", "lastCalendarYear"))));
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            if(date.after(currentCalendarPosition)) {
                click("Clicking next month calendar form", "moveCalendarFormForwardButton");
            }


        }while (date.after(currentCalendarPosition));
    }

    public void setReservationOnlyCheckboxState(Boolean state){
        waitForElementToBeClickable("reservationOnlyCheckbox");
        setCheckboxState("Set reservation only checkbox status" + state, state, "reservationOnlyCheckbox");
    }

    public void setSpecialRequestCheckboxState(Boolean state){
        waitForElementToBeClickable("specialRequestCheckbox");
        setCheckboxState("Set special request checkbox status" + state, state, "specialRequestCheckbox");
    }

    public void typeSpecialRequestDescription(String description){
        waitForElementVisibility("specialRequestDescriptionInput");
        type("Typing special request description : " + description, description, "specialRequestDescriptionInput");
    }

    public void selectProductContentType(String productContentType) {
        if(getElementAttributeValue("Checking product   content type selected value", "title",
                "productContentTypeSelector").equals(productContentType)) return;
        waitForElementToBeClickable("productContentTypeSelector");
        click("Clicking on select product content type dropdown header", "productContentTypeSelector");
        waitForElementPresent("dropdownOption", productContentType);
        click("Select product content type: " + productContentType, "dropdownOption", productContentType);
    }

    public void typeProductContentDescription(String description){
        waitForElementVisibility("productContentDescriptionInput");
        type("Typing product content description : " + description, description, "productContentDescriptionInput");
    }

    public void selectProductContentLanguage(String productContentLanguage) {
        if(getElementAttributeValue("Checking product content language selected value", "title",
                "productContentLanguage").equals(productContentLanguage)) return;
        waitForElementToBeClickable("productContentLanguage");
        click("Clicking on select product content language dropdown header", "productContentLanguage");
        waitForElementPresent("dropdownOption", productContentLanguage);
        click("Select product content language: " + productContentLanguage, "dropdownOption", productContentLanguage);
    }

    public void clickAddToOrderButton(){
        waitForElementToBeClickable("addProductToOrderButton");
        click("Clicking add to order button", "addProductToOrderButton");
        waitForElementInvisibility("productHeaderSelector");
    }

    public void clickRemoveProductButton(){
        waitForElementToBeClickable("removeProductButton");
        click("Clicking remove product button", "removeProductButton");
        waitForElementInvisibility("productHeaderSelector");
    }

    public void clickUieditorButton(){
        waitForElementToBeClickable("uieditorButton");
        click("String clicking uieditor button", "uieditorButton");
    }

    public boolean isUieditorButtonVisibile(){
        Reporter.log("Checking ui editor button visibility");
        return isElementVisible("uieditorButton");
    }

    public boolean isUieditorButtonEnamble(){
        return !getElementAttributeValue("Checking UiEditor button availability", "class", "uieditorButton").contains("disabled");
    }

    public String getSetDate(){
        waitForElementToBeClickable("orderDatesSelector");
        return getElementText("Getting selected date", "orderDatesSelector");
    }

    public void typeProductSizeHeight(String productHeight){
        waitForElementToBeClickable("productSizeHeight");
        typeWithWipe("Typing product column height : " + productHeight, productHeight, "productSizeHeight");
    }

    public void typeProductSizeLines(String productSizeLines){
        waitForElementPresent("productSizeLinesInput");
        type("Typing product size lines count : " + productSizeLines, productSizeLines, "productSizeLinesInput");
    }

    public boolean isPopupVisible(){
        Reporter.log("Checking popup visibility");
        return isElementPresentWithWait(Constants.ELEMENT_EXTRASMALL_TIMEOUT_SECONDS,"informationPopup");
    }

    public void confirmPopup(){
        waitForElementVisibility("popupLoader");
        waitForElementInvisibility("popupLoader");
        click("Clicking confirm popup button", "confirmButton");

        WebElement webElement = getElement("voucherCheckbox");
        webElement.isSelected();
    }

    public boolean isVoucherCheckboxVisible(){
        Reporter.log("Checking voucher checkbox visibility");
        return isElementVisible("voucherCheckbox");
    }

    public void clickAddNewProductToOrder(){

        click("Click add new product to order", "addNewProductButton");
        waitForElementVisibility("scheduleBookingTab");
    }

    public void clickBlindAdCheckbox(){
        waitForElementToBeClickable("productBindAdCheckBox");
        click("Click bind ad checkbox", "productBindAdCheckBox");
    }

    public boolean isOrderSavedAsDraft(){
        Reporter.log("Checking order status");
        return isElementPresent("orderDraftStatusMessage");
    }

    public void doYellowMenuAction(String actionName){
        mouseMove("Moving mouse to advertiser name", "advertiserYellowMenuHeader");
        waitForElementVisibility("yellowMenuItem", actionName);
        click("Clicking on action " + actionName, "yellowMenuItem", actionName);
    }
}
