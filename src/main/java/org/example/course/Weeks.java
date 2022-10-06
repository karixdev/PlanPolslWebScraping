package org.example.course;

public enum Weeks {
    EVEN("even"),
    ODD("odd"),
    EVERY("every");

    private final String value;

    Weeks(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
