package service;

import model.Priority;
import model.Record;
import model.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface Sortable {
    TreeMap<String, Record> sortRecordsByName(Map<String, Record> recordMap);

    TreeMap<Priority, List<Record>> sortRecordsByPriority(List<Record> recordList);

    TreeMap<Status, List<Record>> sortRecordByStatus(List<Record> recordList);
}
