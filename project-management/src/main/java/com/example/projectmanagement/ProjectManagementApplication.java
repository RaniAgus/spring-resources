package com.example.projectmanagement;

import com.example.projectmanagement.dao.IEmployeeRepository;
import com.example.projectmanagement.dao.IProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {
    IEmployeeRepository employeeRepository;
    IProjectRepository projectRepository;

    @Autowired
    public ProjectManagementApplication(IEmployeeRepository employeeRepository, IProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner() {
//        return args -> {
//            Employee[] employees = {
//                    new Employee("John", "Warton", "warton@gmail.com"),
//                    new Employee("Mike", "Lanister", "lanister@gmail.com"),
//                    new Employee("Steve", "Reeves", "Reeves@gmail.com"),
//
//                    new Employee("Ronald", "Connor", "connor@gmail.com"),
//                    new Employee("Jim", "Salvator", "Sal@gmail.com"),
//                    new Employee("Peter", "Henley", "henley@gmail.com"),
//
//                    new Employee("Richard", "Carson", "carson@gmail.com"),
//                    new Employee("Honor", "Miles", "miles@gmail.com"),
//                    new Employee("Tony", "Roggers", "roggers@gmail.com")
//            };
//
//            Project[] projects = {
//                    new Project(
//                        "Large Production Deploy",
//                        "NOTSTARTED",
//                        "This requires all hands on deck for"
//                            + "the final deployment of the software into production"
//                    ),
//                    new Project(
//                        "New Employee Budget",
//                        "COMPLETED",
//                        "Decide on a new employee bonus budget"
//                            + "for the year and figureout who will be promoted"
//                    ),
//                    new Project(
//                        "Office Reconstruction",
//                        "INPROGRESS",
//                        "The office building in Monroe has "
//                            + "been damaged due to hurricane in the region. This needs to be reconstructed"
//                    ),
//                    new Project(
//                        "Improve Intranet Security",
//                        "INPROGRESS",
//                        "With the recent data hack, the office"
//                            + "security needs to be improved and proper security team needs to be hired for "
//                            + "implementation"
//                    )
//            };
//
//            // Hay que setear ambos lados de la relación a manopla
//            projects[0].setEmployees(new ArrayList<>(Arrays.asList(employees[0], employees[1])));
//            projects[1].setEmployees(new ArrayList<>(Arrays.asList(employees[2])));
//            projects[2].setEmployees(new ArrayList<>(Arrays.asList(employees[0])));
//            projects[3].setEmployees(new ArrayList<>(Arrays.asList(employees[0], employees[2])));
//
//            employees[0].setProjects(new ArrayList<>(Arrays.asList(projects[0], projects[2], projects[3])));
//            employees[1].setProjects(new ArrayList<>(Arrays.asList(projects[0])));
//            employees[2].setProjects(new ArrayList<>(Arrays.asList(projects[1], projects[3])));
//
//            // Luego, hay que guardarlos en la base de datos
//            projectRepository.saveAll(Arrays.asList(projects));
//            employeeRepository.saveAll(Arrays.asList(employees));
//        };
//    }

}
