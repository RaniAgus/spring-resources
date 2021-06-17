package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.IEmployeeRepository;
import com.example.projectmanagement.dao.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    IEmployeeRepository employeeRepository;
    IProjectRepository projectRepository;

    @Autowired
    public HomeController(IEmployeeRepository employeeRepository, IProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model) {
        model.addAttribute("stages", projectRepository.projectsStages());
        model.addAttribute("employees", employeeRepository.employeesProjects());

        return "main/home";
    }
}
