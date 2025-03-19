package service;

import model.Priority;
import model.Record;
import model.Status;

import java.util.*;
import java.util.stream.Collectors;

public class RecordService implements Sortable {
    @Override
    public TreeMap<String, Record> sortRecordsByName(Map<String, Record> recordMap) {
        return new TreeMap<>(recordMap);
    }

    @Override
    public TreeMap<Priority, List<Record>> sortRecordsByPriority(List<Record> recordList) {
        Map<Priority, List<Record>> recordMap = recordList.stream()
                .sorted(Comparator.comparing(Record::getName))
                .collect(Collectors.groupingBy(
                        Record::getPriority,
                        Collectors.toList()
                ));

        return new TreeMap<>(recordMap);
    }

    @Override
    public TreeMap<Status, List<Record>> sortRecordByStatus(List<Record> recordList) {
        Map<Status, List<Record>> recordMap = recordList.stream()
                .sorted(Comparator.comparing(Record::getPriority).thenComparing(Record::getName))
                .collect(Collectors.groupingBy(
                        Record::getStatus,
                        Collectors.toList()
                ));

        return new TreeMap<>(recordMap);
    }
}
