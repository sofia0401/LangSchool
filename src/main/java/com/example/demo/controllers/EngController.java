package com.example.demo.controllers;

import com.example.demo.services.TaskDAO;
import com.example.demo.services.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/start")
public class EngController {

    private final UserDAO userDAO;
    private final TaskDAO taskDAO;

    @Autowired
    public EngController(UserDAO userDAO, TaskDAO taskDAO) {
        this.userDAO = userDAO;
        this.taskDAO = taskDAO;
    }


    @GetMapping("/verb")
    public String showVerb() {
        return "user/english/verbs";
    }

    @GetMapping("/noun")
    public String showNoun() {
        return "user/english/nouns";
    }

    @GetMapping("/adjective")
    public String showAdj() {
        return "user/english/adjs";
    }

    @GetMapping("/noun/test")
    public String getQuestionsNoun(Model model) {
        model.addAttribute("qs", taskDAO.loadTaskByType("noun"));
        return "user/english/nountest";
    }
    @GetMapping("/adjective/test")
    public String getQuestionsAdj(Model model) {
        model.addAttribute("qs", taskDAO.loadTaskByType("adjective"));
        return "user/english/adjtest";
    }
    @GetMapping("/verb/test")
    public String getQuestionsVerb(Model model) {
        model.addAttribute("qs", taskDAO.loadTaskByType("verb"));
        return "user/english/verbtest";
    }

    @PostMapping("/noun/testchecked")
    public String getChecked(@RequestParam String a1, String a2, String a3, String a4, String a5, String a6,
                             String a7, Model model) {
        if (taskDAO.loadTask(a1) != null)
            model.addAttribute("Status1", "correct");
        else model.addAttribute("Status1","wrong");
        if (taskDAO.loadTask(a2) != null)
            model.addAttribute("Status2", "correct");
        else model.addAttribute("Status2","wrong");
        if (taskDAO.loadTask(a3) != null)
            model.addAttribute("Status3", "correct");
        else model.addAttribute("Status3","wrong");
        if (taskDAO.loadTask(a4) != null)
            model.addAttribute("Status4", "correct");
        else model.addAttribute("Status4","wrong");
        if (taskDAO.loadTask(a5) != null)
            model.addAttribute("Status5", "correct");
        else model.addAttribute("Status5","wrong");
        if (taskDAO.loadTask(a6) != null)
            model.addAttribute("Status6", "correct");
        else model.addAttribute("Status6","wrong");
        if (taskDAO.loadTask(a7) != null)
            model.addAttribute("Status7", "correct");
        else model.addAttribute("Status7","wrong");
        model.addAttribute("qs", taskDAO.loadTaskByType("noun"));

        return "user/english/nountest";
    }

    @PostMapping("/adjective/testchecked")
    public String getChecked2(@RequestParam String a1, String a2, String a3, String a4, String a5, String a6,
                             String a7, Model model) {
        if (taskDAO.loadTask(a1) != null)
            model.addAttribute("Status1", "correct");
        else model.addAttribute("Status1","wrong");
        if (taskDAO.loadTask(a2) != null)
            model.addAttribute("Status2", "correct");
        else model.addAttribute("Status2","wrong");
        if (taskDAO.loadTask(a3) != null)
            model.addAttribute("Status3", "correct");
        else model.addAttribute("Status3","wrong");
        if (taskDAO.loadTask(a4) != null)
            model.addAttribute("Status4", "correct");
        else model.addAttribute("Status4","wrong");
        if (taskDAO.loadTask(a5) != null)
            model.addAttribute("Status5", "correct");
        else model.addAttribute("Status5","wrong");
        if (taskDAO.loadTask(a6) != null)
            model.addAttribute("Status6", "correct");
        else model.addAttribute("Status6","wrong");
        if (taskDAO.loadTask(a7) != null)
            model.addAttribute("Status7", "correct");
        else model.addAttribute("Status7","wrong");
        model.addAttribute("qs", taskDAO.loadTaskByType("adjective"));

        return "user/english/adjtest";
    }
    @PostMapping("/verb/testchecked")
    public String getChecked3(@RequestParam String a1, String a2, String a3, String a4, String a5, String a6,
                              String a7, Model model) {
        if (taskDAO.loadTask(a1) != null)
            model.addAttribute("Status1", "correct");
        else model.addAttribute("Status1","wrong");
        if (taskDAO.loadTask(a2) != null)
            model.addAttribute("Status2", "correct");
        else model.addAttribute("Status2","wrong");
        if (taskDAO.loadTask(a3) != null)
            model.addAttribute("Status3", "correct");
        else model.addAttribute("Status3","wrong");
        if (taskDAO.loadTask(a4) != null)
            model.addAttribute("Status4", "correct");
        else model.addAttribute("Status4","wrong");
        if (taskDAO.loadTask(a5) != null)
            model.addAttribute("Status5", "correct");
        else model.addAttribute("Status5","wrong");
        if (taskDAO.loadTask(a6) != null)
            model.addAttribute("Status6", "correct");
        else model.addAttribute("Status6","wrong");
        if (taskDAO.loadTask(a7) != null)
            model.addAttribute("Status7", "correct");
        else model.addAttribute("Status7","wrong");
        model.addAttribute("qs", taskDAO.loadTaskByType("verb"));

        return "user/english/verbtest";
    }
}

