package org.example.url;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryParameterTest {

    @Test
    public void shouldReturnRightQueryParameterFormat() {
        // given
        QueryParameter queryParameter = new QueryParameter("key1", "value1");

        // when
        String result = queryParameter.toString();

        // then
        Assertions.assertEquals("key1=value1", result);
    }
}