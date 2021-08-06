package com.atm.locator.util;

public class UtilValidate {

    public static boolean isEmpty(String o) {
        return (null == o || o.length() == 0);
    }

    public static boolean isNotEmpty(String o) {
        return (null != o && o.length() > 0);
    }

    public static boolean isEmpty(Object o) {
        return (null == o);
    }

    public static boolean isNotEmpty(Object o) {
        return (null != o);
    }

}
