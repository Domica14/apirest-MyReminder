package com.myapps.apirest.service;

import java.util.List;

import com.myapps.apirest.model.Tasks.Tasks;
import com.myapps.apirest.model.Tasks.TasksDTO;
import com.myapps.apirest.repository.TasksRepository;
import org.springframework.stereotype.Service;

import com.myapps.apirest.model.User;
import com.myapps.apirest.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final UserRepository userRepository;

    public List<Tasks> getTasks(int idUser) {
        return tasksRepository.findByUser_idUser(idUser);
    }

    public Tasks createTasks(TasksDTO taskDTO) {

        //Se obtiene el user que tiene el id ingresado
        User user = userRepository.findById(taskDTO.getIdUser()).orElseThrow();

        //Se crea el objeto task donde se le pasa el objeto user recuperado
        Tasks task = new Tasks();
        task.setTaskName(taskDTO.getTaskName());
        task.setStatus(taskDTO.getStatus());
        task.setUser(user);

        return tasksRepository.save(task);
    }

    public Tasks updateTasks(int idTask, Tasks tasks) {

        //Se busca el task que contenga el id 
        Tasks tasksToUpdate = tasksRepository.findById(idTask).orElseThrow();

        tasksToUpdate.setStatus(tasks.getStatus());
        tasksToUpdate.setTaskName(tasks.getTaskName());
        
        return tasksRepository.save(tasksToUpdate);
    }

    public void deleteTask(int idTask) {
        tasksRepository.deleteById(idTask);
    }
}
