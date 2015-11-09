package com.cdpapp.pages.completesurvey.expense;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class MarketingAndSocialMediaSurvey extends BasePage {

    public void setTotalMarketingExpense(){
        type("Total Marketing expense", "1", "totalMarketingExpenseField");
    }

    public void checkEnterMarketingBudget(){
        setCheckboxState("Check \"No\" Enter marketing budget", true, "noRadioEntermarketingbudget");
    }

    public void setOther(){
        type("Set Other", "1", "otherField2");
    }

    public void setDirectMailRecipients(){
        type("Set Direct Mail Recipients", "1", "directMailRecipientsField");
    }

    public void setDirectMailCampaigns(){
        type("Set Direct Mail Campaigns", "1", "directMailCampaignsField");
    }

    public void setEmailRecipients(){
        type("Set Email Recipients", "1", "emailRecipientsField");
    }

    public void setEblastsSent(){
        type("Set Eblasts Sent", "1", "eblastsSentField");
    }

    public void setAverageClickThroughRate(){
        type("Set Average Click Through Rate", "1", "averageClickThroughRateField");
    }

    public void setAverageConversionRate(){
        type("Set Average Conversion Rate", "1", "averageConversionRateField");
    }

    public void setOtherSocialMediaPlatformDescription(){
        type("Set Other Social Media Platform Description", "1", "otherSocialMediaPlatformDescriptionArea");
    }

    public void setWebsitePageViews(){
        type("Set Website Page Views", "1", "websitePageViewsField");
    }

    public void setWebsiteSessionsVisits(){
        type("Set Website Sessions/Visits", "1", "websiteSessionsVisitsField");
    }


    public void setWebsiteUniqueVisitors(){
        type("Set Website Unique Visitors", "1", "websiteUniqueVisitorsField");
    }

}
