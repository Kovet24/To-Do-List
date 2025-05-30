package service;

import exception.NameConflictException;
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

    /** Methods for add, get and contains Record */
    public Record addRecord(Record newRecord) {
        return toDoList.addRecord(newRecord);
    }

    public Record getRecord(String name) {
        return toDoList.getRecord(name);
    }

    public boolean contains(String name) {
        return toDoList.getRecordsMap().containsKey(name);
    }

    /** Method to manipulate record */
    public void setNameOfRecord(String name, String newName) {
        if (!toDoList.getRecordsMap().containsKey(newName)) {
            Record record = toDoList.getRecord(name);
            record.setName(newName);

            toDoList.getRecordsMap().remove(name);
            toDoList.getRecordsMap().put(newName, record);
        } else {
            throw new NameConflictException("This \"%s\" name is already occupied!".formatted(newName));
        }
    }

    public void setPriorityOfRecord(String name, Priority priority) {
        toDoList.getRecord(name).setPriority(priority);
    }

    public void setStatusOfRecord(String name, Status status) {
        toDoList.getRecord(name).setStatus(status);
    }

    public void setDescriptionOfRecord(String name, String description) {
        toDoList.getRecord(name).setDescription(description);
    }

    /** Methods for get sorted collections by something of Records */
    public List<Record> getSortedRecordListByName() {
        List<Record> recordList = new ArrayList<>(toDoList.getRecordsMap().values());
        recordList.sort(Comparator.comparing(Record::getName));

        return recordList;
    }

    public TreeMap<Priority, List<Record>> getSortedRecordMapByPriority() {
        return sorter.sortRecordsByPriority(new ArrayList<>(toDoList.getRecordsMap().values()));
    }

    public TreeMap<Status, List<Record>> getSortedRecordMapByStatus() {
        return sorter.sortRecordsByStatus(new ArrayList<>(toDoList.getRecordsMap().values()));
    }

    public List<Record> getRecordsByPriority(Priority priority) {
        return sorter.sortRecordsByOnePriority(new ArrayList<>(toDoList.getRecordsMap().values()), priority);
    }

    public List<Record> getRecordsByStatus(Status status) {
        return sorter.sortRecordsByOneStatus(new ArrayList<>(toDoList.getRecordsMap().values()), status);
    }
}
