package com.cdpapp.pages.completesurvey.expense;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class WorkforceSurvey extends BasePage {

    public void checkPaidStaff(){
        setCheckboxState("Check \"Yes\" Paid Staff", true, "paidStaffYesRadio");
    }

    public void setFullTimePermanentEmployees() {
        type("Set Full-Time Permanent Employees", "1", "fullTimePermanentEmployeesField");
    }

    public void checkFullTimePermanentEmployees(){
        setCheckboxState("Check estimate Full-Time Permanent Employees", true, "fullTimePermanentEmployeesFieldEstimateCheck");
    }

    public void checkWorkforceEntryPreferences(){
        setCheckboxState("Check \"Hour\" Workforce Entry Preferences", true, "workforceEntryPreferencesHourRadio");
    }

    public void setFullTimeSeasonalEmployeesNumEmpl() {
        type("Set Full-Time Seasonal Employees number Employees", "1", "numberEmployeesfullTimePermanentEmployeesField");
    }

    public void checkEstimateFullTimeSeasonalEmployeesNumEmpl(){
        setCheckboxState("Check estimate  Full-Time Seasonal Employees number Employees", true, "numberEmployeesfullTimePermanentEmployeesFieldEstimateCheck");
    }

    public void setFullTimeSeasonalEmployeesHoursWorked() {
        type("Set Full-Time Seasonal Employees Hours Worked", "1", "hoursWorkedfullTimePermanentEmployeesField");
    }

    public void checkEstimateFullTimeSeasonalEmployeesHoursWorked(){
        setCheckboxState("Check estimate Full-Time Seasonal Employees Hours Worked", true, "hoursWorkedFullTimePermanentEmployeesFieldEstimateCheck");
    }

    public void setFullTimeArtists() {
        type("Set Full-Time Artists", "1", "numberEmployeesfullTimeArtists");
    }

    public void checkEstimateFullTimeArtists(){
        setCheckboxState("Check estimate Full-Time Artists", true, "fullTimeArtistsEstimateCheck");
    }

    public void setPartTimePermanentEmployeesNumEmpl() {
        type("Set Part-Time Permanent Employees", "1", "numberEmployeesPartTimePermanentEmployees");
    }

    public void checkEstimatePartTimePermanentEmployeesNumEmpl(){
        setCheckboxState("Check estimate Part-Time Permanent Employees", true, "numberEmployeesPartTimePermanentEmployeesEstimateCheck");
    }

    public void setPartTimePermanentEmployeesHourWorker() {
        type("Set Part-Time Permanent Employees Hour Worker", "1", "partTimePermanentEmployeesField");
    }

    public void checkEstimatePartTimePermanentEmployeesHourWorker(){
        setCheckboxState("Check estimate Part-Time Permanent Employees Hour Worker", true, "partTimePermanentEmployeesEstimateCheck");
    }

    public void setPartTimeSeasonalEmployeesNumEmpl() {
        type("Set Part-Time Seasonal Employees number employee", "1", "numberEmployeesPartTimeSeasonalEmployees");
    }

    public void checkPartTimeSeasonalEmployeesNumEmpl(){
        setCheckboxState("Check estimate Part-Time Permanent Employees number employee", true, "numberEmployeesPartTimeSeasonalEmployeesEstimateCheck");
    }

    public void setPartTimeSeasonalHourWorker() {
        type("Set Part-Time Seasonal Employees  Hour Worker", "1", "hoursWorkedPartTimeSeasonalEmployees");
    }

    public void checkPartTimeSeasonalEmployeesHourWorker(){
        setCheckboxState("Check estimate Part-Time Permanent Employees Hour Worker", true, "hoursWorkedPartTimeSeasonalEmployeesEstimateCheck");
    }

    public void setPartTimeArtists() {
        type("Set Part-Time Artists", "1", "numberEmployeesPartTimeArtists");
    }

    public void checkPartTimeArtists(){
        setCheckboxState("Check estimate Part-Time Artists", true, "numberEmployeesPartTimeArtistsEstimateCheck");
    }

    public void setFullTimeVolunteers() {
        type("Set Full-Time Volunteers", "1", "numberEmployeesFullTimeVolunteers");
    }

    public void checkFullTimeVolunteers(){
        setCheckboxState("Check estimate Full-Time Volunteers", true, "numberEmployeesFullTimeVolunteersEstimateCheck");
    }

    public void setPartTimeVolunteersNumVol() {
        type("Set Part-Time Volunteers Number of Volunteers", "1", "numberEmployeesPartTimeVolunteers");
    }

    public void checkPartTimeVolunteersNumVol(){
        setCheckboxState("Check estimate Part-Time Volunteers Number of Volunteers", true, "numberEmployeesPartTimeVolunteersEstimateCheck");
    }

    public void setPartTimeVolunteersHourContributed() {
        type("Set Part-Time Volunteers HourContributed", "1", "hoursContributedPartTimeVolunteers");
    }

    public void checkPartTimeVolunteersHourContributed(){
        setCheckboxState("Check estimate Part-Time Volunteers HourContributed", true, "hoursContributedPartTimeVolunteersEstimateCheck");
    }

    public void setInternsAndApprenticesNumVol() {
        type("Set Interns and Apprentices Number of Volunteers", "1", "numberEmployeesInternsApprentices");
    }

    public void checkPartInternsAndApprenticesNumVol(){
        setCheckboxState("Check estimate Interns and Apprentices Number of Volunteers", true, "numberEmployeesInternsApprenticesEstimateCheck");
    }

    public void setInternsAndApprenticesHourContributed() {
        type("Set Interns and Apprentices Hour Contributed", "1", "hoursWorkedInternsApprentices");
    }

    public void checkPartInternsAndApprenticesHourContributed(){
        setCheckboxState("Check estimate Interns and Apprentices Hour Contributed", true, "hoursWorkedInternsApprenticesEstimateCheck");
    }

    public void setIndependentContractorsNumCon() {
        type("Set Independent Contractors Number of Contractors", "1", "numberContractorsIndependentContractors");
    }

    public void checkIndependentContractorsNumCon(){
        setCheckboxState("Check estimate Independent Contractors Number of Contractors", true, "numberContractorsIndependentContractorsEstimateCheck");
    }

    public void setIndependentContractorsHoursWorked() {
        type("Set Independent Contractors Hours Worked", "1", "hoursWorkedIndependentContractors");
    }

    public void checkIndependentContractorsHoursWorked(){
        setCheckboxState("Check estimate Independent Contractors Hours Worked", true, "hoursWorkedIndependentContractorsEstimateCheck");
    }

    public void setIndependentContractorsArtists() {
        type("Set Independent Contractors - Artists", "1", "independentContractorsArtistField");
    }

}
