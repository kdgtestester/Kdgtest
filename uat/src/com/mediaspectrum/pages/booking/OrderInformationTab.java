package com.mediaspectrum.pages.booking;

import com.mediaspectrum.utils.Address;
import com.mediaspectrum.utils.ProductData;
import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;
import com.qatestlab.utils.Constants;
import org.testng.Assert;

public class OrderInformationTab extends BasePage {

    public void waitProductAddToShoppingCart(String productName){
        waitForElementPresent("shoppingCardProductByNamePattern", productName);
    }

    public void selectPaymentMethod(String paymentMethod){
        waitForElementToBeClickable("paymentDropDownHeader");
        click("Clicking on payment method dropdown header", "paymentDropDownHeader");
        clickByXpathWithJS("Clicking on payment method :" + paymentMethod, "dropdownOption", paymentMethod);
    }

    public void selectPrimatyAgency(String agencyName){
        waitForElementToBeClickable("agencyDropdownHeader");
        click("Clicking on primary agency dropdown header", "agencyDropdownHeader");
        clickByXpathWithJS("Clicking on agency :" +agencyName, "dropdownOption", agencyName);
    }

    public boolean isProductInShoppingCart(String productName){
        return isElementPresent("shoppingCardProductByNamePattern", productName);
    }

    public void clickProductInShoppingCart(String productName){
        if(isElementVisibleWithWait(Constants.ELEMENT_EXTRASMALL_TIMEOUT_SECONDS, "totalPriceLoader")) waitForElementInvisibility("totalPriceLoader");
        waitForElementToBeClickable("shoppingCardProductByNamePattern", productName);
        click(String.format("Clicking on product %s in shopping cart", productName),
                "shoppingCardProductByNamePattern", productName);
    }

    public void clickSaveOrderButton(){
        if(isElementVisible("totalPriceLoader")) waitForElementInvisibility("totalPriceLoader");
        wait(15);
        click("Clicking save order button", "saveOrderButton");
        waitForElementVisibility("oderNumber");
        waitForElementInvisibility("totalPriceLoader");
        wait(15);
    }

    public boolean isErrorsPresent() {
        if(isElementVisibleWithWait(Constants.ELEMENT_EXTRASMALL_TIMEOUT_SECONDS, "loaderWidget")) waitForElementInvisibility("loaderWidget");
        Reporter.log("Checking shopping cart does not contains errors");
        return isElementPresent("errorMessage");
    }

    public String getOrderID(){
        return getElementText("Store order ID", "oderNumber");
    }

    public void assertTotalPricePresent(){
        Reporter.log("Checking total price is present");
        Assert.assertTrue(isElementPresent("totalPriceArea"),
                "Total price is not displayed");
    }

    public void clickPlaceOrderButton(){
        waitForElementEnable("placeOrderButton");
        click("Clicking place order button", "placeOrderButton");
        if(isElementVisibleWithWait(Constants.ELEMENT_EXTRASMALL_TIMEOUT_SECONDS, "confirmPopupButton"))
            click("Clicking approve dialog button", "confirmPopupButton");
    }

    public void clickPriceManagmentTab(){
        wait(5);
        if(isElementVisible("loaderWidget")) waitForElementInvisibility("loaderWidget");
        click("Clicking price management tab", "priceManagementTab");
    }

    public Double getProductPrice(String productName){
        return Double.valueOf(getElementText("Getting price of product : " + productName,
                "shoppingCartProductPriceByNamePattern", productName).replaceAll("[^\\d.]", ""));
    }

    public void clickPrescriptionButton(){
        click("Clicking  prescription button", "prescriptionsButton");
        waitForElementVisibility("prescriptionsDialogTitle");
    }

    public void checkProductCheckbox(String product){
        click(String.format("Clicking %s checkbox", product), "productCheckboxByNameIDPattern", product);
    }

    public void selectPrescriptionGroup(String prescriptionGroup){
        waitForElementToBeClickable("prescriptionGroupSelector");
        click("Clicking on prescription group dropdown header", "prescriptionGroupSelector");
        waitForElementToBeClickable("prescriptionGroupDropDownOption", prescriptionGroup);
        clickByXpathWithJS("Clicking on prescription group :" + prescriptionGroup, "prescriptionGroupDropDownOption", prescriptionGroup);
    }

