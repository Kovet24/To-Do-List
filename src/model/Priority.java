package model;

import java.util.NoSuchElementException;

public enum Priority {
    HIGH("High"), MEDIUM("Medium"), LOW("Low");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Priority getPriority(String description) {
        return switch (description.toLowerCase()) {
            case "low" -> Priority.LOW;
            case "medium" -> Priority.MEDIUM;
            case "high" -> Priority.HIGH;
            default -> throw new NoSuchElementException("No such priority");
        };
    }
}
