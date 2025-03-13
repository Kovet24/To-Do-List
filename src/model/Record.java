package model;

import java.time.LocalDate;

public class Record {
    private String name;
    private Status status;
    private String description;
    private final LocalDate dateOfCreate;
    private LocalDate dateOfLastChanges;

    public Record(String name, String description) {
        this.name = name;
        status = Status.NOT_STARTED;
        dateOfCreate = LocalDate.now();
        dateOfLastChanges = LocalDate.now();
    }

    
}
