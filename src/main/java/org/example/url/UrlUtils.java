package org.example.url;

import java.util.Set;

public class UrlUtils {
    public static String SetOfQueryParametersToString(Set<QueryParameter> queryParameterSet) {
        if (queryParameterSet.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder("?");
        queryParameterSet.forEach(el -> stringBuilder.append(el.toString()).append("&"));
        // delete last &
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
