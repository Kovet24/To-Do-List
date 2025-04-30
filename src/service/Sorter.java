package service;

import model.Priority;
import model.Record;
import model.Status;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Класс реализующий интерфейс {@link Sortable}.
 */
class Sorter implements Sortable {
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
    public TreeMap<Status, List<Record>> sortRecordsByStatus(List<Record> recordList) {
        Map<Status, List<Record>> recordMap = recordList.stream()
                .sorted(Comparator.comparing(Record::getPriority).thenComparing(Record::getName))
                .collect(Collectors.groupingBy(
                        Record::getStatus,
                        Collectors.toList()
                ));

        return new TreeMap<>(recordMap);
    }

    @Override
    public List<Record> sortRecordsByOnePriority(List<Record> recordList, Priority priority) {
        return recordList.stream()
                .filter(r -> r.getPriority() == priority)
                .sorted(Comparator.comparing(Record::getStatus).thenComparing(Record::getName))
                .toList();
    }

    @Override
    public List<Record> sortRecordsByOneStatus(List<Record> recordList, Status status) {
        return recordList.stream()
                .filter(r -> r.getStatus() == status)
                .sorted(Comparator.comparing(Record::getPriority).thenComparing(Record::getName))
                .toList();
    }
}
