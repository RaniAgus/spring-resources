package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.IProjectRepository;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired // Spring inyecta la dependencia
    IProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project) {
        projectRepository.save(project);

        // Se usan los redirects para evitar que entren formularios duplicados al hacer click en submit varias veces
        return "redirect:/projects/new";
    }
}
