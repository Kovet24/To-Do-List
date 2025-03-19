package service;

import model.Record;

import java.util.Map;
import java.util.TreeMap;

public interface Sortable {
    TreeMap<String, Record> sortRecordsByName(Map<String, Record> recordMap);

    TreeMap<String, Record> sortRecordsByPriority(Map<String, Record> recordMap);

    TreeMap<String, Record> sortRecordByStatus(Map<String, Record> recordMap);
}
