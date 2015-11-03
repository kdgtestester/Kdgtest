package com.mediaspectrum.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class ProductData {
    private String productName;
    private String productUniqueId;
    private String productAdType;
    private String productHeading;
    private String productSubHeading;
    private String productTextBorder;
    private String productCompositePosition;
    private String productAdStructure;
    private String productBleed;
    private String productRateType;
    private String productClientType;
    private String productColor;
    private String productSize;
    private String productSizeHeight;
    private String productSizeLinesCount;
    private String productPrescriptionSize;
    private String productPrescriptionGroup;
    private String productPrescription;
    private int productDatesCount;
    private List<Calendar> productDates;
    private Boolean reservationOnly;
    private Boolean specialRequest;
    private String specialRequestDescription;
    //content area
    private String productContentType;
    private String productContentDescription;
    private String productContentLanguage;
    private boolean onlineProduct;

    public UiEditorData getUiEditorData() {
        return uiEditorData;
    }

    public void setUiEditorData(UiEditorData uiEditorData) {
        this.uiEditorData = uiEditorData;
    }

    private UiEditorData uiEditorData;

    public boolean isOnlineProduct() {
        return onlineProduct;
    }

    public void setOnlineProduct(boolean onlineProduct) {
        this.onlineProduct = onlineProduct;
    }

    //sub products
    private List<ProductData> subProducts;

    public ProductData() {
        subProducts = new LinkedList<>();
        productDates = new ArrayList<>();
    }

    public void addProductDate(Calendar date){
        this.productDates.add(date);
    }

    public void setSubProducts(List<ProductData> subProducts) {
        this.subProducts = subProducts;
    }

    public ProductData(String productName, String productUniqueId) {
        this.productName = productName;
        this.productUniqueId = productUniqueId;
    }

    public List<ProductData> getSubProducts() {
        return this.subProducts;
    }

    public void addSubProduct(ProductData subProduct) {
        this.subProducts.add(subProduct);
    }

    public String getProductUniqueId() {
        return productUniqueId;
    }

    public void setProductUniqueId(String productUniqueId) {
        this.productUniqueId = productUniqueId;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductDatesCount() {
        return productDatesCount;
    }

    public void setProductDatesCount(int productDatesCount) {
        this.productDatesCount = productDatesCount;
    }

    public void setProductAdType(String productAdType) {
        this.productAdType = productAdType;
    }

    public void setProductHeading(String productHeading) {
        this.productHeading = productHeading;
    }

    public void setProductCompositePosition(String productCompositePosition) {
        this.productCompositePosition = productCompositePosition;
    }

    public void setProductTextBorder(String productTextBorder) {
        this.productTextBorder = productTextBorder;
    }

    public void setProductAdStructure(String productAdStructure) {
        this.productAdStructure = productAdStructure;
    }

    public void setProductBleed(String productBleed) {
        this.productBleed = productBleed;
    }

    public void setProductClientType(String productClientType) {
        this.productClientType = productClientType;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public void setProductContentDescription(String productContentDescription) {
        this.productContentDescription = productContentDescription;
    }

    public void setProductContentType(String productContentType) {
        this.productContentType = productContentType;
    }

    public void setProductContentLanguage(String productContentLanguage) {
        this.productContentLanguage = productContentLanguage;
    }

    public void setProductDates(List<Calendar> productDates) {
        this.productDates = productDates;
    }

    public void setProductPrescriptionSize(String productPrescriptionSize) {
        this.productPrescriptionSize = productPrescriptionSize;
    }

    public void setProductRateType(String productRateType) {
        this.productRateType = productRateType;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setProductSubHeading(String productSubHeading) {
        this.productSubHeading = productSubHeading;
    }

    public void setReservationOnly(Boolean reservationOnly) {
        this.reservationOnly = reservationOnly;
    }

    public void setSpecialRequest(Boolean specialRequest) {
        this.specialRequest = specialRequest;
    }

    public void setSpecialRequestDescription(String specialRequestDescription) {
        this.specialRequestDescription = specialRequestDescription;
    }

    public Boolean isReservationOnly() {
        return reservationOnly;
    }

    public Boolean isSpecialRequest() {
        return specialRequest;
    }

    public List<Calendar> getProductDates() {
        return productDates;
    }

    public String getProductTextBorder() {
        return productTextBorder;
    }

    public String getProductAdStructure() {
        return productAdStructure;
    }

    public String getProductAdType() {
        return productAdType;
    }

    public String getProductBleed() {
        return productBleed;
    }

    public String getProductClientType() {
        return productClientType;
    }

    public String getProductColor() {
        return productColor;
    }

    public String getProductCompositePosition() {
        return productCompositePosition;
    }

    public String getProductContentDescription() {
        return productContentDescription;
    }

    public String getProductHeading() {
        return productHeading;
    }

    public String getProductPrescriptionSize() {
        return productPrescriptionSize;
    }

    public String getProductContentLanguage() {
        return productContentLanguage;
    }

    public String getProductContentType() {
        return productContentType;
    }

    public String getProductName() {
        return getProductName(true);
    }

    public String getProductName(boolean isDoRefactor){
        if(isDoRefactor) return this.productName.split("%")[0];
        return  this.productName;
    }

    public String getProductRateType() {
        return productRateType;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getProductSubHeading() {
        return productSubHeading;
    }

    public String getSpecialRequestDescription() {
        return specialRequestDescription;
    }

    public String getProductSizeHeight() {
        return productSizeHeight;
    }

    public void setProductSizeHeight(String productSizeHeight) {
        this.productSizeHeight = productSizeHeight;
    }

    public String getProductPrescriptionGroup() {
        return productPrescriptionGroup;
    }

    public void setProductPrescriptionGroup(String productPrescriptionGroup) {
        this.productPrescriptionGroup = productPrescriptionGroup;
    }

    public String getProductPrescription() {
        return productPrescription;
    }

    public void setProductPrescription(String productPrescription) {
        this.productPrescription = productPrescription;
    }

    public String getProductSizeLinesCount() {
        return productSizeLinesCount;
    }

    public void setProductSizeLinesCount(String productSizeLinesCount) {
        this.productSizeLinesCount = productSizeLinesCount;
    }
}

