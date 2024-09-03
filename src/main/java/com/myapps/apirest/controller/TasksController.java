package com.myapps.apirest.controller;

import java.util.List;

import com.myapps.apirest.model.Tasks.Tasks;
import com.myapps.apirest.model.Tasks.TasksDTO;
import com.myapps.apirest.service.TasksService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TasksController {

    private final TasksService tasksService;

    @GetMapping
    public List<Tasks> getTasksById(int idUser) {
        return tasksService.getTasks(idUser);
    }

    @PostMapping
    public Tasks addTask(@RequestBody TasksDTO taskDTO) {
        return tasksService.createTasks(taskDTO);
    }

    @PutMapping("/{idTask}")
    public Tasks updateTask(@PathVariable int idTask, @RequestBody Tasks taskData) {
        return tasksService.updateTasks(idTask, taskData);
    }

    @DeleteMapping("/{idTask}") 
    public void deleteTask(@PathVariable int idTask) {
        tasksService.deleteTask(idTask);
    }
}
