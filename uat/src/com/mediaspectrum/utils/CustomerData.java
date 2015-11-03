package com.mediaspectrum.utils;

import com.qatestlab.utils.Persistence;

import java.util.List;

public class CustomerData extends Persistence{

    private CustomerType customerType;
    private String customerID;
    private String companyName;
    private Address companyAddress;
    private boolean validateAddress;
    private List<Address> subAddresses;
    private String partnerProfitCenter;
    private String partnerAgency;

    //marketing data
    private String companyMarketingBrunch;
    private String companyMarketingSegment;
    private String companyMarketingClassification;

    //finantial data
    private boolean creditBlocked;
    private String creditLimit;

    public CustomerData(){}

    public CustomerData(CustomerType customerType, String companyName, Address companyAddress, String companyMarketingBrunch,
                        String companyMarketingSegment, String companyMarketingClassification){

        this.setCustomerType(customerType);
        this.setCompanyName(companyName);
        this.setCompanyAddress(companyAddress);
        this.setCompanyMarketingBrunch(companyMarketingBrunch);

        this.setCompanyMarketingSegment(companyMarketingSegment);
        this.setCompanyMarketingClassification(companyMarketingClassification);
    }

    public boolean isValidateAddress() {
        return validateAddress;
    }

    public void setValidateAddress(boolean validateAddress) {
        this.validateAddress = validateAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }


    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setCompanyMarketingBrunch(String companyMarketingBrunch) {
        this.companyMarketingBrunch = companyMarketingBrunch;
    }

    public void setCompanyMarketingSegment(String companyMarketingSegment) {
        this.companyMarketingSegment = companyMarketingSegment;
    }

    public void setCompanyMarketingClassification(String companyMarketingClassification) {
        this.companyMarketingClassification = companyMarketingClassification;
    }

    public String getCustomerType() {
        return customerType.getType();
    }

    public String getCompanyName() {
        return companyName;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyMarketingBrunch() {
        return companyMarketingBrunch;
    }

    public String getCompanyMarketingSegment() {
        return companyMarketingSegment;
    }

    public String getCompanyMarketingClassification() {
        return companyMarketingClassification;
    }

    public List<Address> getSubAddresses() {
        return subAddresses;
    }

    public void setSubAddresses(List<Address> subAddresses) {
        this.subAddresses = subAddresses;
    }

    public String getPartnerProfitCenter() {
        return partnerProfitCenter;
    }

    public void setPartnerProfitCenter(String partnerProfitCenter) {
        this.partnerProfitCenter = partnerProfitCenter;
    }

    public String getPartnerAgency() {
        return partnerAgency;
    }

    public void setPartnerAgency(String partnerAgency) {
        this.partnerAgency = partnerAgency;
    }

    public boolean isCreditBlocked() {
        return creditBlocked;
    }

    public void setCreditBlocked(boolean creditBlocked) {
        this.creditBlocked = creditBlocked;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }
}
