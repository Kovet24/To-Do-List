package model;

import java.util.NoSuchElementException;

public enum Priority {
    LOW("Low"), MEDIUM("Medium"), HIGH("High");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public static Priority getPriority(String description) {
        return switch (description.toLowerCase()) {
            case "low" -> Priority.LOW;
            case "medium" -> Priority.MEDIUM;
            case "high" -> Priority.HIGH;
            default -> throw new NoSuchElementException("Not such priority");
        };
    }
}
