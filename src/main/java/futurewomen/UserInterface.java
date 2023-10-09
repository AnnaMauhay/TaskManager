package futurewomen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class will handle displaying options, receiving user input, and managing the application's user interface.
 */
public class UserInterface {
    private static TaskList taskList;

    public static void run() {
        StringBuilder header = new StringBuilder("""
        ============================
        =    Hello and welcome!    =
        = I am your Micro Manager! =
        ============================
        """);
        StringBuilder homeMenu = new StringBuilder("""
                    What would you like to do?
                        1. Create a task.
                        2. View task.
                        3. Change task title.
                        4. Change task description.
                        5. Change task priority.
                        6. Change task status.
                        7. Delete task.
                        9. Exit.""");

        Task task = new Task("Create Initial Structure",
                "Create all classes and methods as per specifications.",
                Task.Priority.LOW, Task.Status.IN_PROGRESS);
        taskList = new TaskList(task);
        //taskList = new TaskList();

        Scanner input = new Scanner(System.in);
        int choice = 0;
        String answer = "";
        while (choice != 9) {
            System.out.print("\033[H\033[2J");
            System.out.flush();         //clears the screen
            System.out.println(header);
            System.out.println(homeMenu);
            try {
                choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("You want to create a new task. Please provide a title");
                        Scanner in = new Scanner(System.in);
                        String title = "";
                        title = in.nextLine();
                        System.out.println("Provide the description.");
                        String description = "";
                        description = in.nextLine();
                        taskList.add(new Task(title, description));
                        System.out.println(taskList.getTask(taskList.getCount() - 1).toString());
                        input.nextLine();
                        break;
                    case 2:
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to view?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                System.out.println(taskList.getTask(choice).toString());
                            } else System.out.println("Your input returned no result.");
                        }
                        input.nextLine();
                        break;

                    case 3: //Change task title
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to update?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                System.out.println("Please write the new title.");
                                answer = input.nextLine();
                                taskList.changeTitle(choice, answer);
                                System.out.println(taskList.getTask(choice).toString());
                            } else System.out.println("Your input returned no result.");
                        }
                        input.nextLine();
                        break;

                    case 4: //Change task description.
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to update?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                System.out.println("Please write the new description.");
                                answer = input.nextLine();
                                taskList.changeDescription(choice, answer);
                                System.out.println(taskList.getTask(choice).toString());
                            } else System.out.println("Your input returned no result.");
                        }
                        input.nextLine();
                        break;

                    case 5: //Change task priority.
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to update?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                changePriority(choice);
                            } else System.out.println("Your input returned no result.");
                        }
                        input.nextLine();
                        break;

                    case 6: //Change task status..
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to update?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                changeStatus(choice);
                            } else System.out.println("Your input returned no result.");
                        }
                        input.nextLine();
                        break;

                    case 7: //Delete task.
                        if (displayTaskList().isEmpty()) {
                            System.out.println("--- Empty Task List ---");
                        } else {
                            System.out.println("Which of the tasks would you like to delete?");
                            System.out.println(displayTaskList());

                            choice = input.nextInt();
                            input.nextLine();
                            if (isValid(choice)) {
                                taskList.delete(choice);
                                System.out.println("Deletion successful.");
                            } else {
                                System.out.println("Your input returned no result.");
                            }
                        }
                        input.nextLine();
                        break;
                    case 9:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Please provide a number from the above choices");
                        input.nextLine();
                }
            }catch (InputMismatchException exception){
                System.out.println("Please enter an integer value");
                input.nextLine();
                input.nextLine();
            }
        }


    }

    private static void changePriority(int validChoice) {
        Scanner input = new Scanner(System.in);
        Task.Priority[] priorityList = Task.Priority.values();

        System.out.println("Please select a new priority.");
        System.out.println(priorityAsList());

        int choice = 0;
        choice = input.nextInt();
        input.nextLine();
        if (choice >= 0 && choice < priorityList.length) {
            taskList.changePriority(validChoice, priorityList[choice]);
        } else System.out.println("You have entered an invalid selection. No changes have been made.");

        System.out.println(taskList.getTask(validChoice).toString());
    }

    private static void changeStatus(int validChoice) {
        Scanner input = new Scanner(System.in);
        Task.Status[] priorityList = Task.Status.values();

        System.out.println("Please select a new status.");
        System.out.println(statusAsList());

        int choice = 0;
        choice = input.nextInt();
        input.nextLine();
        if (choice >= 0 && choice < priorityList.length) {
            taskList.changeStatus(validChoice, priorityList[choice]);
        } else System.out.println("You have entered an invalid selection. No changes have been made.");

        System.out.println(taskList.getTask(validChoice).toString());
    }

    private static StringBuilder priorityAsList() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Task.Priority priority : Task.Priority.values()) {
            sb.append(i++).append(". ").append(priority).append("\n");
        }
        return sb;
    }

    private static StringBuilder statusAsList() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Task.Status status : Task.Status.values()) {
            sb.append(i++).append(". ").append(status).append("\n");
        }
        return sb;
    }

    private static boolean isValid(int choice) {
        if (taskList.getCount() == -1) return false;
        if (choice >= 0 && choice < taskList.getCount()) return true;
        else return false; // index out of range
    }

    private static StringBuilder displayTaskList() {
        ArrayList<Task> tl = new ArrayList<>();
        tl = taskList.getTaskList();
        StringBuilder list = new StringBuilder();
        if (!tl.isEmpty()) {
            for (int i = 0; i < tl.size(); i++) {
                list.append(i).append(". ")
                        .append(tl.get(i).getTitle())
                        .append("\n");
            }
            return list;
        } else return new StringBuilder();
    }

}
