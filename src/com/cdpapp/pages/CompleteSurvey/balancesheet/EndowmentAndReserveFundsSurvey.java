package com.cdpapp.pages.completesurvey.balancesheet;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class EndowmentAndReserveFundsSurvey extends BasePage {

    public void setTotalBoardDesignatedEndowment(){
        type("Set Total Board-Designated Endowment ", "1", "totalBoardDesignatedEndowmentField");
    }

    public void setBoardDesignatedAssetsCash(){
        type("Set Board-Designated Assets - Cash", "1", "boardDesignatedAssetsCashField");
    }

    public void setBoardDesignatedAssetsInvestments(){
        type("Set Board-Designated Assets - Investments", "1", "boardDesignatedAssetsInvestmentsField");
    }

    public void setBoardDesignatedAssetsOtherAssets(){
        type("Set Board-Designated Assets - Other Assets", "1", "boardDesignatedAssetsOtherAssetsField");
    }

    public void setEndowmentCorpus(){
        type("Set Endowment Corpus", "1", "endowmentCorpusField");
    }

    public void setAmountWithdrawn(){
        type("Set Amount Withdrawn", "1", "amountWithdrawnField");
    }

    public void setMaximumAnnualWithdrawalPercentage(){
        type("Set Maximum Annual Withdrawal Percentage", "1", "maximumAnnualWithdrawalPercentageField");
    }

    public void checkRevenueLinesContainingEndowmentDraw(){
        setCheckboxState("Check Operating Investment Income", true, "operatingInvestmentIncomeRadio");
    }

    public void setNotes(){
        type("Set Notes", "1", "notesArea");
    }

    public void setUnrestrictedTotalTermEndowment(){
        type("Set Unrestricted Total Term Endowment", "1", "unrestrictedTotalTermEndowment");
    }

    public void setTemporarilyRestrictedTotalTermEndowment(){
        type("Set Temporarily Restricted Total Term Endowment", "1", "temporarilyRestrictedTotalTermEndowment");
    }

    public void setUnrestrictedTermEndowmentAssetsCash(){
        type("Set Unrestricted Term Endowment Assets - Cash", "1", "unrestrictedTermEndowmentAssetsCash");
    }

    public void setTemporarilyRestrictedTermEndowmentAssetsCash(){
        type("Set Temporarily Restricted Term Endowment Assets - Cash", "1", "temporarilyRestrictedTermEndowmentAssetsCash");
    }

    public void setUnrestrictedTermEndowmentAssetsInvestments(){
        type("Set Unrestricted Term  Endowment Assets - Investments", "1", "unrestrictedTermEndowmentAssetsInvestments");
    }

    public void setTemporarilyRestrictedTermEndowmentAssetsInvestments(){
        type("Set Temporarily Restricted Term Endowment Assets - Investments", "1", "temporarilyRestrictedTermEndowmentAssetsInvestments");
    }

    public void setUnrestrictedTermEndowmentAssetsOtherAssets(){
        type("Set Unrestricted Term  Endowment Assets - Other Assets", "1", "unrestrictedTermEndowmentAssetsOtherAssets");
    }

    public void setTemporarilyRestrictedTermEndowmentAssetsOtherAssets(){
        type("Set Temporarily Restricted Term Endowment Assets - Other Assets", "1", "temporarilyRestrictedTermEndowmentAssetsOtherAssets");
    }

    public void setOriginalTermEndowmentCorpus(){
        type("Set Original Term Endowment Corpus", "1", "originalTermEndowmentCorpusField");
    }

    public void setAmountWithdrawn2(){
        type("Set Amount Withdrawn", "1", "amountWithdrawnField2");
    }

    public void setMaximumAnnualWithdrawalPercentage2(){
        type("Set Maximum Annual Withdrawal Percentage", "1", "maximumAnnualWithdrawalPercentageField2");
    }

    public void checkRevenueLinesContainingEndowmentDraw2(){
        setCheckboxState("Check Operating Investment Income", true, "operatingInvestmentIncomeCheck2");
    }

    public void setNotes2(){
        type("Set Notes 2", "1", "notesArea2");
    }


    public void setUnrestrictedTotalPermanentEndowment(){
        type("Set Unrestricted Total Permanent  Endowment", "1", "unrestrictedTotalPermanentEndowment");
    }

    public void setTemporarilyRestrictedTotalPermanentEndowment(){
        type("Set Temporarily Restricted Total Permanent  Endowment", "1", "temporarilyRestrictedTotalPermanentEndowment");
    }

    public void setPermanentlyRestrictedTotalPermanentEndowment(){
        type("Set Permanently Restricted Total Permanent  Endowment", "1", "permanentlyRestrictedTotalPermanentEndowment");
    }

    public void setUnrestrictedPermanentEndowmentAssetsCash(){
        type("Set Unrestricted Permanent  Endowment Assets - Cash", "1", "unrestrictedPermanentEndowmentAssetsCash");
    }

    public void setTemporarilyRestrictedPermanentEndowmentAssetsCash(){
        type("Set Temporarily Restricted Permanent  Endowment Assets - Cash", "1", "temporarilyRestrictedPermanentEndowmentAssetsCash");
    }

    public void setPermanentlyRestrictedPermanentEndowmentAssetsCash(){
        type("Set Permanently Restricted Permanent  Endowment Assets - Cash", "1", "permanentlyRestrictedPermanentEndowmentAssetsCash");
    }

    public void setUnrestrictedPermanentEndowmentAssetsInvestments(){
        type("Set Unrestricted Permanent   Endowment Assets - Investments", "1", "unrestrictedPermanentEndowmentAssetsInvestments");
    }

    public void setTemporarilyRestrictedPermanentEndowmentAssetsInvestments(){
        type("Set Temporarily Restricted Permanent  Endowment Assets - Investments", "1", "temporarilyRestrictedPermanentEndowmentAssetsInvestments");
    }

    public void setPermanentlyRestrictedPermanentEndowmentAssetsInvestments(){
        type("Set Permanently Restricted Permanent  Endowment Assets - Investments", "1", "permanentlyRestrictedPermanentEndowmentAssetsInvestments");
    }

    public void setUnrestrictedPermanentEndowmentAssetsOtherAssets(){
        type("Set Unrestricted Permanent  Endowment Assets - Other Assets", "1", "unrestrictedPermanentEndowmentAssetsOtherAssets");
    }

    public void setTemporarilyRestrictedPermanentEndowmentAssetsOtherAssets(){
        type("Set Temporarily Restricted Permanent  Endowment Assets - Other Assets", "1", "temporarilyRestrictedPermanentEndowmentAssetsOtherAssets");
    }

    public void setPermanentlyRestrictedPermanentEndowmentAssetsOtherAssets(){
        type("Set Permanently Restricted Permanent  Endowment Assets - Other Assets", "1", "permanentlyRestrictedPermanentEndowmentAssetsOtherAssets");
    }

    public void setOriginalEndowmentCorpus(){
        type("Set Original Endowment Corpus", "1", "originalEndowmentCorpus");
    }

    public void setAmountWithdrawn3(){
        type("Set Amount Withdrawn", "1", "amountWithdrawnField3");
    }

    public void setMaximumAnnualWithdrawalPercentage3(){
        type("Set Maximum Annual Withdrawal Percentage", "1", "maximumAnnualWithdrawalPercentageField3");
    }

    public void checkRevenueLinesContainingEndowmentDraw3(){
        setCheckboxState("Check Revenue Lines Containing Endowment Draw", true, "operatingInvestmentIncomeCheck3");
    }

    public void setNotes3(){
        type("Set Notes 3", "1", "notesArea3");
    }

    public void setTotalReserveFunds(){
        type("Set Total Reserve Funds", "1", "totalReserveFundsField");
    }

    public void setReservesCash(){
        type("Set Reserves - Cash", "1", "reservesCashField");
    }

    public void setReserveInvestments(){
        type("Set Reserve - Investments", "1", "reserveInvestmentsField");
    }

    public void setReservesOtherAssets(){
        type("Set Reserves - Other Assets", "1", "reservesOtherAssetsField");
    }

    public void setReserveInvestments2(){
        type("Set Reserve - Investments 2", "1", "reserveInvestmentsField2");
    }

    public void setReservesOtherAssets2(){
        type("Set Reserves - Other Assets 2", "1", "reservesOtherAssetsField2");
    }

    public void setTotalReserveFunds2(){
        type("Set Total Reserve Funds 2", "1", "totalReserveFundsField2");
    }

    public void setReservesCash2(){
        type("Set Reserves - Cash 2", "1", "reservesCashField2");
    }

    public void setReserveInvestments3(){
        type("Set Reserve - Investments 3", "1", "reservesInvestmentsField3");
    }

    public void setReservesOtherAssets3(){
        type("Set Reserves - Other Assets 3", "1", "reservesOtherAssetsField3");
    }

    public void setAmountWithdrawn4(){
        type("Set Reserves - Other Assets 4", "1", "amountWithdrawnField4");
    }

    public void setMaximumAnnualWithdrawalPercentageAllowedPerPolicy(){
        type("Set Maximum Annual Withdrawal Percentage Allowed Per Policy", "1", "maxAnnualWithDrawalPercentageAllowedPerPolic");
    }

    public void checkRevenueLinesContainingReserveDraw(){
        setCheckboxState("Check Revenue Lines Containing Reserve Draw", true, "operatingInvestmentIncomeCheck4");
    }

    public void setNotes4(){
        type("Set Notes 4", "1", "notesArea4");
    }

}
