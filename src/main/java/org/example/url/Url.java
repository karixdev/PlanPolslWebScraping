package org.example.url;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public Url addQueryParameter(QueryParameter queryParameter) {
        queryParameters.add(queryParameter);
        return this;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<QueryParameter> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Set<QueryParameter> queryParameters) {
        this.queryParameters = queryParameters;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(path, url.path) && Objects.equals(queryParameters, url.queryParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, queryParameters);
    }
}
