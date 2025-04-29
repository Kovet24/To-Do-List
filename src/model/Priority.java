package model;

import java.util.NoSuchElementException;

/**
 * Enum класс, для перечисления приоритетов: Высокий, Средний и Низкий.
 */
public enum Priority {
    // Конструктор и методы возможно будут удалены в будущем. Будет похоже на Status.
    // Или будут переделаны, например вместо "High", будет "Высокий".
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
