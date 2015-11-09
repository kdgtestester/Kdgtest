package com.mediaspectrum.utils;


import com.testmatick.utils.Constants;

public class OrderInformationData {

    private String orderSubCustomer;
    private String orderEntryChannel;
    private String orderInternalProvenance;
    private String orderObject;
    private String orderAgency;
    private String orderVommertialCategory;
    private String orderPaymentMethod;
    private String orderProfitCenter;
    private Boolean orderP2kVerification;

    public OrderInformationData() {
        this.orderInternalProvenance = Constants.DEFAULT_INTERNAL_PROVENANCE;
    }

    public String getOrderSubCustomer() {
        return orderSubCustomer;
    }

    public void setOrderSubCustomer(String orderSubCustomer) {
        this.orderSubCustomer = orderSubCustomer;
    }

    public String getOrderEntryChannel() {
        return orderEntryChannel;
    }

    public void setOrderEntryChannel(String orderEntryChannel) {
        this.orderEntryChannel = orderEntryChannel;
    }

    public String getOrderInternalProvenance() {
        return orderInternalProvenance;
    }

    public void setOrderInternalProvenance(String orderInternalProvenance) {
        this.orderInternalProvenance = orderInternalProvenance;
    }

    public String getOrderObject() {
        return orderObject;
    }

    public void setOrderObject(String orderObject) {
        this.orderObject = orderObject;
    }

    public String getOrderAgency() {
        return orderAgency;
    }

    public void setOrderAgency(String orderAgency) {
        this.orderAgency = orderAgency;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public Boolean isOrderP2kVerification() {
        return orderP2kVerification;
    }

    public void setOrderP2kVerification(Boolean orderP2kVerification) {
        this.orderP2kVerification = orderP2kVerification;
    }

    public String getOrderProfitCenter() {
        return orderProfitCenter;
    }

    public void setOrderProfitCenter(String orderProfitCenter) {
        this.orderProfitCenter = orderProfitCenter;
    }

    public String getOrderVommertialCategory() {
        return orderVommertialCategory;
    }

    public void setOrderVommertialCategory(String orderVommertialCategory) {
        this.orderVommertialCategory = orderVommertialCategory;
    }
}
