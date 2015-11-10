package com.cdpapp.actions.completesurvey.balancesheet;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetAssetsSurvey {

    public void setAssetsSurvey(){

        Pages.assetsSurvey().setUnrestrictedCashAndCashEquivalents();
        Pages.assetsSurvey().setTemporarilyRestrictedCashAndCashEquivalents();
        Pages.assetsSurvey().setPermanentlyRestrictedCashAndCashEquivalents();

        Pages.assetsSurvey().setUnrestrictedAccountsReceivable();
        Pages.assetsSurvey().setTemporarilyRestrictedAccountsReceivable();
        Pages.assetsSurvey().setPermanentlyRestrictedAccountsReceivable();

        Pages.assetsSurvey().setUnrestrictedGrantsAndPledgesReceivableCurrent();
        Pages.assetsSurvey().setTemporarilyRestrictedGrantsAndPledgesReceivableCurrent();
        Pages.assetsSurvey().setPermanentlyRestrictedGrantsAndPledgesReceivableCurrent();

        Pages.assetsSurvey().setUnrestrictedGrantsAndPledgesReceivableCurrent();
        Pages.assetsSurvey().setTemporarilyRestrictedGrantsAndPledgesReceivableCurrent();
        Pages.assetsSurvey().setPermanentlyRestrictedGrantsAndPledgesReceivableCurrent();

        Pages.assetsSurvey().setUnrestrictedPrepaidExpenses();
        Pages.assetsSurvey().setTemporarilyRestrictedPrepaidExpenses();
        Pages.assetsSurvey().setPermanentlyRestrictedPrepaidExpenses();

        Pages.assetsSurvey().setUnrestrictedInvestmentsCurrent();
        Pages.assetsSurvey().setTemporarilyRestrictedInvestmentsCurrent();
        Pages.assetsSurvey().setPermanentlyRestrictedInvestmentsCurrent();

        Pages.assetsSurvey().setUnrestrictedOtherCurrentAssets();
        Pages.assetsSurvey().setTemporarilyRestrictedOtherCurrentAssets();
        Pages.assetsSurvey().setPermanentlyRestrictedOtherCurrentAssets();

        Pages.assetsSurvey().setUnrestrictedGrantsAndPledgesReceivableNonCurrent();
        Pages.assetsSurvey().setTemporarilyRestrictedGrantsAndPledgesReceivableNonCurrent();
        Pages.assetsSurvey().setPermanentlyRestrictedGrantsAndPledgesReceivableNonCurrent();

        Pages.assetsSurvey().setUnrestrictedInvestmentsNonCurrent();
        Pages.assetsSurvey().setTemporarilyRestrictedInvestmentsNonCurrent();
        Pages.assetsSurvey().setPermanentlyRestrictedInvestmentsNonCurrent();

        Pages.assetsSurvey().setUnrestrictedFixedAssetsNet();
        Pages.assetsSurvey().setTemporarilyRestrictedFixedAssetsNet();
        Pages.assetsSurvey().setPermanentlyRestrictedFixedAssetsNet();

        Pages.assetsSurvey().setUnrestrictedOtherNonCurrentAssets();
        Pages.assetsSurvey().setTemporarilyRestrictedOtherNonCurrentAssets();
        Pages.assetsSurvey().setPermanentlyRestrictedOtherNonCurrentAssets();

        Pages.assetsSurvey().setUnrestrictedDueToDueFrom();
        Pages.assetsSurvey().setTemporarilyRestrictedDueToDueFrom();
        Pages.assetsSurvey().setPermanentlyRestrictedDueToDueFrom();

    }
}