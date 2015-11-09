package com.mediaspectrum.tests.contracts;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.ContractPages;
import com.mediaspectrum.control.Pages;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.Random;
import com.testmatick.utils.SerializeHelper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: "Create Contract" page for SENIOR user
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964741
 */


public class T964741_CreateContractPageForSeniorUser extends BaseTest{

    CustomerData customerData;

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "seniorLogin");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String login, String password){
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
    }

    @Test(dependsOnMethods = "testLogin")
    public void openContractsTest(){
        Pages.topMenu().clickPartnersLink();
        PartnersPages.partnersPage().waitForPageToLoad();
        Pages.leftMenu().clickCreateContractButton();
        ContractPages.searchCreateContractPage().waitForPageLoad();
    }

    @Test(dependsOnMethods = "openContractsTest")
    public void searchDiscountScaleTest(){

       customerData = SerializeHelper.deserializeObject(CustomerData.class, Constants.CUSTOMER_SERIALIZE_FILENAME);

        if(customerData == null){
            customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        ContractPages.searchCreateContractPage().selectPartner(customerData.getCompanyName());
        ContractPages.searchCreateContractPage().selectProduct("Le Matin", "2200");
        ContractPages.searchCreateContractPage().selectRandomDate();
        ContractPages.searchCreateContractPage().clickSearchButton();
        ContractPages.searchCreateContractPage().highlightDiscountScale();
        ContractPages.searchCreateContractPage().clickCreateContractButton();
    }

    @Test(dependsOnMethods = "searchDiscountScaleTest")
    public void saveContractWithEmptyFieldsTest(){
        ContractPages.searchCreateContractPage().clearPartnerField();
        ContractPages.searchCreateContractPage().clickSaveContractButton();
        Assert.assertTrue(ContractPages.searchCreateContractPage().isErrorsPresent(),
                "Contract saved with incorrect data");
    }

    @Test(dependsOnMethods = "saveContractWithEmptyFieldsTest")
    public void fillCorrectContractDataTest(){
        ContractPages.searchCreateContractPage().typeAssignmentName("Test"+ Random.genRandNumberByTime());
        ContractPages.searchCreateContractPage().selectPartner(customerData.getCompanyName());
        ContractPages.searchCreateContractPage().selectDiscountScaleLevel("5.0 %");

    }

    @Test(dependsOnMethods = "fillCorrectContractDataTest")
    public void nodesAvailabilityTest() {
        ContractPages.searchCreateContractPage().typeNotes("Test");
    }


    @Test(dependsOnMethods = "nodesAvailabilityTest")
    public void holdingInformationFormTest(){
        Assert.assertTrue(ContractPages.searchCreateContractPage().isHoldingContractCheckboxVisible(),
                "Holding contract checkbox is not visible");
        Assert.assertTrue(ContractPages.searchCreateContractPage().isFollowHoldingRulesCheckboxVisible(),
                "Follow holdingRules checkbox is not visible");
        ContractPages.searchCreateContractPage().clickHoldingInformationHeader();
        Assert.assertFalse(ContractPages.searchCreateContractPage().isHoldingContractCheckboxVisible(),
                "Holding contract checkbox is visible");
        Assert.assertFalse(ContractPages.searchCreateContractPage().isFollowHoldingRulesCheckboxVisible(),
                "Follow holdingRules checkbox is visible");
    }

    @Test(dependsOnMethods = "holdingInformationFormTest")
    public void finalAdjustmentTest(){
        Assert.assertTrue(ContractPages.searchCreateContractPage().isStandardFinalAdjustmentCheckboxVisible(),
                "Standard final adjustment checkbox is not visible");
        Assert.assertTrue(ContractPages.searchCreateContractPage().isWithCorrectivesCheckboxVisible(),
                "With correctives checkbox is not visible");
        ContractPages.searchCreateContractPage().clickFinalAdjustmentHeader();
        Assert.assertFalse(ContractPages.searchCreateContractPage().isStandardFinalAdjustmentCheckboxVisible(),
                "Standard final adjustment checkbox is visible");
        Assert.assertFalse(ContractPages.searchCreateContractPage().isWithCorrectivesCheckboxVisible(),
                "With correctives checkbox is visible");

        ContractPages.searchCreateContractPage().clickFinalAdjustmentHeader();

        Assert.assertFalse(ContractPages.searchCreateContractPage().isWithCorrectivesCheckboxEnable(),
                "With correctives checkbox enable");

        ContractPages.searchCreateContractPage().setStandardFinalAdjustmentCheckboxState(true);
        Assert.assertTrue(ContractPages.searchCreateContractPage().isWithCorrectivesCheckboxEnable(),
                "With correctives checkbox enable");
    }

    @Test(dependsOnMethods = "finalAdjustmentTest")
    public void saveContractTest() {
        ContractPages.searchCreateContractPage().clickSaveContractButton();
        Assert.assertTrue(ContractPages.searchCreateContractPage().isContractStatusDraft(),
                "Contract did not obtain status draft");


    }
}
