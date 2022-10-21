package org.example.url;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    public static final String BASE_URL = "https://plan.polsl.pl";
    private String path;
    private Set<QueryParameter> queryParameters;

    private Url(Builder builder) {
        this.path = builder.path;
        this.queryParameters = builder.queryParameters;
    }

    @Override
    public String toString() {
        return BASE_URL + "/" + path + UrlUtils.SetOfQueryParametersToString(queryParameters);
    }

    public static class Builder {
        private final String path;
        private final Set<QueryParameter> queryParameters;

        public Builder(final String path) {
            this.path = path;
            this.queryParameters = new HashSet<>();
        }

        public Builder addQueryParameter(QueryParameter queryParameter) {
            queryParameters.add(queryParameter);
            return this;
        }

        public Url build() {
            return new Url(this);
        }
    }
}
