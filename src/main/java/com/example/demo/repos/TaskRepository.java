package com.example.demo.repos;

import com.example.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Task getTaskByAns(String a);
    List<Task> findAllByOrderByIdAsc();
    List<Task> findAllByOrderByTypeAsc();

    List<Task> getAllByType(String t);
}
