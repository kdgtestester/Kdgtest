package com.mediaspectrum.pages.approvals;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;

public class ApprovalsPage extends BasePage {

    public void waitPageToLoad(){
        Reporter.log("Waiting approvals page loads");
        waitForElementVisibility("orderNumberSearchField");
    }

    public void setOrderNumber(String orderNumber){
        type("Type order number", orderNumber, "orderNumberSearchField");
        click("Select order number from dropdown", "searchDropdownOption", orderNumber);
    }

    public void clickSearchButton(){
        click("Click search button", "searchButton");
        waitForElementInvisibility("loadingOverlay");
    }

    public void expandOrder(){
        click("Expand order", "expandOrder");
        waitForElementVisibility("orderApprovalsTab");
    }

    public void clickOrderApprovalsTab() {
       click("Clicking order approvals tab", "orderApprovalsTab");
    }

    public void changeCreditCheckboxState(boolean state) {
        setCheckboxState("Change credits checkbox state", state, "creditCheckbox");
    }

    public void clickRejectButton(){
        click("Click Reject button", "rejectButton");
    }

    public void clickApproveButton(){
        click("Click Approve button", "approveButton");
    }

    public void selectRejectReason(String reason){
        click("Expand reason dropdown", "approvalRemoveReasonDropdown");
        waitForElementVisibility("approvalRemoveReasonDropdownOptions", reason);
        click("Selecting reason", "approvalRemoveReasonDropdownOptions", reason);
    }

    public void typeDetails(String details){
        type("Type reject reason details", details, "approvalRemoveDetails");
    }

    public void confirmReject(){
        click("Confirm reject order", "approvalRemoveConfirm");
        waitForElementInvisibility("loadingOverlay");
    }

    public boolean isOrderPresentOnApprovalsPage(String orderId){
        return isElementVisible("orderPresentOnDashboard", orderId);
    }
}
