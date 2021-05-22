package com.example.demo.services;
import com.example.demo.models.Task;
import com.example.demo.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TaskDAO {
    private TaskRepository taskRepo;

    @Autowired
    public TaskDAO(TaskRepository taskRepo) {
        this.taskRepo=taskRepo;
    }
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public void add(String ques,String ans,String type) {
        Task task = new Task();
        task.setQues(ques);
        task.setAns(ans);
        task.setType(type);
        taskRepo.save(task);
    }

    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

    public Task loadTask(String a){
        return taskRepo.getTaskByAns(a);
    }

    public List<Task> readAll() {
        return taskRepo.findAll();
    }

    public List<Task> loadTaskByType(String t) {
        return taskRepo.getAllByType(t);
    }

    public List<Task> filteredById() {
        return taskRepo.findAllByOrderByIdAsc();
    }

    public List<Task> filteredByType() {
        return taskRepo.findAllByOrderByTypeAsc();
    }

}