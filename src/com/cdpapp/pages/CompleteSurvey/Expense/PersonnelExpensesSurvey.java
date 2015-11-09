package com.cdpapp.pages.completesurvey.expense;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class PersonnelExpensesSurvey extends BasePage {

    public void setEmployeesProgram(){
        type("Set Employees Program", "1", "programEmployeesField");
    }

    public void setEmployeesFundraising(){
        type("Set Employees Fundraising", "1", "fundraisingEmployeesField");
    }

    public void setEmployeesGeneralAndAdministrative(){
        type("Set Employees General and Administrative", "1", "generalAdministrativeEmployeesField");
    }

    public void setIndependentContractorsProgram(){
        type("Set Independent Contractors Program", "1", "programIndependentContractorsField");
    }

    public void setIndependentContractorsFundraising(){
        type("Set Independent Contractors Fundraising", "1", "fundraisingIndependentContractors");
    }

    public void setIndependentContractorsGeneralAndAdministrative(){
        type("Set Independent Contractors General and Administrative", "1", "generalAdministrativeIndependentContractors");
    }

    public void setProfessionalFeesProgram(){
        type("Set Professional Fees Program", "1", "programProfessionalFees");
    }

    public void setProfessionalFeesFundraising(){
        type("Set Professional Fees Fundraising", "1", "fundraisingProfessionalFees");
    }

    public void setProfessionalFeesGeneralAndAdministrative(){
        type("Set Professional Fees General and Administrative", "1", "generalAndAdministrativeProfessionalFees");
    }

    public void setTotalPersonnelExpenses(){
        type("Set Total Personnel Expenses", "1", "totalPersonnelExpensesField");
    }

    public void checkArtistPayments(){
        setCheckboxState("Check Artist Payments", true, "artistPaymentsYesRadio");
    }

}
