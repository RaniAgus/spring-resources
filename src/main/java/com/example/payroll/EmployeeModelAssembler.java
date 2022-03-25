package com.example.payroll;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

  @Override
  public EntityModel<Employee> toModel(Employee employee) {

    // Los links nos permiten saber cómo interactuar con este servicio
    return EntityModel.of(employee,
        // Esto agrega un link hacia el mismo empleado (key = "self")
        linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
        // Esto agrega un link hacia la colección completa de empleados (key = "employees")
        linkTo(methodOn(EmployeeController.class).all()).withRel("employees")
    );
  }
}