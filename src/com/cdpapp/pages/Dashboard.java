package com.cdpapp.pages;

import com.qatestlab.base.BasePage;
import com.qatestlab.reporting.Reporter;
import org.openqa.selenium.JavascriptExecutor;

public class Dashboard extends BasePage {

    public void waitUserLogin(){
        waitForElementVisibility("profilePicture");
    }

    public String getAuthUserLogin(){
        return getElement("userLogin").getText().trim();
    }

    public String getCurrentOrg(){
        return getElement("firstItemMenuWithOrg").getText().trim();
    }

    public void waitFirstItemMenuWithOrgItem(){
        waitForElementVisibility("firstItemMenuWithOrg");
        waitForElementToBeClickable("firstItemMenuWithOrg");
    }

    public void clickFirstItemMenuWithOrgItem(){
        click("Click first item menu with orgamization", "firstItemMenuWithOrg");
    }


    public void modalBody(){
        waitForElementEnable("modalBody");
    }

    public  void waitGrantNonprofitItem(){ waitForElementToBeClickable("grantNonprofitItem");}

    public void clickGrantNonprofitItem(){
        click("Click \"Grant + Nonprofit\" item", "grantNonprofitItem");
    }

    public void waitJoinOrCreateNewOrgItem(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, $('.container-fluid .dropdown-menu')[0].scrollHeight)");
        waitForElementToBeClickable("joinOrCreateNewOrgItem");
    }

    public void clickJoinOrCreateNewOrgItem(){
        click("Click \"Join or Create New Organization\" item", "joinOrCreateNewOrgItem");
    }

    public String availableStartSurButton(){
        waitForElementEnable("startSurveyButton");
        return getElementText("Get name Start survey button", "startSurveyButton").trim().toLowerCase();
    }

    public void waitStartSurveyButton(){
        waitForElementToBeClickable("startSurveyButton");
    }


    public void clickStartSurveyButton(){
        click("Click \"Start survey\" button", "startSurveyButton");
    }

    public void waitNewSurveyButton(){
        waitForElementToBeClickable("newSurveyButton");
    }

    public void clickNewSurveyButton(){
        click("Clik \"New Survey\" button", "newSurveyButton");
    }

    public void waitFirstSurvey(){
        waitForElementVisibility("firstItemSurvey");
    }

    public String getFirstSurvey(){
        return getElement("firstItemSurvey").getText().trim().toLowerCase();
    }


    public void waitReportsTab(){
        waitForElementToBeClickable("reportsTab");
    }

    public void clickReportsTab(){
        click("Click \"Reports\" tab", "reportsTab");
    }

}
