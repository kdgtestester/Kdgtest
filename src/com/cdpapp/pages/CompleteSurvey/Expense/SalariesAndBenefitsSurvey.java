package com.cdpapp.pages.completesurvey.expense;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class SalariesAndBenefitsSurvey extends BasePage {

    public void setSalaries(){
        type("Set Salaries", "1", "salariesField");
    }

    public void setPayrollTaxes(){
        type("Set Payroll Taxes", "1", "payrollTaxesField");
    }

    public void setHealthBenefits(){
        type("Set Health Benefits", "1", "healthBenefitsField");
    }

    public void setDisability(){
        type("Set Disability", "1", "disabilityField");
    }

    public void setWorkersComp(){
        type("Set Workers Comp", "1", "workersCompField");
    }

    public void setPensionAndRetirement(){
        type("Set Pension and Retirement", "1", "pensionAndRetirementField");
    }

    public void setOtherBenefits(){
        type("Set Other Benefits", "1", "otherBenefitsField");
    }

    public void setOtherBenefitsDescription(){
        type("Set Other Benefits - Description", "1", "otherBenefitsDescriptionField");
    }

}
