package futurewomen;

import java.util.ArrayList;

/*
This class will represent a task with attributes like title, description, priority, and status.
Tasks will implement an interface called Taskable to define methods for task management.
 */
public class Task {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private String description;
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

    public Task(String title, String description, Priority priority, Status status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.priority = Priority.LOW;
        this.status = Status.TO_DO;
    }

    @Override
    public String toString() {
        return "Title: " + this.title
                + "\nDescription: " + this.description
                + "\nPriority: " + this.priority
                + "\nStatus: " + this.status;
    }
}
