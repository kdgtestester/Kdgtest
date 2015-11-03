package com.cdpapp.utils;

import com.qatestlab.utils.Persistence;

public class PhoneData extends Persistence{

    private String phoneType;
    private String phoneNumber;
    private int countryCode;

    public PhoneData(String phoneType, String phoneNumber, int countryCode){
        this.setPhoneType(phoneType);
        this.setPhoneNumber(phoneNumber);
        this.setCountryCode(countryCode);
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }
}
