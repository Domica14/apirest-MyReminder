package com.myapps.apirest.model.Tasks;


import com.fasterxml.jackson.annotation.JsonBackReference;

import com.myapps.apirest.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tasks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTask;
    
    @Basic
    @Nonnull
    private String taskName;
    
    @Enumerated(EnumType.STRING)
    @Nonnull
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    @JsonBackReference          //Evita la recursion infinita desde la parte que tiene la fk
    private User user;
}
