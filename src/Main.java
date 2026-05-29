import Model.Task;
import Model.user;
import Service.Taskservice;
import Service.userservice;

import java.util.Scanner;

public class Main {

    static userservice userService = new userservice();
    static Taskservice taskService = new Taskservice();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        user currentUser = null;

        while (true) {

            while (currentUser == null) {

                System.out.println("\n===== TASK AUTOMATION SYSTEM =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        userService.register(username, password);
                        break;

                    case 2:

                        System.out.print("Enter Username: ");
                        String loginUsername = sc.nextLine();

                        System.out.print("Enter Password: ");
                        String loginPassword = sc.nextLine();

                        currentUser = userService.login(loginUsername, loginPassword);

                        if (currentUser != null) {
                            System.out.println("Login Successful!");
                        } else {
                            System.out.println("Invalid Credentials!");
                        }

                        break;

                    case 0:
                        System.out.println("System Closed.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

            while (currentUser != null) {

                System.out.println("\n===== TASK MENU =====");
                System.out.println("1. Add Task");
                System.out.println("2. Show Tasks");
                System.out.println("3. Remove Task");
                System.out.println("4. Mark Completed");
                System.out.println("5. Logout");
                System.out.println("0. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Priority: ");
                        String priority = sc.nextLine();

                        System.out.print("Enter Deadline: ");
                        String deadline = sc.nextLine();

                        Task task = new Task(id, title, priority, deadline);

                        taskService.addtask(task);
                        System.out.println("Task Added");
                        break;

                    case 2:

                        taskService.showTask();
                        break;

                    case 3:

                        System.out.print("Enter Task ID to Remove: ");
                        int removeId = sc.nextInt();

                        taskService.removetask(removeId);
                        System.out.println("Task Removed");
                        break;

                    case 4:

                        System.out.print("Enter Task ID to Mark Complete: ");
                        int completeId = sc.nextInt();

                        taskService.markCompleted(completeId);
                        System.out.println("Completed");
                        break;

                    case 5:

                        currentUser = null;
                        System.out.println("Logged Out Successfully.");
                        break;

                    case 0:

                        System.out.println("System Closed.");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice!");
                }
            }
        }
    }
}