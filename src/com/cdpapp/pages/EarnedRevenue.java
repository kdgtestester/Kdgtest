package com.cdpapp.pages;

import com.qatestlab.base.BasePage;

/**
 * Created by Petr on 05.11.2015.
 */
public class EarnedRevenue extends BasePage {

    public void setFoodAndConcessionsRevenue(){
        type("Set Food and Concessions Revenue", "1", "foodAndConcessionsRevenueField");
    }

    public void setGiftShopAndMerchandiseFees(){
        type("Set Gift Shop And Merchandise Fees", "1", "giftShopAndMerchandiseFeesField");
    }

    public void setParkingFees(){
        type("Set Parking Fees", "1", "parkingFeesField");
    }

    public void setAdvertisingRevenue(){
        type("Set Advertising Revenue", "1", "advertisingRevenueField");
    }

    public void setSponsorshipRevenue(){
        type("Set Sponsorship Revenue", "1", "sponsorshipRevenueField");
    }

    public void setSpecialEventsRevenue(){
        type("Set Special Events Revenue", "1", "specialEventsRevenueField");
    }

    public void waitSpecialEventsRevenueDescription(){
        waitForElementVisibility("specialEventsRevenueDescriptionField");
    }

    public void setSpecialEventsRevenueDescription(){
        type("Set Special Events Revenue Description", "1", "specialEventsRevenueDescriptionField");
    }

    public void setMembershipRevenueFromIndividuals(){
        type("Set Membership Revenue from Individuals", "1", "membershipRevenueFromIndividualsField");
    }

    public void setMembershipRevenuefromOrganizations(){
        type("Set Membership Revenue from Organizations", "1", "membershipRevenueFromOrganizationsField");
    }

    public void setOtherRentals(){
        type("Set Other Rentals", "1", "otherRentalsField");
    }

    public void checkCostumesProps(){
        type("Check Sets/Costumes/Props", "1", "setsCostumesPropsCheck");
    }

}
