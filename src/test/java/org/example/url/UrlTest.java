package org.example.url;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UrlTest {
    @Test
    public void shouldCreateAppropriateUrlObject() {
        // given
        QueryParameter qp1 = new QueryParameter("key1", "value1");
        QueryParameter qp2 = new QueryParameter("key2", "value2");
        Set<QueryParameter> queryParameters = Set.of(qp1, qp2);
        String path = "somePath.php";

        // when
        Url url = new Url.Builder(path)
                .addQueryParameter(qp1)
                .addQueryParameter(qp2)
                .build();
        String result = url.toString();

        // then
        Assertions.assertEquals(path, url.getPath());
        Assertions.assertEquals(queryParameters, url.getQueryParameters());
        Assertions.assertEquals(Url.BASE_URL + "/somePath.php?key1=value1&key2=value2", url.toString());
    }
}
