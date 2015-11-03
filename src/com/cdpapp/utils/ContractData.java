package com.cdpapp.utils;


import java.util.Calendar;

public class ContractData {
    private CustomerData customerData;
    private ProductData productData;
    private String assignmentName;
    private String discountLevel;
    private Calendar startMonth;
    private boolean testAllFields;
    private boolean isAdjustmentTypeFinal;

    public ContractData() {
    }

    public boolean isTestAllFields() {
        return testAllFields;
    }

    public void setTestAllFields(boolean testAllFields) {
        this.testAllFields = testAllFields;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(String discountLevel) {
        this.discountLevel = discountLevel;
    }

    public Calendar getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Calendar startMonth) {
        this.startMonth = startMonth;
    }

    public boolean isAdjustmentTypeFinal() {
        return isAdjustmentTypeFinal;
    }

    public void setIsAdjustmentTypeFinal(boolean isAdjustmentTypeFinal) {
        this.isAdjustmentTypeFinal = isAdjustmentTypeFinal;
    }
}
