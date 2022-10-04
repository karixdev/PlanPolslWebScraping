package org.example.webscraper;

import java.util.regex.Pattern;

public class TimeCellUtils {
    public static boolean isValidTimeCell(String text) {
        if (text.length() != 11) {
            return false;
        }

        Pattern regexPattern = Pattern.compile("[0-9]+:[0-9]+-[0-9]+:[0-9]+", Pattern.CASE_INSENSITIVE);
        return regexPattern.matcher(text).matches();
    }
}
