package model;

import exception.NotAddedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ToDoList {
    private final Map<String, Record> recordsMap;

    public ToDoList() {
        recordsMap = new HashMap<>();
    }

    public ToDoList(List<Record> recordList) {
        this();
        recordList.forEach(o -> recordsMap.put(o.getName(), o));
    }

    public Record addRecord(Record newRecord) {
        if (!recordsMap.containsKey(newRecord.getName())) {
            recordsMap.put(newRecord.getName(), newRecord);

            return newRecord;
        } else {
            throw new NotAddedException("This record already added");
        }
    }

    public Record getRecord(String name) {
        if (recordsMap.containsKey(name)) {
            return recordsMap.get(name);
        } else {
            throw new NoSuchElementException("Not such \"%s\" record!".formatted(name));
        }
    }
}
