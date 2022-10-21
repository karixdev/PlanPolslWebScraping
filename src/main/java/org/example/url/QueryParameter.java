package org.example.url;

import java.util.Objects;

public record QueryParameter(String key, String value) {
    @Override
    public String toString() {
        return key + "=" + value;
    }
}
