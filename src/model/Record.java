package model;

import java.time.LocalDate;

public class Record {
    private String name;
    private Priority priority;
    private Status status;
    private String description;
    private final LocalDate dateOfCreate;
    private LocalDate dateOfLastChanges;

    public Record(String name, Priority priority, String description) {
        this.name = name;
        this.priority = priority;
        status = Status.NOT_STARTED;
        dateOfCreate = LocalDate.now();
        dateOfLastChanges = LocalDate.now();
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }


}