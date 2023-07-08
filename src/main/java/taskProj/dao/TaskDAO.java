package taskProj.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.PostMapping;
import taskProj.model.Task;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {
    private static int TASK_COUNT;
    private List<Task> tasks;

    {
        tasks = new ArrayList<>();

        tasks.add(new Task(++TASK_COUNT, "Test1", "Test Task1"));
        tasks.add(new Task(++TASK_COUNT, "Test2", "Test Task2"));
        tasks.add(new Task(++TASK_COUNT, "Test3", "Test Task3"));
    }



    public List<Task> showAllTasks() {
        return tasks;
    }

    public Task showSomeTask(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findAny().orElse(null);
    }

    public void createNewTask(Task task) {
        task.setId(++TASK_COUNT);
        tasks.add(task);
    }

    public void updateTask(int id, Task updateTask) {
        Task taskToBeUpdate = showSomeTask(id);

        taskToBeUpdate.setTaskName(updateTask.getTaskName());
        taskToBeUpdate.setTaskText(updateTask.getTaskText());
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
