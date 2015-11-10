package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetSalariesAndBenefitsSurvey{

    public void setSalariesAndBenefitsSurvey(){

        Pages.salariesAndBenefitsSurvey().setSalaries();
        Pages.salariesAndBenefitsSurvey().setPayrollTaxes();
        Pages.salariesAndBenefitsSurvey().setHealthBenefits();
        Pages.salariesAndBenefitsSurvey().setDisability();
        Pages.salariesAndBenefitsSurvey().setWorkersComp();
        Pages.salariesAndBenefitsSurvey().setPensionAndRetirement();
        Pages.salariesAndBenefitsSurvey().setOtherBenefits();
        Pages.salariesAndBenefitsSurvey().setOtherBenefitsDescription();

    }

}