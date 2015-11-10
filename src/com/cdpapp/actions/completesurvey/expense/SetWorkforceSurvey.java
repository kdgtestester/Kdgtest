package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetWorkforceSurvey {

    public void setWorkforceSurvey(){

        Pages.workforceSurvey().checkPaidStaff();

        Pages.workforceSurvey().setFullTimePermanentEmployees();
        Pages.workforceSurvey().checkFullTimePermanentEmployees();

        Pages.workforceSurvey().checkWorkforceEntryPreferences();

        Pages.workforceSurvey().setFullTimeSeasonalEmployeesNumEmpl();
        Pages.workforceSurvey().checkEstimateFullTimeSeasonalEmployeesNumEmpl();

        Pages.workforceSurvey().setFullTimeSeasonalEmployeesHoursWorked();
        Pages.workforceSurvey().checkEstimateFullTimeSeasonalEmployeesHoursWorked();

        Pages.workforceSurvey().setFullTimeArtists();
        Pages.workforceSurvey().checkEstimateFullTimeArtists();

        Pages.workforceSurvey().setPartTimePermanentEmployeesNumEmpl();
        Pages.workforceSurvey().checkEstimatePartTimePermanentEmployeesNumEmpl();

        Pages.workforceSurvey().setPartTimePermanentEmployeesHourWorker();
        Pages.workforceSurvey().checkEstimatePartTimePermanentEmployeesHourWorker();

        Pages.workforceSurvey().setPartTimeSeasonalEmployeesNumEmpl();
        Pages.workforceSurvey().checkPartTimeSeasonalEmployeesNumEmpl();

        Pages.workforceSurvey().setPartTimeSeasonalHourWorker();
        Pages.workforceSurvey().checkPartTimeSeasonalEmployeesHourWorker();

        Pages.workforceSurvey().setPartTimeArtists();
        Pages.workforceSurvey().checkPartTimeArtists();

        Pages.workforceSurvey().setFullTimeVolunteers();
        Pages.workforceSurvey().checkFullTimeVolunteers();

        Pages.workforceSurvey().setPartTimeVolunteersNumVol();
        Pages.workforceSurvey().checkPartTimeVolunteersNumVol();

        Pages.workforceSurvey().setPartTimeVolunteersHourContributed();
        Pages.workforceSurvey().checkPartTimeVolunteersHourContributed();

        Pages.workforceSurvey().setInternsAndApprenticesNumVol();
        Pages.workforceSurvey().checkPartInternsAndApprenticesNumVol();

        Pages.workforceSurvey().setInternsAndApprenticesHourContributed();
        Pages.workforceSurvey().checkPartInternsAndApprenticesHourContributed();

        Pages.workforceSurvey().setIndependentContractorsNumCon();
        Pages.workforceSurvey().checkIndependentContractorsNumCon();

        Pages.workforceSurvey().setIndependentContractorsHoursWorked();
        Pages.workforceSurvey().checkIndependentContractorsHoursWorked();

        Pages.workforceSurvey().setIndependentContractorsArtists();

    }

}