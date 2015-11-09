package com.cdpapp.pages.completesurvey.programactivity;

import com.testmatick.base.BasePage;

/**
 * Created by Petr on 09.11.2015.
 */
public class CompetitionsSurvey extends BasePage {

    public void setCompetitionsDescription(){
        type("Set Competitions Description", "1", "competitionsDescriptionArea");
    }

    public void setCompetitionsHosted(){
        type("Set Competitions Hosted", "1", "competitionsHostedField");
    }

    public void setCompetitors(){
        type("Set Competitors", "1", "competitorsField");
    }

    public void setEntryFee(){
        type("Set Entry Fee", "1", "entryFeeField");
    }

    public void setCompetitionWinners(){
        type("Set Competition Winners", "1", "competitionWinnersField");
    }

}