    public void selectPrescription(String prescription){
        waitForElementToBeClickable("prescriptionSelector");
        click("Clicking on prescription dropdown header", "prescriptionSelector");
        waitForElementToBeClickable("prescriptionDropDownOption", prescription);
        clickByXpathWithJS("Clicking on prescription :" + prescription, "prescriptionDropDownOption", prescription);
    }

    public void clickAddPrescriptionButton(){
        click("Clicking add prescription button", "addPrescriptionButton");
    }

    public boolean isPrescriptionAdded(ProductData productData){
        if(!isElementPresentWithWait(Constants.ELEMENT_MICRO_TIMEOUT_SECONDS,
                "addedPrescriptionByProductPattern", productData.getProductUniqueId())) return false;

        return getElementText("Check prescription added", "addedPrescriptionByProductPattern", productData.getProductUniqueId())
                .contains(productData.getProductPrescriptionGroup());
    }

    public void clickClosePrescriptionsDialogButtons(){
        click("Clicking close prescriptions button", "closePopupDialogButton");
    }

    public void clickExpandOrderInfoButton(String productName){
        click("Click expand order info of product : " + productName, "expandOrderInfoByProductName", productName);
    }

    public void checkFirstDateCheckbox(){
        Reporter.log("Check first date from expanded order information");
        getElements("datesCheckboxes").get(0).click();
    }

    public void moveMouseToProductName(String productName){
        mouseMove("Move mouse to shopping cart product " + productName, "shoppingCardProductByNamePattern", productName);
        waitForElementVisibility("splitWithContentButton");
    }

    public void clickSplitWithContentButton(){
        click("Clicking split with content button", "splitWithContentButton");
        if(isElementVisibleWithWait(1, "totalPriceLoader")) waitForElementInvisibility("totalPriceLoader");
    }

    public int getShoppingCartProductsCount(String productName){
        Reporter.log("Get count of products : " + productName);
        return getElementsCount("shoppingCardProductByNamePattern", productName);
    }

    public void clickProductInShoppingCart(int position, String productName){
        if(isElementVisibleWithWait(Constants.ELEMENT_EXTRASMALL_TIMEOUT_SECONDS, "totalPriceLoader")) waitForElementInvisibility("totalPriceLoader");
        waitForElementToBeClickable("shoppingCardProductByNamePattern", productName);
        click(String.format("Clicking on product %s in shopping cart", productName),
                "shoppingCartProductByNameAndPosition", position, productName);
    }

    public void clickAdministrativeButton(){
        waitForElementEnable("administrativeButton");
        click("Clicking administrative button", "administrativeButton");
        waitForElementVisibility("administrativeDialogTitle");
    }

    public void selectProposalAddress(Address proposalAddress){
        String searchKey = String.format("%s, %s", proposalAddress.getStreet(), proposalAddress.getStreetNumber());
        waitForElementToBeClickable("proposalAddressSelector");
        click("Clicking on proposal address dropdown header", "proposalAddressSelector");
        waitForElementPresent("dropdownOption", searchKey);
        click("Clicking on proposal address :" + searchKey, "dropdownOption", searchKey);
    }

    public void selectBillingAddress(String billingAddress){
        waitForElementToBeClickable("billingAddressSelector");
        click("Clicking on billing address dropdown header", "billingAddressSelector");
        waitForElementPresent("dropdownOption", billingAddress);
        click("Clicking on billing address :" + billingAddress, "dropdownOption", billingAddress);
    }

    public void clickApllyAdministrativeButton(){
        click("Click apply administrative changes button", "applyAdministrativeButton");
    }

    public String getSelectedProfitCenter(){
        return getElementAttributeValue("Getting selected profit center value", "title", "profitCenterSelector");
    }

    public void clickNewOrderButton(){
        waitForElementEnable("newOrderButton");
        click("Clicking new order button", "newOrderButton");
    }


    public void selectInternalProvenance(String internalProvenance){
        waitForElementVisibility("internalProvenanceInput");
        type(String.format("Typing Internal Provenance <b>%s</b>", internalProvenance), internalProvenance, "internalProvenanceInput");
        waitForElementPresent("dropdownOption", internalProvenance);
        click("Clicking on Internal Provenance: " + internalProvenance, "dropdownOption", internalProvenance);
        waitForElementPresent("internalProvenanceValue", internalProvenance);
    }

}
