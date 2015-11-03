package com.mediaspectrum.control;

import com.mediaspectrum.pages.booking.PriceManagementTab;
import com.mediaspectrum.pages.partners.CreatePartnerPage;
import com.mediaspectrum.pages.partners.PartnersPage;
import com.mediaspectrum.pages.booking.OrderInformationTab;
import com.mediaspectrum.pages.booking.ScheduleAdvancedTab;

public class PartnersPages {
    private static PartnersPages pages;

    private PartnersPage partnersPage;
    private OrderInformationTab orderInformationTab;
    private ScheduleAdvancedTab scheduleAdvancedTab;
    private CreatePartnerPage createPartnerPage;
    private PriceManagementTab priceManagementTab;


    private PartnersPages() {
        partnersPage = new PartnersPage();
        orderInformationTab = new OrderInformationTab();
        scheduleAdvancedTab = new ScheduleAdvancedTab();
        createPartnerPage = new CreatePartnerPage();
        priceManagementTab = new PriceManagementTab();
    }

    public static void setupPages() {
        pages = new PartnersPages();
    }

    public static PartnersPage partnersPage() {
        return pages.partnersPage;
    }

    public static OrderInformationTab orderInformationTab() {
        return pages.orderInformationTab;
    }

    public static ScheduleAdvancedTab scheduleAdvancedTab() {
        return pages.scheduleAdvancedTab;
    }

    public static CreatePartnerPage createPartnerPage() {return pages.createPartnerPage;}

    public static PriceManagementTab priceManagementTab() {return pages.priceManagementTab;}

}
