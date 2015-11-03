package com.cdpapp.utils;

public class RatesData {

    private String rateAmount;
    private String rateItem;
    private String changingRateReason;
    private String changingRateDetails;
    private boolean selectAllProducts;

    public RatesData() {
    }

    public String getRateAmount() {
        return rateAmount;
    }

    public RatesData(String rateAmount) {
        this.rateAmount = rateAmount;
    }

    public String getRateItem() {
        return rateItem;
    }

    public void setRateItem(String rateItem) {
        this.rateItem = rateItem;
    }

    public void setRateAmount(String rateAmount) {
        this.rateAmount = rateAmount;
    }

    public String getChangingRateReason() {
        return changingRateReason;
    }

    public void setChangingRateReason(String changingRateReason) {
        this.changingRateReason = changingRateReason;
    }

    public String getChangingRateDetails() {
        return changingRateDetails;
    }

    public void setChangingRateDetails(String changingRateDetails) {
        this.changingRateDetails = changingRateDetails;
    }

    public boolean isSelectAllProducts() {
        return selectAllProducts;
    }

    public void setSelectAllProducts(boolean selectAllProducts) {
        this.selectAllProducts = selectAllProducts;
    }
}
