package org.example.url;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UrlUtilsTest {

    @Test
    public void shouldReturnBlankWithGivenEmptySetOfParameters() {
        // given
        Set<QueryParameter> queryParameters = new HashSet<>();

        // when
        String result = UrlUtils.SetOfQueryParametersToString(queryParameters);

        // then
        Assertions.assertEquals("", result);
    }

    @Test
    public void shouldReturnRightStringWithGivenNotEmptySetOfParameters() {
        // given
        Set<QueryParameter> queryParameters = Set.of(
                new QueryParameter("key1", "value1"),
                new QueryParameter("key2", "value2")
        );

        // when
        String result = UrlUtils.SetOfQueryParametersToString(queryParameters);

        //then
        Assertions.assertEquals("?key1=value1&key2=value2", result);
    }
}
