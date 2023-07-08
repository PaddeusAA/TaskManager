package taskProj.controller;

import org.springframework.web.bind.annotation.*;
import taskProj.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import taskProj.model.Task;

@Controller
@RequestMapping("/tm")
public class TaskController {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public String showAllTasks(Model model) {
        model.addAttribute("tasks", taskDAO.showAllTasks());
        return "tm/showAllTasks";
    }

    @GetMapping("/{id}")
    public String showSomeTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("tasks", taskDAO.showSomeTask(id));
        return "tm/showSomeTasks";
    }

/*
    @GetMapping("/newTask")
    public String newTask(@ModelAttribute("task") Task task){
        return "tm/newTask";
    }
 */

    @GetMapping("/newTask")
    public String newTask(Model model){
        model.addAttribute("task" , new Task());
        return "tm/newTask";
    }

    @PostMapping()
    public String createTask(@ModelAttribute("task") Task task) {
        taskDAO.createNewTask(task);
        return "redirect:/tm";
    }

    @GetMapping("/{id}/editSomeTask")
    public String editSomeTask(Model model, @PathVariable("id") int id) {
        model.addAttribute("tasks", taskDAO.showSomeTask(id));
        return "tm/editSomeTask";
    }

    @PatchMapping("/{id}")
    public String updateTask(@ModelAttribute("task") Task task,
                             @PathVariable("id") int id) {
        taskDAO.updateTask(id, task);
        return "redirect:/tm";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskDAO.deleteTask(id);
        return "redirect:/tm";
    }
}
