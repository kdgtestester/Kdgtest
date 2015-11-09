package com.mediaspectrum.actions;


import com.mediaspectrum.control.*;
import com.mediaspectrum.utils.*;
import com.testmatick.base.BaseActions;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class AdvancedBookingActions extends BaseActions {

    public void addProductToShoppingCart(ProductData productData){

        PartnersPages.scheduleAdvancedTab().waitForPageToLoad();
        PartnersPages.scheduleAdvancedTab().searchSelectProduct(productData.getProductName(false), productData.getProductUniqueId());

        //enter main product data
        setProductData(productData);

        //enter subproducts data
        if(!productData.getSubProducts().isEmpty()){
            for(ProductData product : productData.getSubProducts()){
                setProductData(product);
            }
        }

        PartnersPages.scheduleAdvancedTab().clickAddToOrderButton();
        PartnersPages.orderInformationTab().waitProductAddToShoppingCart(productData.getProductName());

        Assert.assertTrue(PartnersPages.orderInformationTab().isProductInShoppingCart(productData.getProductName()),
                "Product did not add to shopping cart");

        if(isNotNull(productData.getProductPrescriptionGroup())) setPrescription(productData);

        if(!productData.getSubProducts().isEmpty()){
            for(ProductData product : productData.getSubProducts()){
                if(isNotNull(product.getProductPrescriptionGroup())) setPrescription(product);
            }
        }
    }

    public void setProductData(ProductData productData){

        wait(10);
        PartnersPages.scheduleAdvancedTab().checkProductRadioButton(productData.getProductUniqueId());

        if(isNotNull(productData.getProductAdType()))
            PartnersPages.scheduleAdvancedTab().selectProductType(productData.getProductAdType());

        if(isNotNull(productData.getProductHeading()))
            PartnersPages.scheduleAdvancedTab().selectProductHeading(productData.getProductHeading());

        if(isNotNull(productData.getProductSubHeading()))
            PartnersPages.scheduleAdvancedTab().selectProductSubHeading(productData.getProductSubHeading());

        if(isNotNull(productData.getProductTextBorder()))
            PartnersPages.scheduleAdvancedTab().selectProductTextBorder(productData.getProductTextBorder());

        if(isNotNull(productData.getProductCompositePosition()))
            PartnersPages.scheduleAdvancedTab().selectProductCompositePosition(productData.getProductCompositePosition());

        if(isNotNull(productData.getProductAdStructure()))
            PartnersPages.scheduleAdvancedTab().selectProductAdStructure(productData.getProductAdStructure());

        if(isNotNull(productData.getProductRateType()))
            PartnersPages.scheduleAdvancedTab().selectProductRateType(productData.getProductRateType());

        if(isNotNull(productData.getProductColor()))
            PartnersPages.scheduleAdvancedTab().selectProductColor(productData.getProductColor());

        if(isNotNull(productData.getProductBleed()))
            PartnersPages.scheduleAdvancedTab().selectProductBleed(productData.getProductBleed());

        if(isNotNull(productData.getProductClientType()))
            PartnersPages.scheduleAdvancedTab().selectProductClientType(productData.getProductClientType());

        if(isNotNull(productData.getProductSize())){
            PartnersPages.scheduleAdvancedTab().selectProductSize(productData.getProductSize());
            if(PartnersPages.scheduleAdvancedTab().isPopupVisible()) PartnersPages.scheduleAdvancedTab().confirmPopup();
        }

        if(isNotNull(productData.getProductSizeHeight()))
            PartnersPages.scheduleAdvancedTab().typeProductSizeHeight(productData.getProductSizeHeight());

        if(isNotNull(productData.getProductSizeLinesCount()))
            PartnersPages.scheduleAdvancedTab().typeProductSizeLines(productData.getProductSizeLinesCount());

        if(isNotNull(productData.getProductPrescriptionSize()))
            PartnersPages.scheduleAdvancedTab().selectProductPrescriptionSize(productData.getProductPrescriptionSize());

        if(!productData.getProductDates().isEmpty())
            PartnersPages.scheduleAdvancedTab().setDates(productData.getProductDates());

        if(productData.isOnlineProduct())
            PartnersPages.scheduleAdvancedTab().selectRandomOnlineDate();

        if(productData.getProductDatesCount()>0)
            PartnersPages.scheduleAdvancedTab().selectDatesRandomly(productData.getProductDatesCount());

        if(isNotNull(productData.isReservationOnly()))
            PartnersPages.scheduleAdvancedTab().setReservationOnlyCheckboxState(productData.isReservationOnly());

        if(isNotNull(productData.isSpecialRequest())) {
            PartnersPages.scheduleAdvancedTab().setSpecialRequestCheckboxState(productData.isSpecialRequest());
            if(productData.isSpecialRequest())
                PartnersPages.scheduleAdvancedTab().typeSpecialRequestDescription(productData.getSpecialRequestDescription());
        }

        if(isNotNull(productData.getProductContentType())) {
            PartnersPages.scheduleAdvancedTab().selectProductContentType(productData.getProductContentType());

            if(isNotNull(productData.getProductContentDescription()))
                PartnersPages.scheduleAdvancedTab().typeProductContentDescription(productData.getProductContentDescription());

            if(isNotNull(productData.getProductContentLanguage()))
                PartnersPages.scheduleAdvancedTab().selectProductContentLanguage(productData.getProductContentLanguage());
        }

        if(isNotNull(productData.getUiEditorData()))
            setUiEditorData(productData.getUiEditorData());
    }

    public void setOrderData(OrderInformationData orderInformationData) {

        if(isNotNull(orderInformationData.getOrderPaymentMethod()))
            PartnersPages.orderInformationTab().selectPaymentMethod(orderInformationData.getOrderPaymentMethod());

        if(isNotNull(orderInformationData.getOrderAgency()))
            PartnersPages.orderInformationTab().selectPrimatyAgency(orderInformationData.getOrderAgency());

        if(isNotNull(orderInformationData.getOrderInternalProvenance()))
            PartnersPages.orderInformationTab().selectInternalProvenance(orderInformationData.getOrderInternalProvenance());

    }

    public void doOrder(AdvancedOrderData advancedOrderData) {

        if(isNotNull(advancedOrderData.getCustomerData())){
            //todo implements creating and search customer
        }


        for(ProductData product : advancedOrderData.getProducts()) {
            addProductToShoppingCart(product);
        }

        setOrderData(advancedOrderData.getOrderInformationData());

        PartnersPages.orderInformationTab().clickSaveOrderButton();

        PartnersPages.orderInformationTab().assertTotalPricePresent();

        advancedOrderData.setOrderID(PartnersPages.orderInformationTab().getOrderID());

        if(isNotNull(advancedOrderData.getRatesData())) {
            changeRate(advancedOrderData.getRatesData());

            for(ProductData product : advancedOrderData.getProducts()){

                for(String value : PartnersPages.priceManagementTab().getBaseChargeValues(product.getProductName())){
                    Assert.assertEquals(Double.valueOf(value.replaceAll("[^\\d.]", "")),
                            Double.valueOf(advancedOrderData.getRatesData().getRateAmount()),
                            "Incorrect total gross");
                }
            }

            PartnersPages.priceManagementTab().clickOrderInformationTab();
        }

        if(isNotNull(advancedOrderData.getSurchargesData())){
            addSurcharges(advancedOrderData.getSurchargesData());

            for(ProductData product : advancedOrderData.getProducts()){
                Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargesPresentInOrder(advancedOrderData.
                                getSurchargesData().getSurchargeName(),product.getProductName()),
                        String.format("Surcharge %s is not present order info for %s product",
                                advancedOrderData.getSurchargesData().getSurchargeName(), product.getProductName()));

            }
            PartnersPages.priceManagementTab().clickOrderInformationTab();
        }

        Assert.assertFalse(PartnersPages.orderInformationTab().isErrorsPresent(),
                "Shopping cart contains errors");

        PartnersPages.orderInformationTab().clickPlaceOrderButton();

        Pages.ordersPage().waitForPageLoad();
        Assert.assertTrue(Pages.ordersPage().isOrderWithIdPresent(advancedOrderData.getOrderID()));

    }

    public void setUiEditorData(UiEditorData uiEditorData){

        PartnersPages.scheduleAdvancedTab().clickUieditorButton();
        UiEditorPages.onlineContentPage().switchToUIEditorFrame();

        if(isNotNull(uiEditorData.getContentLanguage()))
            UiEditorPages.onlineContentPage().selectContentLanguage(uiEditorData.getContentLanguage());

        if(isNotNull(uiEditorData.getContentOperation()))
            UiEditorPages.onlineContentPage().selectContentOperation(uiEditorData.getContentOperation());

        if(isNotNull(uiEditorData.getContentJobTitle()))
            UiEditorPages.onlineContentPage().typeJobTitle(uiEditorData.getContentJobTitle());

        if(isNotNull(uiEditorData.getContentJobDescription()))
            UiEditorPages.onlineContentPage().typeJobDescription(uiEditorData.getContentJobDescription());

        if(isNotNull(uiEditorData.getContentAddress())) {
            UiEditorPages.onlineContentPage().selectCountry(uiEditorData.getContentAddress().getCountry());
            UiEditorPages.onlineContentPage().typeStreet(uiEditorData.getContentAddress().getStreet());
            UiEditorPages.onlineContentPage().typeStreetNumber(uiEditorData.getContentAddress().getStreetNumber());
            UiEditorPages.onlineContentPage().typeZip(uiEditorData.getContentAddress().getZip());
            UiEditorPages.onlineContentPage().typeCity(uiEditorData.getContentAddress().getCity());
        }

        UiEditorPages.onlineContentPage().clickNextButton();
        UiEditorPages.filesPage().waitForPageLoad();
        //add actions if needed in future tests
        UiEditorPages.filesPage().clickNextButton();
        UiEditorPages.contractPage().waitForPageLoad();
        //add actions if needed in future tests
        UiEditorPages.contractPage().clickNextButton();
        UiEditorPages.mediaCriteriaPage().waitForPageLoad();

        if(isNotNull(uiEditorData.getMediaCategory()))
            UiEditorPages.mediaCriteriaPage().selectCategory(uiEditorData.getMediaCategory());

        if(isNotNull(uiEditorData.getMediaSubCategory()))
            UiEditorPages.mediaCriteriaPage().selectSubCategory(uiEditorData.getMediaSubCategory());

        UiEditorPages.mediaCriteriaPage().clickSaveButtonAanSwitchToMainFrame();
    }

    public void changeRate(RatesData ratesData){
        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();

        PartnersPages.priceManagementTab().clickRateButton();
        if(ratesData.isSelectAllProducts()) PartnersPages.priceManagementTab().selectAllProducts();

        PartnersPages.priceManagementTab().typeRate(ratesData.getRateAmount());
        PartnersPages.priceManagementTab().selectChangingRateReason(ratesData.getChangingRateReason());
        PartnersPages.priceManagementTab().selectChangingRateDetails(ratesData.getChangingRateDetails());

        PartnersPages.priceManagementTab().clickSaveChangesButton();

        for(String color : PartnersPages.priceManagementTab().getForcedRateColor()){
            Assert.assertEquals("rgba(255, 192, 203, 1)", color, "Forced rate obtained incorrect color");
        }

        for(String value : PartnersPages.priceManagementTab().getForcedRateValues()){
            Assert.assertEquals(ratesData.getRateAmount(), value,
                    "Incorrect force rate");
        }

        PartnersPages.priceManagementTab().clickCloseChangeRateDialog();
    }

    public void addSurcharges(SurchargesData surchargesData){
        List<SurchargesData> surcharge = new LinkedList<>();
        surcharge.add(surchargesData);
        addSurcharges(surcharge);
    }

    public void addSurcharges(List<SurchargesData> surchargesData){

        PartnersPages.orderInformationTab().clickPriceManagmentTab();
        PartnersPages.priceManagementTab().waitPageToLoad();
        PartnersPages.priceManagementTab().clickSurchargeButton();

        Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargesListSorted(),
                "Surcharges displays in not alphabetic order");

        for(SurchargesData surcharge : surchargesData) {

            PartnersPages.priceManagementTab().appliySurcharge(surcharge.getSurchargeName());

            Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargeApplied(surcharge.getSurchargeName()),
                    "Surcharge is not applied");

            if (isNotNull(surcharge.getRatesData())) {

                PartnersPages.priceManagementTab().clickAppliedSurcharge(surcharge.getSurchargeName());

                PartnersPages.priceManagementTab().clickSelectAllProductsForSurcharge();

                if (isNotNull(surcharge.getRatesData().getRateAmount()))
                    PartnersPages.priceManagementTab().typeRate(surcharge.getRatesData().getRateAmount());

                PartnersPages.priceManagementTab().setCalculationCheckboxState(surcharge.isCalculationEnable());

                if (isNotNull(surcharge.getRatesData().getRateItem())) {
                    Assert.assertTrue(PartnersPages.priceManagementTab().isRateTypesCorrect(),
                            "Rate types list is incorrect");
                    PartnersPages.priceManagementTab().selectRateType(surcharge.getRatesData().getRateItem());
                }
                if(!PartnersPages.priceManagementTab().IsSaveSurchargesChangesButtonEnabled()) {

                    if (isNotNull(surcharge.getRatesData().getChangingRateReason()))
                        PartnersPages.priceManagementTab().selectSurchargeReason(surcharge.getRatesData().getChangingRateReason());

                    if (isNotNull(surcharge.getRatesData().getChangingRateDetails()))
                        PartnersPages.priceManagementTab().selectSurchargeDetails(surcharge.getRatesData().getChangingRateDetails());
                }
            }

            PartnersPages.priceManagementTab().clickSaveSurchargeSettingsButton();
        }

        PartnersPages.priceManagementTab().clickCloseSurchargeDialogButton();
    }


    public void setPrescription(ProductData productData){

        PartnersPages.orderInformationTab().clickPrescriptionButton();

        PartnersPages.orderInformationTab().checkProductCheckbox(productData.getProductName());
        PartnersPages.orderInformationTab().selectPrescriptionGroup(productData.getProductPrescriptionGroup());
        PartnersPages.orderInformationTab().selectPrescription(productData.getProductPrescription());
        PartnersPages.orderInformationTab().clickAddPrescriptionButton();


        Assert.assertTrue(PartnersPages.orderInformationTab().isPrescriptionAdded(productData),
                "Prescription is not added");

        PartnersPages.orderInformationTab().clickClosePrescriptionsDialogButtons();
    }

    public void splitShoppingCartProductByContent(ProductData productData){
        PartnersPages.orderInformationTab().clickExpandOrderInfoButton(productData.getProductName());
        PartnersPages.orderInformationTab().checkFirstDateCheckbox();
        PartnersPages.orderInformationTab().moveMouseToProductName(productData.getProductName());
        PartnersPages.orderInformationTab().clickSplitWithContentButton();
    }

    public String invoiceOrder(AdvancedOrderData advancedOrderData){

        Pages.topMenu().clickBillingLink();
        Pages.transactionsTab().waitPageToLoad();

        if(isNotNull(advancedOrderData.getCustomerData().getCustomerID()))
            Pages.transactionsTab().typePartnerID(advancedOrderData.getCustomerData().getCustomerID());

        Pages.transactionsTab().typeOrderID(advancedOrderData.getOrderID());

        Pages.transactionsTab().clickSearchButton();

        if(!Pages.transactionsTab().isOrderFound(advancedOrderData.getOrderID())) Pages.transactionsTab().clickSearchButton();
        Assert.assertTrue(Pages.transactionsTab().isOrderFound(advancedOrderData.getOrderID()),
                "Order is not found");

        Pages.transactionsTab().expandOrderData(advancedOrderData.getOrderID());
        Pages.transactionsTab().clickSelectAllCheckbox(advancedOrderData.getOrderID());
        Pages.transactionsTab().clickInvoiceNowButton();

        checkInvoiceGenerated(advancedOrderData);

        Pages.invoicesTab().waitForInvoiceNumber();
        return Pages.invoicesTab().getInvoiceNumber();
    }

    public void checkInvoiceGenerated(AdvancedOrderData  advancedOrderData){

        Pages.transactionsTab().clickInvoicesTab();
        if(isNotNull(advancedOrderData.getCustomerData().getCustomerID()))
            Pages.invoicesTab().typePartnerID(advancedOrderData.getCustomerData().getCustomerID());

        Pages.invoicesTab().typeOrderID(advancedOrderData.getOrderID());
        Pages.invoicesTab().clickSearchButton();

        for(String invoiceStatus : Pages.invoicesTab().getInvoicesStatuses(advancedOrderData.getCustomerData().getCustomerID())){
            Assert.assertTrue("Pending-Accounting Pending-Printing Completed".contains(invoiceStatus),
                    "Incorrect invoice status");
        }
    }

    public void openOrderForEditing(String orderID){
        Actions.mainPageActions().assertOdrerPresentInDashboard(orderID);
        Pages.dashboardPage().clickOrderById(orderID);
        Pages.dashboardPage().waitOrderInvoiced();
        Pages.dashboardPage().clickEditOrderButton();
    }


    public void editSurcharge(SurchargesData surchargeData){

        PartnersPages.priceManagementTab().clickSurchargeButton();
        Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargesListSorted(),
                "Surcharges displays in not alphabetic order");

        Assert.assertTrue(PartnersPages.priceManagementTab().isSurchargeApplied(surchargeData.getSurchargeName()),
                "Surcharge is not applied");

        PartnersPages.priceManagementTab().clickAppliedSurcharge(surchargeData.getSurchargeName());
        PartnersPages.priceManagementTab().clickSelectAllProductsForSurcharge();

        if (isNotNull(surchargeData.getRatesData().getRateAmount()))
            PartnersPages.priceManagementTab().typeRate(surchargeData.getRatesData().getRateAmount());

        PartnersPages.priceManagementTab().setCalculationCheckboxState(surchargeData.isCalculationEnable());

        if (isNotNull(surchargeData.getRatesData().getRateItem())) {
            Assert.assertTrue(PartnersPages.priceManagementTab().isRateTypesCorrect(),
                    "Rate types list is incorrect");
            PartnersPages.priceManagementTab().selectRateType(surchargeData.getRatesData().getRateItem());
        }

        if (isNotNull(surchargeData.getRatesData().getChangingRateReason()))
            PartnersPages.priceManagementTab().selectSurchargeReason(surchargeData.getRatesData().getChangingRateReason());

        if (isNotNull(surchargeData.getRatesData().getChangingRateDetails()))
            PartnersPages.priceManagementTab().selectSurchargeDetails(surchargeData.getRatesData().getChangingRateDetails());

        PartnersPages.priceManagementTab().clickSaveSurchargeSettingsButton();
        PartnersPages.priceManagementTab().clickCloseSurchargeDialogButton();
    }

    public void searchOrderOnApprovals(String orderNumber){
        Pages.topMenu().clickApprovalsLink();
        Pages.approvalsPage().waitPageToLoad();
        Pages.approvalsPage().setOrderNumber(orderNumber);
        Pages.approvalsPage().clickSearchButton();
    }

    public void rejectOrder(String reason, String detail){
        Pages.approvalsPage().clickOrderApprovalsTab();
        Pages.approvalsPage().changeCreditCheckboxState(true);
        Pages.approvalsPage().clickRejectButton();
        Pages.approvalsPage().selectRejectReason(reason);
        Pages.approvalsPage().typeDetails(detail);
        Pages.approvalsPage().confirmReject();
    }

    public void approveOrder(){
        Pages.approvalsPage().clickOrderApprovalsTab();
        Pages.approvalsPage().changeCreditCheckboxState(true);
        Pages.approvalsPage().clickApproveButton();
    }

    public void searchContract(String partnerCompanyName){
        Pages.topMenu().clickContractsLink();
        ContractPages.searchContractPage().waitForPageToLoad();
        ContractPages.searchContractPage().selectPartner(partnerCompanyName);
        ContractPages.searchContractPage().clickSearchButton();
        ContractPages.searchContractPage().waitForSearchResults(partnerCompanyName);
    }

    public void waitContractAdjustmentApplies(ContractData contractData){
        for(int i = 0; i < 10; i++){
            if(!ContractPages.manageContractPage().getAppliedDiscountValue().contains(contractData.getDiscountLevel())){
                wait(30);
                ContractPages.manageContractPage().refreshPage();
            } else break;
        }

        Assert.assertTrue(ContractPages.manageContractPage().getAppliedDiscountValue().contains(contractData.getDiscountLevel()),
                "Contract adjustment is not applied after 5 minutes timeout");
    }

    public void addContractAdjustment(ContractData contractData){

        searchContract(contractData.getCustomerData().getCompanyName());

        Assert.assertTrue(ContractPages.searchContractPage().isContractFound(contractData.getCustomerData().getCompanyName()));
        ContractPages.searchContractPage().clickContractLink(contractData.getCustomerData().getCompanyName());

        ContractPages.manageContractPage().waitForPageToLoad();

        Assert.assertFalse(ContractPages.manageContractPage().getPrintedInsertionOrderId().isEmpty(),
                "Contract has no insertions");

        ContractPages.manageContractPage().clickRunAdjustmentCheckbox();
        ContractPages.manageContractPage().setGenerateCorrectivesCheckboxState(true);

        if(!contractData.isAdjustmentTypeFinal()) ContractPages.manageContractPage().clickIntermediateAdjustment();
        ContractPages.manageContractPage().selecrDiscountLevel(contractData.getDiscountLevel());

        ContractPages.manageContractPage().selectDefaultAdjustmentDate();
        ContractPages.manageContractPage().typeAdjustmentNotes(contractData.getCustomerData().getCompanyName());

        ContractPages.manageContractPage().clickSaveChangesButton();

        waitContractAdjustmentApplies(contractData);
    }

    public void waitAdjustmentHistoryUpdated() {
        long startTime = System.currentTimeMillis();
        while (!ContractPages.manageContractPage().isDownloadLinkVisible() && (System.currentTimeMillis() - startTime) < 600 * 1000) {
            wait(20);
            ContractPages.manageContractPage().refreshPage();
            ContractPages.manageContractPage().clickAdjustmentHistoryTab();
        }
    }
}
