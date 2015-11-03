package com.cdpapp.utils;


import java.util.List;

public class UserData {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String confirmPassword;
    private boolean ignorePasswordAging;
    private String company;
    private String jobFunction;
    private List<String> accessRules;
    private List<String> groups;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isIgnorePasswordAging() {
        return ignorePasswordAging;
    }

    public void setIgnorePasswordAging(boolean ignorePasswordAging) {
        this.ignorePasswordAging = ignorePasswordAging;
    }

    public List<String> getAccessRules() {
        return accessRules;
    }

    public void setAccessRules(List<String> accessRules) {
        this.accessRules = accessRules;
    }

    public UserData() {
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
