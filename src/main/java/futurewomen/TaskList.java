package futurewomen;

import java.util.ArrayList;

/*
This class will manage the task list, including adding, viewing, updating, and deleting tasks.
 */
public class TaskList {
    private ArrayList<Task> taskList;
    public void add(Task task){
        this.taskList.add(task);
    }
    //TODO:
    public String view(int index){
        return taskList.get(index).toString();
    }
    //TODO
    public void editDetails(String details){

    }
    //TODO
    public void editTitle(String title){

    }
    //TODO
    public void editStatus(Task.Status status){

    }
    //TODO
    public void editPriority(Task.Priority priority){

    }
    //TODO
    public void delete(int index){

    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    public TaskList(Task task) {
        this.taskList = new ArrayList<>();
        this.taskList.add(task);
    }
}
