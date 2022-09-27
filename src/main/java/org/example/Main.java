package org.example;

import org.example.url.QueryParameter;
import org.example.url.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static double formula(int top) {
        // type2: 259
        // type0: 237
        int dTop = top - 237;
        double ratio = dTop / 45.0;

        ratio = ratio / 0.25;

        int roundUpNumberOfQuarters = (int) Math.ceil(ratio);
        roundUpNumberOfQuarters *= 15;

        return roundUpNumberOfQuarters / 60.0 + 8;
    }

    public static String minAndHour(int top) {
        double val = formula(top);
        int intPart = (int) val;
        double fraction = val - intPart;
        int minutes = (int) (fraction * 60);

        return intPart + ":" + minutes;
    }

    public static Map<String, String> getStyleMap(Element element) {
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

    public static void main(String[] args) {
        Url url = new Url.Builder("plan.php")
                .addQueryParameter(new QueryParameter("type", "0"))
                .addQueryParameter(new QueryParameter("id", "39884"))
                .addQueryParameter(new QueryParameter("winW", "1000"))
                .addQueryParameter(new QueryParameter("winH", "1000"))
                .build();

        try {
            final Document document = Jsoup.connect(url.toString()).get();
            Elements element = document.select(".coursediv");

            System.out.println(url);

            element.forEach(el -> {
                Map<String, String> styles = getStyleMap(el);
                int topValue = Integer.parseInt(styles.get("top").split("px")[0]);
                String ch = el.attr("ch");

                if (topValue > 0 && !ch.equals("")) {
                    int chInt = Integer.parseInt(ch);
                    int totalTime = topValue + chInt + 6;

                    System.out.println(el.text());
                    System.out.println("Starts at: " + minAndHour(topValue));
                    System.out.println("Ends at: " + minAndHour(totalTime));
                    System.out.println("----------------");
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
