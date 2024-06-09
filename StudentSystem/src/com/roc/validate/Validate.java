package com.roc.validate;

public class Validate {
    public static boolean validateUsername(String username) {
        if (username.length() < 3 || username.length() > 15)
            return false;
        if (username.chars().allMatch(Validate::isNumber))
            return false;
        return username.chars().allMatch(Validate::isLetterOrNumber);
    }

    public static boolean validatePersonID(String personID) {
        if (personID.length() != 18 || personID.startsWith("0"))
            return false;
        if (!personID.substring(0, 17).chars().allMatch(Validate::isNumber))
            return false;
        char lastChar = personID.charAt(personID.length() - 1);
        return isNumber(lastChar) || lastChar == 'X' || lastChar == 'x';
    }

    public static boolean validatePhoneNumber(String pn) {
        if (pn.length() != 11 || pn.startsWith("0"))
            return false;
        return pn.chars().allMatch(Validate::isNumber);
    }

    public static boolean isLetterOrNumber(int c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57);
    }

    public static boolean isNumber(int c) {
        return c >= 48 && c <= 57;
    }
}
