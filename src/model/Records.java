package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Records {
    private final Map<String, Record> recordsMap;

    public Records(List<Record> recordList) {
        recordsMap = new HashMap<>();
        recordList.forEach(o -> recordsMap.put(o.getName(), o));
    }

    public boolean addRecord(Record newRecord) {
        if (!recordsMap.containsKey(newRecord.getName())) {
            recordsMap.put(newRecord.getName(), newRecord);

            return true;
        } else {
            return false;
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
