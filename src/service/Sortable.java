package service;

import model.Priority;
import model.Record;
import model.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Интерфейс, созданный чисто для практики.
 * <p>
 * В будущем скорее всего будет удален или переделан.
 * </p>
 */
public interface Sortable {

    /**
     * Метод для сортировки {@link Record} по {@code name}.
     *
     * @param recordMap передаваемая {@link Map} для получения и сортировки {@link Record}.
     * @return Отсортированный {@link TreeMap} по {@code name}.
     */
    // Возможно переделаю. В качестве param будет List<Record>.
    TreeMap<String, Record> sortRecordsByName(Map<String, Record> recordMap);

    /**
     * Метод для сортировки {@link Record} по {@link Priority}.
     *
     * @param recordList передаваемый {@link List} для получения и сортировки {@link Record}.
     * @return Отсортированный {@link TreeMap} по {@link Priority}.
     */
    TreeMap<Priority, List<Record>> sortRecordsByPriority(List<Record> recordList);

    /**
     * Метод для сортировки {@link Record} по {@link Status}.
     *
     * @param recordList передаваемый {@link List} для получения и сортировки {@link Record}.
     * @return Отсортированный {@link TreeMap} по {@link Status}.
     */
    TreeMap<Status, List<Record>> sortRecordsByStatus(List<Record> recordList);

    /**
     * Метод для сортировки и выдачи {@link List} по определенному {@link Priority}.
     * <p>
     * Возвращает {@code List<Record>}, отсортированный по {@code name} и
     * содержащий те {@link Record}, соответствующих переданному {@link Priority}.
     * </p>
     *
     * @param recordList передаваемый {@link List} для получения и сортировки {@link Record}.
     * @param priority   передаваемый {@link Priority} для получения определенных {@link Record}.
     * @return Отсортированный {@code List<Record>} содержащий только {@link Record} с переданным {@link Priority}.
     */
    List<Record> sortRecordsByOnePriority(List<Record> recordList, Priority priority);

    /**
     * Метод для сортировки и выдачи {@link List} по определенному {@link Status}.
     * * <p>
     * Возвращает {@code List<Record>}, отсортированный по {@code name} и
     * содержащий те {@link Record}, соответствующих переданному {@link Status}.
     * * </p>
     *
     * @param recordList передаваемый {@link List} для получения и сортировки {@link Record}.
     * @param status     передаваемый {@link Status} для получения определенных {@link Record}.
     * @return Отсортированный {@code List<Record>} содержащий только {@link Record} с переданным {@link Status}.
     */
    List<Record> sortRecordsByOneStatus(List<Record> recordList, Status status);
}
