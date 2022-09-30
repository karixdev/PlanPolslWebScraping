package org.example.html;

import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

public class HtmlAttributeValueExtractor {
    public static int getCh(Element el) {
        try {
            return Integer.parseInt(el.attr("ch"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static Map<String, String> getStyles(Element element) {
        Map<String, String> keymaps = new HashMap<>();
        if (!element.hasAttr("style")) {
            return keymaps;
        }

        String styleStr = element.attr("style");
        String[] keys = styleStr.split(":");

        if (keys.length < 2) {
            return keymaps;
        }

        String[] split;
        for (int i = 0; i < keys.length; i++) {
            if (i % 2 != 0) {
                split = keys[i].split(";");
                if (split.length == 1) break;
                keymaps.put(split[1].trim(), keys[i + 1].split(";")[0].trim());
            } else {
                split = keys[i].split(";");
                if (i + 1 == keys.length) break;
                keymaps.put(keys[i].split(";")[split.length - 1].trim(), keys[i + 1].split(";")[0].trim());
            }
        }

        return keymaps;
    }
}
