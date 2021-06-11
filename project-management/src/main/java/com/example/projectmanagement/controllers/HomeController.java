package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.IProjectRepository;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    IProjectRepository projectRepository;

    @Autowired
    public HomeController(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model) {
        // Es un query a la DB para obtener los proyectos
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "home";
    }
}
