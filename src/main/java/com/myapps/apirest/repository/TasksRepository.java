package com.myapps.apirest.repository;

import java.util.List;

import com.myapps.apirest.model.Tasks.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    List<Tasks> findByUser_idUser(int idUser);

}
