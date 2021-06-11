package com.example.projectmanagement.dao;

import com.example.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

// CrudRepository es una interfaz que tiene un montón de métodos que interactúan con la DB
public interface IProjectRepository extends CrudRepository<Project, Long> { // <Tipo de la tabla, Tipo del ID>
}
