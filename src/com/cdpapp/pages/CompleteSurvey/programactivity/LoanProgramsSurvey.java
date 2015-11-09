package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class LoanProgramsSurvey extends BasePage {

    public void setLoanProgramsDescription(){
        type("Set Loan Programs Description", "1", "loanProgramsDescriptionArea");
    }

    public void setLoanRecipients(){
        type("Set Loan Recipients", "1", "loanRecipientsField");
    }

    public void setLoans(){
        type("Set Loans", "1", "loansField");
    }

    public void setAmountLoaned(){
        type("Set Amount Loaned", "1", "amountLoanedField");
    }
}
