package com.mediaspectrum.tests.login;

import com.mediaspectrum.control.Actions;
import com.mediaspectrum.utils.*;
import com.qatestlab.base.BaseTest;
import com.qatestlab.utils.Constants;
import com.qatestlab.utils.DataFactory;
import com.qatestlab.utils.Random;
import com.qatestlab.utils.SerializeHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kostia Zavgorodniy
 * Email: konstantin.zavgorodniy@testmatick.com
 * Test Name: Login - Create "Standard" ("junior") account on Webadmin and verify it
 * Test Case: https://mediaspectrum.testrail.net/index.php?/tests/view/964939
 */

import java.io.File;

public class T964939_CreateCentralTeamJuniourAccountOnWebadminAndVerifyIt extends BaseTest{

    UserData userData;

    @DataProvider
    public Object[][] loginData() throws Exception {
        return super.getTableArray(System.getProperties().getProperty("config.dir")	+ File.separatorChar + "data"
                + File.separatorChar + "DataPool.xls", "LoginData", "loginData1");
    }

    @Test(dataProvider = "loginData")
    public void webAdminLoginTest(String login, String password){
        Actions.webAdminActions().goLogin(login, password);
    }

    @Test(dependsOnMethods = "webAdminLoginTest")
    public void createUserTest(){
        userData = DataFactory.generateJuniorUserData();
        Actions.webAdminActions().createUser(userData);
    }

    @Test(dependsOnMethods = "createUserTest")
    public void testLogin(){
        Actions.loginActions().openLoginPage();
        Actions.loginActions().doLogin(userData.getLogin(), userData.getPassword(), Constants.DEFAULT_SYSTEM_LANGUAGE);
        Actions.mainPageActions().assertOrdersAvailible();
    }

    @Test(dependsOnMethods = "testLogin")
    public void contractCreationTest(){

        CustomerData customerData = SerializeHelper.deserializeObject(CustomerData.class, Constants.CUSTOMER_SERIALIZE_FILENAME);

        if(customerData == null){
            customerData = DataFactory.generateDefaultCustomer(CustomerType.PROF_ADVERTISER);
            Actions.partnerActions().createCustomer(customerData);
            SerializeHelper.serializeObject(customerData, Constants.CUSTOMER_SERIALIZE_FILENAME);
        }

        ProductData productData = new ProductData();
        productData.setProductName("Le Matin");
        productData.setProductUniqueId("2200");

        ContractData contractData = new ContractData();

        contractData.setAssignmentName("Test " + Random.genRandNumberByTime());
        contractData.setProductData(productData);
        contractData.setCustomerData(customerData);
        contractData.setDiscountLevel("5.0 %");

        Actions.mainPageActions().createContract(contractData);
    }


}
