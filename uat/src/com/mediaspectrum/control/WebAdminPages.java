package com.mediaspectrum.control;


import com.mediaspectrum.pages.webadmin.AdminLoginPage;
import com.mediaspectrum.pages.webadmin.NavigatorMenu;
import com.mediaspectrum.pages.webadmin.UsersTab;

public class WebAdminPages {

    private static WebAdminPages webAdminPages;

    private AdminLoginPage adminLoginPage;
    private NavigatorMenu navigatorMenu;
    private UsersTab usersTab;

    private WebAdminPages() {
        adminLoginPage = new AdminLoginPage();
        navigatorMenu = new NavigatorMenu();
        usersTab = new UsersTab();
    }

    public static void setupPages() {webAdminPages = new WebAdminPages();}

    public static AdminLoginPage adminLoginPage() {return webAdminPages.adminLoginPage;}

    public static NavigatorMenu navigatorMenu() {return  webAdminPages.navigatorMenu;}

    public static UsersTab usersTab() {return  webAdminPages.usersTab;}

}
