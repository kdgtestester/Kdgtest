package com.mediaspectrum.actions;

import com.mediaspectrum.control.Pages;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.pages.partners.PartnersPage;
import com.mediaspectrum.utils.Address;
import com.mediaspectrum.utils.CustomerData;
import com.qatestlab.base.BaseActions;
import com.qatestlab.utils.Random;
import org.testng.Assert;

public class PartnerActions extends BaseActions {

    public void searchPartnerByName(String companyName) {
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();
        PartnersPages.partnersPage().typeCompanyName(companyName);
        PartnersPages.partnersPage().clickSearchButton();
    }

    public void searchPartnerByID(String partnerID) {
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();
        PartnersPages.partnersPage().typePartnerID(partnerID);
        PartnersPages.partnersPage().clickSearchButton();
    }

    public void searchCustomer(CustomerData customerData){
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();

        if(isNotNull(customerData.getPartnerProfitCenter()))
            PartnersPages.partnersPage().selectProfitCenter(customerData.getPartnerProfitCenter());

        if(isNotNull(customerData.getCompanyName()))
            PartnersPages.partnersPage().typeCompanyName(customerData.getCompanyName());

        if(isNotNull(customerData.getCustomerID()))
            PartnersPages.partnersPage().typePartnerID(customerData.getCustomerID());

        PartnersPages.partnersPage().clickSearchButton();
    }

    public void openAdvancedBooking(String companyName) {
//        if (!PartnersPages.partnersPage().isPartnerItemExpanded(companyName))
//            PartnersPages.partnersPage().expandPartnerItem(companyName);
        PartnersPages.partnersPage().clickAdvancedBookingLink();
        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
    }

    public void openPartnerPageByID(String partnerID){
        searchPartnerByID(partnerID);
        PartnersPages.partnersPage().clickPartnerLink(partnerID);
        wait(120);
        PartnersPages.createPartnerPage().waitCreatedCustomerPageToLoad();
    }

    public void createCustomer(CustomerData customerData) {
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();
        Pages.leftMenu().clickCreatePartnerButton();
        PartnersPages.partnersPage().waitForPageToLoad();
        PartnersPages.partnersPage().clickCreatePartnerButton();
        wait(120);
        PartnersPages.createPartnerPage().waitForPageToLoad();

        Assert.assertTrue(PartnersPages.createPartnerPage().isPartnersTypesListCorrect(),
                "Partner types list contains incorrect data");

        PartnersPages.createPartnerPage().selectCustomerType(customerData.getCustomerType());

        Assert.assertTrue(PartnersPages.createPartnerPage().isPartnerIDEmpty(),
                "Field partner id is not empty");

        Assert.assertTrue(PartnersPages.createPartnerPage().isCompanyHRInformationEmpty(),
                "Field company HR information is not empty");

        Assert.assertTrue(PartnersPages.createPartnerPage().isCompanyFoundingYearEmpty(),
                "Field company foundation year is not empty");

        setAddressData(customerData.getCompanyName(), customerData.getCompanyAddress());

//        if(customerData.isValidateAddress()) {
//            PartnersPages.createPartnerPage().clickLaPostValidationButton();
//
//            Assert.assertFalse(PartnersPages.createPartnerPage().isErrorsPresent(),
//                    "Address validation is not successful!");
//        }

        if(isNotNull(customerData.getSubAddresses())){

            for(Address address : customerData.getSubAddresses()) {
                PartnersPages.createPartnerPage().clickAddAddressFormButton();
                setAddressData(customerData.getCompanyName(), address);
            }
        }

        PartnersPages.createPartnerPage().clickMarketingDataTab();
        PartnersPages.createPartnerPage().selectMarketingBranch(customerData.getCompanyMarketingBrunch());
        PartnersPages.createPartnerPage().selectMarketingSegment(customerData.getCompanyMarketingSegment());
        PartnersPages.createPartnerPage().selectMarketingClassification(customerData.getCompanyMarketingClassification());

        PartnersPages.createPartnerPage().clickSpecificInfoTab();
        PartnersPages.createPartnerPage().selectProfitCenter(customerData.getPartnerProfitCenter());

        if(isNotNull(customerData.getPartnerAgency()))
            PartnersPages.createPartnerPage().selectAgency(customerData.getPartnerAgency());

        PartnersPages.createPartnerPage().clickGeneralInfoTab();
        Assert.assertTrue(PartnersPages.createPartnerPage().isMWSTRulesListCorrect(),
                "MWST Rules list contains incorrect items!");

        PartnersPages.createPartnerPage().clickFinancialDataTab();

        if(isNotNull(customerData.isCreditBlocked()))
        {
            PartnersPages.createPartnerPage().setCreditBlockedCheckboxState(customerData.isCreditBlocked());
        }

        if(isNotNull(customerData.getCreditLimit())){
            PartnersPages.createPartnerPage().typeCreditLimit(customerData.getCreditLimit());
        }

        PartnersPages.createPartnerPage().clickSaveCustomerButton();
        customerData.setCustomerID(PartnersPages.createPartnerPage().getCustomerID());
    }

    public void sendPartnerModificationRequest(String partnerID, String modificationRequestType){
        openPartnerPageByID(partnerID);
        PartnersPages.createPartnerPage().clickAddPartnerModificationRequestLink();
        PartnersPages.createPartnerPage().selectModificationRequestType(modificationRequestType);
        PartnersPages.createPartnerPage().typeRequestDescription(Random.genString(10));

        PartnersPages.createPartnerPage().clickSaveCustomerButton();
        PartnersPages.createPartnerPage().waitModificationRequestItem(modificationRequestType);

        Assert.assertTrue(PartnersPages.createPartnerPage().isRequestInProcessingState(modificationRequestType),
                "Modification request is not in processing state.");

        Assert.assertEquals(PartnersPages.createPartnerPage().getCustomerStatus(), "Partner Approval Request",
                "Customer status in not in approval request.");
    }

    public void approveModificationRequest(String partnerID, String modificationRequestType){
        approveModificationRequest(partnerID, modificationRequestType, "Approve as Requested");
    }

    public void approveModificationRequest(String partnerID, String modificationRequestType, String approveAs){
        openPartnerPageByID(partnerID);
        PartnersPages.createPartnerPage().processRequest(modificationRequestType, approveAs);
        PartnersPages.createPartnerPage().clickSaveCustomerButton();

        Assert.assertEquals(PartnersPages.createPartnerPage().getCustomerStatus(), "Live",
                "Customer status in not live.");

    }

    public void setAddressData(String companyName, Address address){

        if(isNotNull(address.getAddressType()))
            PartnersPages.createPartnerPage().selectAddressType(address.getAddressType());

        PartnersPages.createPartnerPage().typeCompanyName(companyName);
        PartnersPages.createPartnerPage().selectCountry(address.getCountry());

        if(isNotNull(address.getRegion()))
            PartnersPages.createPartnerPage().typeRegion(address.getRegion());

        PartnersPages.createPartnerPage().typeStreet(address.getStreet());
        PartnersPages.createPartnerPage().typeStreetNumber(address.getStreetNumber());
        PartnersPages.createPartnerPage().typeZip(address.getZip());
        PartnersPages.createPartnerPage().typeCity(address.getCity());

        PartnersPages.createPartnerPage().selectPhoneType(address.getPhone().getPhoneType());
        PartnersPages.createPartnerPage().typePhoneNumber(address.getPhone().getPhoneNumber());


    }
}
