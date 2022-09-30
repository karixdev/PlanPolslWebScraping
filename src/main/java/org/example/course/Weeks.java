package org.example.course;

public enum Weeks {
    EVEN("even"),
    ODD("odd"),
    EVERY("every");

    private final String value;

    private Weeks(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }
}
