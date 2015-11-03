package com.mediaspectrum.control;

import com.mediaspectrum.actions.*;

public class Actions {

    private static Actions actions;

    private LoginActions loginActions;
    private MainPageActions mainPageActions;
    private AdvancedBookingActions advancedBookingActions;
    private PartnerActions partnerActions;
    private WebAdminActions webAdminActions;

    private Actions() {
        this.loginActions = new LoginActions();
        this.mainPageActions = new MainPageActions();
        this.advancedBookingActions = new AdvancedBookingActions();
        this.partnerActions = new PartnerActions();
        this.webAdminActions = new WebAdminActions();
    }

    public static void setupActions() {
        actions = new Actions();
    }

    public static LoginActions loginActions() {
        return actions.loginActions;
    }

    public static MainPageActions mainPageActions(){
        return actions.mainPageActions;
    }

    public static AdvancedBookingActions advancedBookingActions(){
        return actions.advancedBookingActions;
    }

    public static PartnerActions partnerActions() {
        return actions.partnerActions;
    }

    public static WebAdminActions webAdminActions() {return actions.webAdminActions;}


}
