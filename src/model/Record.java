package model;

import java.time.LocalDate;

/**
 * Этот класс описывает объект Запись (Record).
 */
public class Record {
    /**
     * String поле, содержащее имя Record.
     */
    private String name;

    /**
     * Priority поле, содержащее приоритет ({@link Priority}) Record.
     */
    private Priority priority;

    /**
     * Status поле, содержащее статус ({@link Status}) Record.
     */
    private Status status;

    /**
     * String поле, содержащее описание Record.
     */
    private String description;

    /**
     * LocalDate поле, содержащее дату создания Record.
     */
    private final LocalDate dateOfCreate;

    /**
     * Конструктор создания Record.
     * <p>
     *     Передаётся только имя, приоритет и описание Record.
     *      * Статус устанавливается по умолчанию - {@link Status#NOT_STARTED}.
     *      * Дата создания задается по {@link LocalDate#now()}.
     * </p>
     *
     * @param name  Имя Record.
     * @param priority  Приоритет Record.
     * @param description Описание Record.
     *
     * @see Priority
     */
    public Record(String name, Priority priority, String description) {
        this.name = name;
        this.priority = priority;
        status = Status.NOT_STARTED;
        this.description = description;
        dateOfCreate = LocalDate.now();
    }

    /**
     * Метод изменения имени Record.
     *
     * @param name  Новое имя для Record.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод изменения приоритета Record.
     *
     * @param priority  Новый приоритет для Record.
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Метод изменения статуса Record.
     *
     * @param status  Новый статус для Record.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Метод изменения описания Record.
     *
     * @param description  Новое описание для Record.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Метод получения имени Record.
     *
     * @return имя Record.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения приоритета Record.
     *
     * @return приоритет Record.
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Метод получения статуса Record.
     *
     * @return статус Record.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Метод получения описания Record.
     *
     * @return описание Record.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод получения даты создания Record.
     *
     * @return дата создания Record.
     */
    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    @Override
    public String toString() {
        return "%s|%s|%s|%s|%s".formatted(name, priority, status, description, dateOfCreate);
    }
}