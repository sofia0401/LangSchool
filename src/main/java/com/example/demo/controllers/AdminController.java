package com.example.demo.controllers;


import com.example.demo.models.Task;
import com.example.demo.services.TaskDAO;
import com.example.demo.services.UserDAO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserDAO userDAO;
    private final TaskDAO taskDAO;
    @Autowired
    public AdminController(UserDAO userDAO, TaskDAO taskDAO) {
        this.userDAO = userDAO;
        this.taskDAO = taskDAO;
    }


    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("us", userDAO.readAll());
        return "user/admin/users";
    }

    @GetMapping("/alltasks")
    public String getAllTasks(Model model) {
        model.addAttribute("ts", taskDAO.readAll());
        return "user/admin/tasks";
    }

    @GetMapping("/add")
    public String newTask(@ModelAttribute("task") Task task) {
        return "user/admin/addTask";
    }

    @SneakyThrows
    @PostMapping("/added")
    public String addTask(@RequestParam String ques, @RequestParam String ans, @RequestParam String type,Model model) {
//        taskDAO.add(ques,ans,type);
//        Task task = new Task();
//        task.setQues(ques);
//        task.setAns(ans);
//        task.setType(type);
        taskDAO.add(ques, ans, type);
        model.addAttribute("Status", "added");
        return "redirect:/admin/add";
//        return "user/admin/addTask";
    }
    @PostMapping("/deleted")
    public String delete(@RequestParam Long taskID) {
        taskDAO.delete(taskID);
        return "redirect:/admin/alltasks";
    }

    @GetMapping("/tasks/filteredById")
    public String showTasksFilteredById(Model model) {
        model.addAttribute("ts", taskDAO.filteredById());
        return "user/admin/tasks";
    }
    @GetMapping("/tasks/filteredByType")
    public String showTasksFilteredByType(Model model) {
        model.addAttribute("ts", taskDAO.filteredByType());
        return "user/admin/tasks";
    }

    @GetMapping("/users/filteredById")
    public String showUsersFilteredById(Model model) {
        model.addAttribute("us", userDAO.filteredById());
        return "user/admin/users";
    }

}

