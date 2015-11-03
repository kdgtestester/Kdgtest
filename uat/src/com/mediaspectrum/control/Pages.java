package com.mediaspectrum.control;

import com.mediaspectrum.pages.*;
import com.mediaspectrum.pages.activities.ActivitiesPage;
import com.mediaspectrum.pages.approvals.ApprovalsPage;
import com.mediaspectrum.pages.billing.InvoicesTab;
import com.mediaspectrum.pages.billing.TransactionsTab;
import com.mediaspectrum.pages.dashboard.DashboardPage;
import com.mediaspectrum.pages.dashboard.OrdersPage;

public class Pages {
    private static Pages pages;

    private TopMenu topMenu;
    private LoginPage loginPage;
    private MainPage mainPage;
    private OrdersPage ordersPage;
    private LeftMenu leftMenu;
    private DashboardPage dashboardPage;
    private ActivitiesPage activitiesPage;
    private TransactionsTab transactionsTab;
    private InvoicesTab invoicesTab;
    private ApprovalsPage approvalsPage;

    private Pages() {
        this.loginPage = new LoginPage();
        this.mainPage = new MainPage();
        this.topMenu = new TopMenu();
        this.leftMenu = new LeftMenu();
        this.ordersPage = new OrdersPage();
        this.dashboardPage = new DashboardPage();
        this.activitiesPage = new ActivitiesPage();
        this.transactionsTab = new TransactionsTab();
        this.invoicesTab = new InvoicesTab();
        this.approvalsPage = new ApprovalsPage();
    }

    public static void setupPages() {
        pages = new Pages();
    }

    public static LoginPage loginPage() {
        return pages.loginPage;
    }

    public static MainPage mainPage() {
        return pages.mainPage;
    }

    public static OrdersPage ordersPage() {return pages.ordersPage;}

    public static TopMenu topMenu() {
        return pages.topMenu;
    }

    public static LeftMenu leftMenu() {return pages.leftMenu;}

    public static DashboardPage dashboardPage(){return  pages.dashboardPage;}

    public static ActivitiesPage activitiesPage(){return pages.activitiesPage;}

    public static InvoicesTab invoicesTab() {return pages.invoicesTab;}

    public static TransactionsTab transactionsTab() {return pages.transactionsTab;}

    public static ApprovalsPage approvalsPage() {return pages.approvalsPage; }
}
