package service;

import exception.NameConflictException;
import model.Priority;
import model.Record;
import model.Status;
import model.ToDoList;

import java.util.*;

/**
 * Класс сервис для {@link ToDoList}.
 * <p>
 *     Предназначен для совмещения функции добавления/удаления и
 *     изменения {@link Record}, а также получения отсортированных {@link Record},
 *     по каким-либо критериям.
 * </p>
 */
public class ToDoListService {

    /**
     * Поле содержащее {@link ToDoList}, для добавления/удаления и изменения {@link Record}.
     */
    private final ToDoList toDoList;

    /**
     * Поле содержащее {@link Sorter}, для получения отсортированных {@link Record}.
     */
    private final Sorter sorter;

    /**
     * Дефолтный конструктор.
     * <p>
     *     Создает {@link ToDoList} и {@link Sorter} и
     *     присваивает к соответствующим полям.
     * </p>
     *
     * @see ToDoListService#ToDoListService(List)
     */
    public ToDoListService() {
        toDoList = new ToDoList();
        sorter = new Sorter();
    }

    /**
     * Конструктор с параметром типа {@code List<Record>}.
     * <p>
     *     Предназначен, если уже существует какой-либо {@code List<Record>}, для передачи его в
     *     конструктор {@link ToDoList#ToDoList(List)}. Также создает {@link Sorter} и присваивает его к полю.
     * </p>
     * @param recordList Передаётся в конструктор {@link ToDoList#ToDoList(List)}.
     * @see ToDoListService#ToDoListService()
     */
    public ToDoListService(List<Record> recordList) {
        toDoList = new ToDoList(recordList);
        sorter = new Sorter();
    }

    /**
     * Вызывает {@link ToDoList#addRecord(Record)}.
     *
     * @param newRecord Добавляемый {@link Record} в {@link ToDoList}.
     * @return Добавленный {@link Record}, при успешном выполнении.
     */
    // Может быть добавлю throws.
    public Record addRecord(Record newRecord) {
        return toDoList.addRecord(newRecord);
    }

    /**
     * Вызывает {@link ToDoList#getRecord(String)}.
     *
     * @param name Имя/ключ, чтобы получить конкретный {@link Record}.
     * @return {@link Record} который запрашивался.
     */
    public Record getRecord(String name) {
        return toDoList.getRecord(name);
    }

    /**
     * Вызывает {@link ToDoList#getRecordsMap()}, чтобы вызвать {@link Map#containsKey(Object)}
     * для проверки наличия {@link Record} в {@link ToDoList}.
     *
     * @param name Имя/ключ, чтобы получить конкретный {@link Record}.
     * @return {@code boolean} в зависимости от наличия {@link Record} в {@link ToDoList}.
     */
    public boolean contains(String name) {
        return toDoList.getRecordsMap().containsKey(name);
    }

    /**
     * Изменяет {@code name} у {@link Record} на новое название {@code newName}.
     * <p>
     *     Метод, проверяет в {@link ToDoList} наличие {@link Record} со схожим {@code newName}.
     *     Если нет, то изменяет у {@link Record}, который получили через параметр {@code name}, и
     *     изменяет название на {@code newNa,me}
     * </p>
     *
     * @param name
     * @param newName
     */
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
