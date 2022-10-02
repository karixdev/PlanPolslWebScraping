package org.example.schedule;

import org.example.url.QueryParameter;
import org.example.url.Url;

public class ScheduleUrlBuilder {
    public static final String PATH = "plan.php";

    public static final String MIN_W = "1000";
    public static final String MIN_H = "1000";

    public static final String TYPE = "0";

    private final String id;

    public ScheduleUrlBuilder(String id) {
        this.id = id;
    }

    public Url build() {
        return new Url.Builder(PATH)
                .addQueryParameter(new QueryParameter("type", TYPE))
                .addQueryParameter(new QueryParameter("id", id))
                .addQueryParameter(new QueryParameter("winW", MIN_W))
                .addQueryParameter(new QueryParameter("winH", MIN_H))
                .build();
    }
}
