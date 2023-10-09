package futurewomen;

import java.util.ArrayList;

/*
This class will manage the task list, including adding, viewing, updating, and deleting tasks.
 */
public class TaskList implements Taskable {
    private ArrayList<Task> taskList;
    //TODO: Save taskList in a file.
    public void add(Task task) {
        if (task!=null) this.taskList.add(task);
    }
    public Task getTask(int index) {    //TODO: consider throws NPE, and handle potential ArrayIndexOutOfBounds error.
        return taskList.get(index);
    }
    public ArrayList<Task> getTaskList(){
        return this.taskList;
    }
    public int getCount() {
        return (taskList.isEmpty() ? -1 : taskList.size());
    }
    public void changeDescription(int index, String details) {
        taskList.get(index).setDescription(details);
    }

    public void changeTitle(int index, String title) {
        taskList.get(index).setTitle(title);
    }
    public void changeStatus(int index, Task.Status status) {
        taskList.get(index).setStatus(status);
    }
    public void changePriority(int index, Task.Priority priority) {
        taskList.get(index).setPriority(priority);
    }

    public void delete(int index) {
        this.taskList.remove(index);
    }

    @Override
    public String toString() {
        if (!taskList.isEmpty()) {
            StringBuilder list = new StringBuilder();
            for (int i = 0; i < taskList.size(); i++) {
                list.append(i).append(". ")
                        .append(taskList.get(i).getTitle().toString())
                        .append("\n");
            }
            return list.toString();
        } else return "---- EMPTY ----";
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(Task task) {
        this.taskList = new ArrayList<>();
        this.taskList.add(task);
    }
}
