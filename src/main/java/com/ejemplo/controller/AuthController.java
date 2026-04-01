package com.ejemplo.controller;

import com.ejemplo.modelo.User;
import com.ejemplo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales inválidas. Por favor intente de nuevo.");
        }
        return "login"; // JSP en /WEB-INF/views/login.jsp
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // JSP en /WEB-INF/views/register.jsp
    }

    @PostMapping("/register")
    public String register(User user, Model model) {
        if (userService.existeEmail(user.getEmail())) {
            model.addAttribute("error", "El correo ya está registrado.");
            model.addAttribute("user", user);
            return "register";
        }

        user.setRol("CLIENT"); // Forzamos rol CLIENT para registros públicos
        userService.registrar(user);
        return "redirect:/login?msg=registrado";
    }
}
