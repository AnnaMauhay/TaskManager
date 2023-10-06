package futurewomen;

import java.util.Scanner;

/**
 *
 * This class will handle displaying options, receiving user input, and managing the application's user interface.
 */
public class UserInterface {
    public static void run(){
        StringBuilder header = new StringBuilder("============================");
        header.append("\n=    Hello and welcome!    =");
        header.append("\n= I am your Micro Manager! =");
        header.append("\n============================\n");
        System.out.println(header.toString());

        Task task = new Task("Create Initial Structure",
                "Create all classes and methods as per specifications.",
                Task.Priority.LOW, Task.Status.IN_PROGRESS);
        TaskList taskList = new TaskList(task);


        Scanner input = new Scanner(System.in);
        int choice = 0;
        String answer = "";
        while (choice!=9){
            System.out.println("\nWhat would you like to do?"
                    + "\n1. Create a task."
                    + "\n2. View task."
                    + "\n3. Update task."
                    + "\n4. Delete task."
                    + "\n9. Exit.");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("You want to create a task.");

                    break;
                case 2:
                    System.out.println("You want to view a task.");
                    //System.out.println("Which of the tasks would you like to view?");
                    //TODO: show list of task titles. Display a message if tasklist is empty.
                    break;
                case 3:
                    System.out.println("You wan to update a task");
                    //TODO: show list of task titles. Display a message if tasklist is empty.
                    break;
                case 4:
                    System.out.println("You wan to delete a task");
                    //TODO: show list of task titles. Display a message if tasklist is empty.
                    break;
            }
        }

        System.out.println(taskList.view(0));
    }
}
