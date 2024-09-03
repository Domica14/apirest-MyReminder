package com.myapps.apirest.model.Tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksDTO {
    private String taskName;
    private Status status;
    private int idUser;
}
