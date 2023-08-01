package taskProj.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import taskProj.model.Task;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class TaskDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> showAllTasks() {
        return jdbcTemplate.query("SELECT * FROM task", new BeanPropertyRowMapper<>(Task.class));
    }

    public Task showSomeTask(int id) {
        return jdbcTemplate.query("SELECT * FROM task WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Task.class))
                .stream().findAny().orElse(null);
    }

    public void createNewTask(Task task) {
        jdbcTemplate.update("INSERT INTO task(taskname, tasktext) VALUES (?, ?)",
                task.getTaskName(), task.getTaskText());
    }

    public void updateTask(int id, Task updateTask) {
        jdbcTemplate.update("UPDATE  task SET taskName=?, taskText=? WHERE id=? ",
                updateTask.getTaskName(), updateTask.getTaskText(), id);
    }

    public void deleteTask(int id) {
        jdbcTemplate.update("DELETE FROM task WHERE id=?", id);
    }
}
