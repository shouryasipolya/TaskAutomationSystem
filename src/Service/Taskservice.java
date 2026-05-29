package Service;
import Model.Task;

import java.util.*;


public class Taskservice {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addtask(Task task) {
        tasks.add(task);
    }

    public void showTask() {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available");
            return;
        }

        for (Task task : tasks) {

            System.out.println(
                    "ID: " + task.getId() +
                            " | Title: " + task.getTitle() +
                            " | Priority: " + task.getPriority() +
                            " | Deadline: " + task.getDeadline() +
                            " | Status: " + (task.iscompleted() ? "Done" : "Pending")
            );

        }
    }

    public void removetask(int id) {
        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }

    public void markCompleted(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.get(i).setcompleted(true);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
