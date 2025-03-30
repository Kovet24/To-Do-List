package userService;

class Printer {
    static void printMenu() {
        System.out.println("Введите:");
        System.out.println("1. Добавление, удаление или изменение задач");
        System.out.println("2. Вывести на экран задачи;");
    }

    static void printAddGetSetMenu() {
        System.out.println("Введите:");
        System.out.println("1. Добавить запись;");
        System.out.println("2. Удалить запись;");
        System.out.println("3. Изменить запись;");
    }

    static void printRecordsMenu() {
        System.out.println("Выберите, что вывести на экран:");
        System.out.println("1. Весь список задач;");
        System.out.println("2. Список задач отсортированный по приоритетам;");
        System.out.println("3. Список задач отсортированный по статусу;");
    }

    static void printSetRecordMenu() {
        System.out.println("Выберете изменение:");
        System.out.println("1. Название;\n2. Приоритет;\n3. Статус;\n4. Описание;\n5. Закончить изменения.\n");
    }
}
