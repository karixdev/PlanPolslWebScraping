package org.example.css;

import java.util.Map;

public class CssPropertyExtractor {
    public static int getTop(Map<String, String> stylesMap) {
        if (stylesMap.get("top") == null) {
            return 0;
        }

        return Integer.parseInt(stylesMap.get("top").split("px")[0]);
    }
}
