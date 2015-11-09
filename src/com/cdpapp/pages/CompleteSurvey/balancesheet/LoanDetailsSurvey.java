package com.cdpapp.pages.completesurvey.balancesheet;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class LoanDetailsSurvey extends BasePage {

    public void setLineCreditLimit(){
        type("Set Line of Credit - Limit", "1", "lineCreditLimitField");
    }

    public void setLineCreditBalance(){
        type("Set Line of Credit - Balance", "1", "lineCreditBalanceField");
    }

    public void setMortgageCurrent(){
        type("Set Mortgage - Current", "1", "mortgageCurrentField");
    }

    public void setMortgageNonCurrent(){
        type("Set Mortgage - Non-Current", "1", "mortgageNonCurrentField");
    }

    public void setBondsPayableCurrent(){
        type("Set Bonds Payable - Current", "1", "bondsPayableCurrentField");
    }

    public void setBondsPayableNonCurrent(){
        type("Set Bonds Payable - Non-Current", "1", "bondsPayableNonCurrentField");
    }

    public void setOtherNotesLoansCurrent(){
        type("Set Other Notes and Loans - Current", "1", "otherNotesLoansCurrentField");
    }

    public void setOtherNotesLoansNonCurrent(){
        type("Set Other Notes and Loans - Non-Current", "1", "otherNotesLoansNonCurrentField");
    }

}
