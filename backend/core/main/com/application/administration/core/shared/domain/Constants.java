package com.application.administration.core.shared.domain;

public class Constants {

    public Constants() {
    }

    public static final String APP_NAME = "application";
    public static final String MODULE_NAME = "administration";
    public static final String MAIN_PACKAGE_NAME = String.format("com.%s.%s", APP_NAME, MODULE_NAME);
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
