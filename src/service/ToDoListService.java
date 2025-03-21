package service;

import model.Priority;
import model.Record;
import model.Status;
import model.ToDoList;

import java.util.*;

public class ToDoListService {
    private final ToDoList toDoList;
    private final Sorter sorter;

    public ToDoListService() {
        toDoList = new ToDoList();
        sorter = new Sorter();
    }

    public ToDoListService(List<Record> recordList) {
        toDoList = new ToDoList(recordList);
        sorter = new Sorter();
    }

    public Record addRecord(Record newRecord) {
        return toDoList.addRecord(newRecord);
    }

    public Record getRecord(String name) {
        return toDoList.getRecord(name);
    }

    public List<Record> getSortedRecordListByName() {
        List<Record> recordList = new ArrayList<>(toDoList.getRecordsMap().values());
        recordList.sort(Comparator.comparing(Record::getName));

        return recordList;
    }

    public TreeMap<Priority, List<Record>> getSortedRecordMapByPriority() {
        return sorter.sortRecordsByPriority(new ArrayList<>(toDoList.getRecordsMap().values()));
    }

    public TreeMap<Status, List<Record>> getSortedRecordMapByStatus() {
        return sorter.sortRecordByStatus(new ArrayList<>(toDoList.getRecordsMap().values()));
    }
}
