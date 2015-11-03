package com.cdpapp.utils;


public class UiEditorData {

    //online content form
    private String contentLanguage;
    private String contentOperation;
    private String contentJobTitle;
    private String contentJobDescription;
    private Address contentAddress;

    //media category form
    private String mediaCategory;
    private String mediaSubCategory;

    public UiEditorData() {
    }

    public String getContentLanguage() {
        return contentLanguage;
    }

    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    public String getContentOperation() {
        return contentOperation;
    }

    public void setContentOperation(String contentOperation) {
        this.contentOperation = contentOperation;
    }

    public String getContentJobTitle() {
        return contentJobTitle;
    }

    public void setContentJobTitle(String contentJobTitle) {
        this.contentJobTitle = contentJobTitle;
    }

    public Address getContentAddress() {
        return contentAddress;
    }

    public void setContentAddress(Address contentAddress) {
        this.contentAddress = contentAddress;
    }

    public String getMediaSubCategory() {
        return mediaSubCategory;
    }

    public void setMediaSubCategory(String mediaSubCategory) {
        this.mediaSubCategory = mediaSubCategory;
    }

    public String getMediaCategory() {
        return mediaCategory;
    }

    public void setMediaCategory(String mediaCategory) {
        this.mediaCategory = mediaCategory;
    }

    public String getContentJobDescription() {
        return contentJobDescription;
    }

    public void setContentJobDescription(String contentJobDescription) {
        this.contentJobDescription = contentJobDescription;
    }
}
