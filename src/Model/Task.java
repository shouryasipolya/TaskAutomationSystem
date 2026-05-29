package Model;

public class Task {
    private int id;
    private String Title;
    private String priority;
    private String deadline;
    private boolean iscompleted;

    public Task(int id, String Title, String priority, String deadline) {
        this.id = id;
        this.Title = Title;
        this.priority = priority;
        this.deadline = deadline;
        iscompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public String getTitle() {
        return Title;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean iscompleted() {
        return iscompleted;
    }

    public void setcompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }
}
