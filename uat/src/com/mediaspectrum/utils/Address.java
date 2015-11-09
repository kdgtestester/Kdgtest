package com.mediaspectrum.utils;

import com.testmatick.utils.Persistence;

public class Address extends Persistence{

    private String addressType;
    private String country;
    private String region;
    private String city;
    private String street;
    private String streetNumber;
    private String zip;
    private PhoneData phone;

    public Address() {}

    public Address(String country, String region, String city, String street, String streetNumber, String zip, PhoneData phone) {
        this.setCountry(country);
        this.setRegion(region);
        this.setCity(city);
        this.setStreet(street);
        this.setStreetNumber(streetNumber);
        this.setZip(zip);
        this.setPhone(phone);
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(PhoneData phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZip() {
        return zip;
    }

    public PhoneData getPhone() {
        return phone;
    }
}
