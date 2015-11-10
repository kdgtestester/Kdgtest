package com.cdpapp.actions.completesurvey.expense;

import com.cdpapp.control.Pages;

/**
 * Created by Petro on 10.11.2015.
 */
public class SetMarketingAndSocialMediaSurvey {

    public void setMarketingAndSocialMediaSurvey(){

        Pages.marketingAndSocialMediaSurvey().setTotalMarketingExpense();

        Pages.marketingAndSocialMediaSurvey().checkEnterMarketingBudget();

        Pages.marketingAndSocialMediaSurvey().setOther();

        Pages.marketingAndSocialMediaSurvey().setDirectMailRecipients();
        Pages.marketingAndSocialMediaSurvey().setDirectMailCampaigns();
        Pages.marketingAndSocialMediaSurvey().setEmailRecipients();
        Pages.marketingAndSocialMediaSurvey().setEblastsSent();
        Pages.marketingAndSocialMediaSurvey().setAverageClickThroughRate();
        Pages.marketingAndSocialMediaSurvey().setAverageConversionRate();

        Pages.marketingAndSocialMediaSurvey().setOtherSocialMediaPlatformDescription();

        Pages.marketingAndSocialMediaSurvey().setWebsitePageViews();
        Pages.marketingAndSocialMediaSurvey().setWebsiteSessionsVisits();
        Pages.marketingAndSocialMediaSurvey().setWebsiteUniqueVisitors();

    }

}
