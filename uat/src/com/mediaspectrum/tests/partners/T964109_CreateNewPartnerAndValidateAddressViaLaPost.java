package com.mediaspectrum.tests.partners;


import com.mediaspectrum.control.Actions;
import com.mediaspectrum.control.PartnersPages;
import com.mediaspectrum.utils.Address;
import com.mediaspectrum.utils.CustomerData;
import com.mediaspectrum.utils.CustomerType;
import com.mediaspectrum.utils.PhoneData;
import com.testmatick.base.BaseTest;
import com.testmatick.utils.Constants;
import com.testmatick.utils.DataFactory;
import com.testmatick.utils.Random;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Create new partner - Validate a valid address with "La Poste"
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964109
 */

public class T964109_CreateNewPartnerAndValidateAddressViaLaPost extends BaseTest{

    CustomerData customerData;

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @DataProvider
    public Object[][] juniorLoginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "juniorLogin");
    }

    @DataProvider
    public Object[][] seniorLoginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "seniorLogin");
    }


    @Test(dataProvider = "loginData")
    public void loginTest(String login, String password) {
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createPartnerCheck(){
        Address customerAddress = new Address();
        customerAddress.setCity("Martigny");
        customerAddress.setCountry("Schweiz");
        customerAddress.setStreet("avenue de Fully");
        customerAddress.setStreetNumber("25");
        customerAddress.setZip("1920");
        customerAddress.setPhone(new PhoneData("Office", Random.genInt(1000000, 9999999) + "", 380));

        customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
        customerData.setCompanyAddress(customerAddress);
        customerData.setValidateAddress(true);

        Actions.partnerActions().createCustomer(customerData);
        Actions.loginActions().logout();

    }

    @Test(dataProvider = "seniorLoginData", dependsOnMethods = "createPartnerCheck")
    public void changeAddressAsSeniorUserTest(String login, String password){
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
        Actions.partnerActions().openPartnerPageByID(customerData.getCustomerID());

        String beforeChanging = PartnersPages.createPartnerPage().getPartnerStreet();
        PartnersPages.createPartnerPage().typeStreet(beforeChanging + "changed");
        Assert.assertNotEquals(beforeChanging, PartnersPages.createPartnerPage().getPartnerStreet(),
                "Partner address din not change");

        Actions.loginActions().logout();
    }

    @Test(dataProvider = "juniorLoginData", dependsOnMethods = "changeAddressAsSeniorUserTest")
    public void changeAddressAsJuniorUserTest(String login, String password){
        Actions.loginActions().doLogin(login, password, Constants.DEFAULT_SYSTEM_LANGUAGE);
        Actions.partnerActions().openPartnerPageByID(customerData.getCustomerID());

        Assert.assertFalse(PartnersPages.createPartnerPage().isStreetFieldVisible(),
                "User can see street input field");

    }


}
