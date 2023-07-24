package taskProj.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class Task {


    private int id;

    @Max(value = 30 ,message = "Name should be between up to 30 characters")
    @NotEmpty(message = "Name should not be empty")
    private String taskName;

    @NotEmpty(message = "Text should not be empty")
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
