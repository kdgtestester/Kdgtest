package com.mediaspectrum.utils;

public enum CustomerType {
    PROF_ADVERTISER("Prof. Advertiser"), AGENCY("Agency"); //add others in case of requirements

    private String type;

    private CustomerType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
