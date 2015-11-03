package com.qatestlab.utils;

import com.mediaspectrum.utils.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataFactory {

    public static Address generateDefaultAddress(){
        Address address = new Address();
        address.setCountry(Constants.DEFAULT_CUSTOMER_COUNTRY);
        address.setStreet("Street");
        address.setStreetNumber(Random.genInt(1, 100) + "");
        address.setRegion("Region");
        address.setCity("City");
        address.setZip(Random.genInt(1900, 1950) + "");
        address.setPhone(new PhoneData("Office", Random.genInt(1000000, 9999999) + "", 380));

        return address;
    }

    public static CustomerData generateDefaultCustomer(CustomerType customerType){
        CustomerData newCustomerData = new CustomerData();

        newCustomerData.setCustomerType(customerType);
        newCustomerData.setCompanyName("Automation company " + Random.genShortRandNumberByTime());
        newCustomerData.setCompanyAddress(generateDefaultAddress());
        newCustomerData.setCompanyMarketingBrunch(Constants.DEFAULT_CUSTOMER_MARKETING_BRANCH);
        newCustomerData.setCompanyMarketingSegment(Constants.DEFAULT_CUSTOMER_MARKETING_SEGMENT);
        newCustomerData.setCompanyMarketingClassification(Constants.DEFAULT_CUSTOMER_MARKETING_CLASSIFICATION);
        newCustomerData.setPartnerProfitCenter("XENTIVE");
        newCustomerData.setCreditBlocked(false);
        return newCustomerData;
    }

    public static List<Calendar> generateDatesList(int datesCount){
        List<Calendar> dates = new ArrayList<>();
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH, 1);

        for(int i = 0; i < datesCount; i++){
            date.add(Calendar.DAY_OF_YEAR, 1);
            Calendar newDate = Calendar.getInstance();
            newDate.setTime(date.getTime());
            dates.add(newDate);
        }
        return dates;
    }

    public static UiEditorData generateDefaultUiEditorData(){
        UiEditorData uiEditorData = new UiEditorData();
        uiEditorData.setContentLanguage("French");
        uiEditorData.setContentOperation("Offer");
        uiEditorData.setContentJobTitle("Title");
        uiEditorData.setContentJobDescription("Description");
        uiEditorData.setContentAddress(generateDefaultAddress());
        uiEditorData.setMediaCategory("Electronic/Engineering/Watches");
        uiEditorData.setMediaSubCategory("Electronics/Electrotechnics");
        return uiEditorData;
    }

    public static UserData generateSeniorUserData(){
        UserData userData = new UserData();

        userData.setFirstName("Fname " + Random.genShortRandNumberByTime());
        userData.setLastName("Lname" + Random.genShortRandNumberByTime());
        userData.setLogin("Login" + Random.genShortRandNumberByTime());

        String password = "Secret"+Random.genRandNumberByTime();
        userData.setPassword(password);
        userData.setConfirmPassword(password);

        userData.setIgnorePasswordAging(true);
        userData.setCompany("(7226) (10-930) TEST - XENTIVE");
        userData.setJobFunction("Back Office");

        List<String> accessRules = new ArrayList<>();
        accessRules.add("(173) ADSPRO_PUB_CH_ACCESS");
        accessRules.add("(156) ASP_MovePrepayToLive");
        accessRules.add("(142) CRM_ALL_Activity");
        accessRules.add("(172) CRM_Activity_Delete");
        accessRules.add("(179) CRM_Activity_Senior");
        accessRules.add("(150) CRM_ApproveHighCredi");
        accessRules.add("(155) CRM_Contract_Senior");
        accessRules.add("(1) Systems");
        accessRules.add("(148) WebAdmin_Labels");
        accessRules.add("(149) WebAdmin_LabelsLocal");

        userData.setAccessRules(accessRules);

        List<String> groups = new ArrayList<>();
        groups.add("(95) Central Team");

        userData.setGroups(groups);
        return userData;
    }

    public static UserData generateJuniorUserData(){
        UserData userData = new UserData();

        userData.setFirstName("Fname " + Random.genShortRandNumberByTime());
        userData.setLastName("Lname" + Random.genShortRandNumberByTime());
        userData.setLogin("Login" + Random.genShortRandNumberByTime());

        String password = "Secret"+Random.genRandNumberByTime();
        userData.setPassword(password);
        userData.setConfirmPassword(password);

        userData.setIgnorePasswordAging(true);
        userData.setCompany("(7226) (10-930) TEST - XENTIVE");

        userData.setJobFunction("Back Office");

        List<String> accessRules = new ArrayList<>();
        accessRules.add("(154) CRM_Contract_Junior");
        accessRules.add("(1) Systems");
        accessRules.add("(148) WebAdmin_Labels");
        accessRules.add("(149) WebAdmin_LabelsLocal");

        userData.setAccessRules(accessRules);

        List<String> groups = new ArrayList<>();
        groups.add("Back-office");

        return userData;
    }

    public static RatesData generateRateData(String rateAmount){
        RatesData ratesData = new RatesData(rateAmount);
        ratesData.setChangingRateReason("Discount publisher user");
        ratesData.setRateItem("Per unit");
        ratesData.setChangingRateDetails("Pricing");
        ratesData.setSelectAllProducts(true);

        return ratesData;
    }





}
