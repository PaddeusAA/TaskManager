package taskProj.controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import taskProj.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import taskProj.model.Task;

import javax.validation.Valid;

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

    @GetMapping("/newTask")
    public String newTask(Model model){
        model.addAttribute("task" , new Task());
        return "tm/newTask";
    }

    @PostMapping()
    public String createTask(@ModelAttribute("task") @Valid Task task,
                             BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "tm/newTask";

        taskDAO.createNewTask(task);
        return "redirect:/tm";
    }

    @GetMapping("/{id}/editSomeTask")
    public String editSomeTask(Model model, @PathVariable("id") int id) {
        model.addAttribute("tasks", taskDAO.showSomeTask(id));
        return "tm/editSomeTask";
    }

    @PatchMapping("/{id}")
    public String updateTask(@ModelAttribute("task") @Valid Task task,
                             BindingResult bindingResult, @PathVariable("id") int id) {

        if(bindingResult.hasErrors())
            return "tm/editSomeTask";

        taskDAO.updateTask(id, task);
        return "redirect:/tm";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskDAO.deleteTask(id);
        return "redirect:/tm";
    }

}
