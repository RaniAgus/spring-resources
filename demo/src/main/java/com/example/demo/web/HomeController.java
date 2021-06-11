package com.example.demo.web;

import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        // Model contiene los datos que se usan al interactuar con la vista mediante un map
        model.addAttribute("formData", new User()); // key-value
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processFormData(User user, RedirectAttributes attr) {
        // Insert data in database
        // ...
        // Redirige la página junto con su contenido
        attr.addFlashAttribute("user", user);
        return "redirect:/display";
    }

    @RequestMapping("/display")
    public String displayFormData(Model model, User user) {
        // En teoría no hace falta agregar el Model ni pasarle el User, pero creo que es mejor
        model.addAttribute("user", user);
        return "result";
    }
}
