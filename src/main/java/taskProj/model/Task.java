package taskProj.model;

public class Task {

    private int id;
    private String taskName;
    private String taskText;

    public Task(){}

    public Task(int id, String taskName, String taskText) {
        this.id = id;
        this.taskName = taskName;
        this.taskText = taskText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }
}
