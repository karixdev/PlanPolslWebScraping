package org.example.css;

import java.util.Map;

public class CssPropertyExtractor {
    public static int getSizeProperty(Map<String, String> stylesMap, String propertyName) {
        if (stylesMap.get(propertyName) == null) {
            return 0;
        }

        return Integer.parseInt(stylesMap.get(propertyName).split("px")[0]);
    }
}
