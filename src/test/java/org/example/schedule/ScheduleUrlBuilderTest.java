package org.example.schedule;

import org.example.url.QueryParameter;
import org.example.url.Url;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScheduleUrlBuilderTest {
    @Test
    public void shouldReturnProperUrl() {
        // given
        String id = "123";

        // when
        ScheduleUrlBuilder scheduleUrlBuilder = new ScheduleUrlBuilder(id);
        Url result = scheduleUrlBuilder.build();

        // then
        Url expected = new Url.Builder("plan.php")
                .addQueryParameter(new QueryParameter("type", "0"))
                .addQueryParameter(new QueryParameter("id", id))
                .addQueryParameter(new QueryParameter("winW", "1000"))
                .addQueryParameter(new QueryParameter("winH", "1000"))
                .build();

        Assertions.assertEquals(expected, result);
    }
}
