package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.IProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    IProjectRepository projectRepository;

    @Autowired // Spring inyecta la dependencia
    public ProjectController(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project) {
        projectRepository.save(project);

        // Se usan los redirects para evitar que entren formularios duplicados al hacer click en submit varias veces
        return "redirect:/projects";
    }
}
