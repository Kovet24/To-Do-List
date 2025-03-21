package service;

import model.Record;
import model.ToDoList;

import java.util.List;

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
}
