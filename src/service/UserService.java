package service;

import model.Priority;
import model.Status;

import java.util.Scanner;

public class UserService {
    private final ToDoListService toDoListService;

    public UserService(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    public void setRecord() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название записи, которое желаете изменить: ");
        String name = scanner.nextLine();

        printMenu();

        boolean isStop = false;

        while (!isStop) {
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    name = setName(name, scanner);
                    printMenu();
                    break;

                case "2":
                    setPriority(name, scanner);
                    printMenu();
                    break;

                case "3":
                    setStatus(name, scanner);
                    printMenu();
                    break;

                case "4":
                    setDescription(name, scanner);
                    printMenu();
                    break;

                case "5":
                    isStop = true;
                    break;

                default:
                    System.out.println("Ошибка!\n");
                    printMenu();
                    break;
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("Выберете изменение:");
        System.out.println("1. Название;\n2. Приоритет;\n3. Статус;\n4. Описание;\n5. Закончить изменения.\n");
    }

    private String setName(String name, Scanner scanner) {
        System.out.println("Введиете новое название:");
        String newName = scanner.nextLine();
        toDoListService.setNameOfRecord(name, newName);
        System.out.println("Название изменено.\n");

        return newName;
    }

    private void setPriority(String name, Scanner scanner) {
        System.out.println("Выберите приоритет:");
        System.out.println("1. High;\n2. Medium;\n3. Low;");

        String newPriority = scanner.nextLine();

        switch (newPriority.toLowerCase()) {
            case "1":
                toDoListService.setPriorityOfRecord(name, Priority.HIGH);
                break;
            case "2":
                toDoListService.setPriorityOfRecord(name, Priority.MEDIUM);
                break;
            case "3":
                toDoListService.setPriorityOfRecord(name, Priority.LOW);
                break;
        }
        System.out.println("Приоритет изменен.\n");
    }

    private void setStatus(String name, Scanner scanner) {
        System.out.println("Выберете статус:");
        System.out.println("1. Done;\n2. In process;\n3. Not started;");

        String newStatus = scanner.nextLine();

        switch (newStatus.toLowerCase()) {
            case "1":
                toDoListService.setStatusOfRecord(name, Status.DONE);
                break;
            case "2":
                toDoListService.setStatusOfRecord(name, Status.IN_PROCESS);
                break;
            case "3":
                toDoListService.setStatusOfRecord(name, Status.NOT_STARTED);
                break;
        }
        System.out.println("Статус изменен.\n");
    }

    private void setDescription(String name, Scanner scanner) {
        System.out.println("Введите новое описание:");

        String newDescription = scanner.nextLine();
        toDoListService.setDescriptionOfRecord(name, newDescription);
        System.out.println("Описание изменено.\n");
    }
}
