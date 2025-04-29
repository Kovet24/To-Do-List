package model;

import exception.NotAddedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Класс ToDoList - представляет задачник.
 * <p>
 *     Он хранит, принимает новые записи и предоставляет те, которые в нем хранятся.
 * </p>
 */
public class ToDoList {

    /**
     * Поле хранящее записи: {@link Record}
     * <p>
     *     Реализуется на базе Map. Ключом является String имя {@link Record}, ведущий к самой записи.
     * </p>
     */
    private final Map<String, Record> recordsMap;

    /**
     * Дефолтный конструктор, создающий {@code new HashMap} для {@link ToDoList#recordsMap}.
     *
     * @see ToDoList#ToDoList(List)
     */
    public ToDoList() {
        recordsMap = new HashMap<>();
    }

    /**
     * Конструктор, принимающий {@code List<Record>}, вызывающий дефолтный конструктор
     * и добавляющий в {@link  ToDoList#recordsMap}, все записи с {@code List<Record>}.
     *
     * @param recordList  это записи хранящиеся в {@code List<Record>}.
     * @see ToDoList#ToDoList()
     */
    public ToDoList(List<Record> recordList) {
        this();
        recordList.forEach(o -> recordsMap.put(o.getName(), o));
    }

    /**
     * Метод принимает и добавляет новый {@link Record} в {@link ToDoList#recordsMap}.
     *
     * @param newRecord  Новый {@link Record}.
     * @return {@link Record}, который мы добавили.
     * @throws NotAddedException  если такой {@link Record} уже добавлен в {@link ToDoList#recordsMap}.
     */
    public Record addRecord(Record newRecord) {
        if (!recordsMap.containsKey(newRecord.getName())) {
            recordsMap.put(newRecord.getName(), newRecord);

            return newRecord;
        } else {
            throw new NotAddedException("This record already added");
        }
    }

    /**
     * Метод получения {@link Record}, с помощью ввода его {@code name}.
     *
     * @param name  Название и ключ к {@link Record}.
     * @return Запрашиваемый {@link Record}.
     * @throws NoSuchElementException  если не был найден {@link Record} в {@link ToDoList#recordsMap}.
     */
    public Record getRecord(String name) {
        if (recordsMap.containsKey(name)) {
            return recordsMap.get(name);
        } else {
            throw new NoSuchElementException("Not such \"%s\" record!".formatted(name));
        }
    }

    /**
     * Метод получения всех записей.
     * @return {@link ToDoList#recordsMap}.
     */
    public Map<String, Record> getRecordsMap() {
        return recordsMap;
    }
}
