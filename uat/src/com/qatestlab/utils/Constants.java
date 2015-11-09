package com.testmatick.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String PAGES_PACKAGE_NAME = "pages";

    public static final int ELEMENT_MEGA_EXTRALONG_TIMEOUT_SECONDS = 360;
    public static final int ELEMENT_EXTRALONG_TIMEOUT_SECONDS = 180;
    public static final int ELEMENT_LONG_TIMEOUT_SECONDS = 120;
    public static final int ELEMENT_TIMEOUT_SECONDS = 60;
    public static final int ELEMENT_SMALL_TIMEOUT_SECONDS = 15;
    public static final int ELEMENT_EXTRASMALL_TIMEOUT_SECONDS = 5;
    public static final int ELEMENT_MICRO_TIMEOUT_SECONDS = 1;

    public static final int SCROLL_VALUE = 50;

    public static final String TESTLINK_DEV_KEY = "insert key here";
    public static final String TESTLINK_API_URL = "http://ng-testlink.mailordercentral.com/lib/api/xmlrpc/v1/xmlrpc.php";
    public static boolean TESTLINK_ENABLED = true;

    public static String PRODUCT_HEIGHT = "58";
    public static String PRODUCT_WIDTH = "45";

    public static String DEFAULT_ADMIN_LOGIN_PAGE_URL = "https://uat-publicitassales.mediaspectrum.net/webadmin";

    public static String BASE_URL = System.getProperty("baseurl", "https://google.com");

    // Login page constants
    public static String DEFAULT_SYSTEM_LANGUAGE = "English";

    //Default customer data
    public static String DEFAULT_CUSTOMER_COUNTRY = "Ukraine";
    public static String DEFAULT_CUSTOMER_MARKETING_BRANCH = "Adult";
    public static String DEFAULT_CUSTOMER_MARKETING_SEGMENT = "Anerkannte Vermittler";
    public static String DEFAULT_CUSTOMER_MARKETING_CLASSIFICATION = "New client";

    public static String CUSTOMER_SERIALIZE_FILENAME = "customer.obj";
    public static final String DEFAULT_CUSTOMER_CREDIT_LIMIT = "5000000";

    public static String DEFAULT_SUCCESSFUL_ORDER_ID = "10_9300000017157";
    //temporary
    public static String DEFAULT_PAYMENT_METHOD = "Cash/CC/DC";
    public static String INVOICE_PAYMENT_METHOD = "Invoice";

    public static List<String> DEFAULT_PARTNERS_TYPES = new ArrayList<>(Arrays.asList("Agency", "Private Advertiser",
            "Production House", "Prof. Advertiser", "Profit Center", "Publisher"));

    public static List<String> DEFAULT_RATE_TYPES = new ArrayList<>(Arrays.asList("Per unit", "In %", "In amount",
            "Free", "Without impact"));

    public static String DEFAULT_USER_NAME = "QA Central";
    public static final String DEFAULT_MAIL_FOLDER = "inbox";
    public static final String DEFAULT_INVOICE_MAIL_SUBJECT = "Notification in asp_artransactions_oms on publi-u-bgp-03.equinix.mediaspectrum.net (UAT)";

    public static final String DEFAULT_MAIL_LOGIN = "invoicing.testing@gmail.com";
    public static final String DEFAULT_MAIL_PASSWORD = "t-matick1147";

    public static final String DEFAULT_INTERNAL_PROVENANCE = "Team Digital ";
}
