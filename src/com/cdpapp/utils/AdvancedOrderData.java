package com.cdpapp.utils;


import java.util.LinkedList;
import java.util.List;

public class AdvancedOrderData {

    private CustomerData customerData;
    private List<ProductData> products;
    private OrderInformationData orderInformationData;
    private RatesData ratesData;
    private String orderID;
    private SurchargesData surchargesData;

    public AdvancedOrderData() {
        products = new LinkedList<>();
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProduct(ProductData product) {
        this.products.add(product);
    }

    public OrderInformationData getOrderInformationData() {
        return orderInformationData;
    }

    public void setOrderInformationData(OrderInformationData orderInformationData) {
        this.orderInformationData = orderInformationData;
    }

    public RatesData getRatesData() {
        return ratesData;
    }

    public void setRatesData(RatesData ratesData) {
        this.ratesData = ratesData;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }


    public SurchargesData getSurchargesData() {
        return surchargesData;
    }

    public void setSurchargesData(SurchargesData surchargesData) {
        this.surchargesData = surchargesData;
    }
}
