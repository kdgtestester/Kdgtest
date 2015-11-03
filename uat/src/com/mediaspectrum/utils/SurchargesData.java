package com.mediaspectrum.utils;

public class SurchargesData {
    private String surchargeName;
    private RatesData ratesData;
    private boolean isCalculationEnable = true;

    public boolean isCalculationEnable() {
        return isCalculationEnable;
    }

    public void setIsCalculationEnable(boolean isCalculationEnable) {
        this.isCalculationEnable = isCalculationEnable;
    }

    public SurchargesData(String surchargeName, RatesData ratesData) {
        this.surchargeName = surchargeName;
        this.ratesData = ratesData;
    }

    public SurchargesData() {
    }

    public String getSurchargeName() {
        return surchargeName;
    }

    public void setSurchargeName(String surchargeName) {
        this.surchargeName = surchargeName;
    }

    public RatesData getRatesData() {
        return ratesData;
    }

    public void setRatesData(RatesData ratesData) {
        this.ratesData = ratesData;
    }
}
