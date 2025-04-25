package model;

import java.time.LocalDate;

public class Record {
    private String name;
    private Priority priority;
    private Status status;
    private String description;
    private final LocalDate dateOfCreate;

    public Record(String name, Priority priority, String description) {
        this.name = name;
        this.priority = priority;
        status = Status.NOT_STARTED;
        this.description = description;
        dateOfCreate = LocalDate.now();
    }

    /** Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** Getters */
    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    @Override
    public String toString() {
        return "%s|%s|%s|%s|%s".formatted(name, priority, status, description, dateOfCreate);
    }
}