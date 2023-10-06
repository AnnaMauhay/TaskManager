package futurewomen;
/*
This class will represent a task with attributes like title, description, priority, and status.
Tasks will implement an interface called Taskable to define methods for task management.
 */
public class Task implements Taskable{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String desciption;
    private Priority priority;
    private Status status;

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    public enum Status {
        TO_DO,
        IN_PROGRESS,
        COMPLETED
    }

    public Task(String title, String desciption, Priority priority, Status status) {
        this.title = title;
        this.desciption = desciption;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Title: " + this.title
                + "\nDescription: " + this.desciption
                + "\nPriority: " + this.priority
                + "\nStatus: " + this.status;
    }
}
