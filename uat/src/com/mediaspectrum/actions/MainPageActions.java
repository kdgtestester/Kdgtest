package com.mediaspectrum.actions;


import com.mediaspectrum.control.ContractPages;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.ContractData;
import com.qatestlab.base.BaseActions;
import org.testng.Assert;

public class MainPageActions extends BaseActions {

    public void openMainPage() {
        Pages.mainPage().openPage();
    }

    public void filterCustomerByName(String customerName) {
        Pages.mainPage().waitForAllCustomersLoaded();
        Pages.mainPage().typeCustomerNameToFilter(customerName);
        Pages.mainPage().clickSearchButton();
    }

    public void openAdvancedBookingForCustomer(String customerName){
        Pages.mainPage().clickCustomersTab();
        filterCustomerByName(customerName);
        Pages.mainPage().clickAdvancedBookingLink();
    }

    public void assertOdrerPresentInDashboard(String orderID){
        Pages.topMenu().clickDashBoardLink();
        Pages.dashboardPage().waitPageLoad();
        Pages.dashboardPage().selectSearchCriteria("Order Number");
        Pages.dashboardPage().selectSearchEqualsTypeCriteria();
        Pages.dashboardPage().typeSearchKeyWord(orderID);
        Pages.dashboardPage().clickSearchButton();
        Assert.assertTrue(Pages.dashboardPage().isOrderWithIdPresent(orderID),
                String.format("Order with id: %s is not present in the list", orderID));
    }

    public void assertOrdersAvailible() {
        Pages.topMenu().clickDashBoardLink();
        Pages.dashboardPage().waitPageLoad();
        Pages.dashboardPage().selectSearchCriteria("Creation Date");
        Pages.dashboardPage().selectSearchCriteriaType("is before");
        Pages.dashboardPage().clickSearchButton();
        Assert.assertTrue(Pages.dashboardPage().isOrdersPresent(), "Orders list is empty!");
    }


    public void createContract(ContractData contractData){
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();
        Pages.leftMenu().clickCreateContractButton();
        wait(120);
        ContractPages.searchCreateContractPage().waitForPageLoad();
        ContractPages.searchCreateContractPage().selectPartner(contractData.getCustomerData().getCompanyName());
        ContractPages.searchCreateContractPage().selectProduct(contractData.getProductData().getProductName(),
                contractData.getProductData().getProductUniqueId());
        if(isNotNull(contractData.getStartMonth())) {
            ContractPages.searchCreateContractPage().selectFirstMonthDay(contractData.getStartMonth());
        } else ContractPages.searchCreateContractPage().selectRandomDate();

        ContractPages.searchCreateContractPage().clickSearchButton();
        ContractPages.searchCreateContractPage().highlightDiscountScale();
        ContractPages.searchCreateContractPage().clickCreateContractButton();
        ContractPages.searchCreateContractPage().typeAssignmentName(contractData.getAssignmentName());
        ContractPages.searchCreateContractPage().selectDiscountScaleLevel(contractData.getDiscountLevel());
        ContractPages.searchCreateContractPage().clickSaveContractButton();
        Assert.assertTrue(ContractPages.searchCreateContractPage().isContractStatusDraft(),
                "Contract did not obtain status draft");
    }

    public void createApproveContract(ContractData contractData){
        createContract(contractData);
        ContractPages.searchCreateContractPage().clickApproveButton();
    }


}
