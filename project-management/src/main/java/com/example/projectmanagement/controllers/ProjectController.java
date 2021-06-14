package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.IEmployeeRepository;
import com.example.projectmanagement.dao.IProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    IProjectRepository projectRepository;
    IEmployeeRepository employeeRepository;

    @Autowired // Spring inyecta la dependencia
    public ProjectController(IProjectRepository projectRepository, IEmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String listProjects(Model model) {
        // Es un query a la DB para obtener los proyectos
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("employees", employeeRepository.findAll());
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project) {
        projectRepository.save(project);

        // En las relaciones "varios a varios" Spring es lo suficientemente inteligente para agregarlo en la tabla
        // intermedia

        // Se usan los redirects para evitar que entren formularios duplicados al hacer click en submit varias veces
        return "redirect:/projects";
    }
}
