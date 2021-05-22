package com.example.demo.controllers;

import com.example.demo.services.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller

public class UserController {
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/start")
    public String defaultAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
        if (myRole.equals(admin)) {
            return "redirect:/admin/users";
        }
        else
        return "redirect:/start/noun";
    }

//    @RequestMapping("/start")
//    public String defaultAfterLogin(HttpServletRequest request) {
//        if (request.isUserInRole("ADMIN")) {
//            return "redirect:/admin/users";
//        }
//        return "redirect:/start/noun";
//    }
//    @GetMapping("/start")
//    public String index2(Authentication authentication, Model model) {
//        model.addAttribute("user_login", "Добро пожаловать, " + authentication.getName());
//        return "user/hello";
//    }

    @GetMapping("/signUp")
    public String index() {
        return "user/signUp";
    }

    @PostMapping("/signuperror")
    public String SignUp(@RequestParam String login, String password, String password2, String email, Model model) {
        if (userDAO.loadUserByEmail(email) != null) {
            model.addAttribute("Status", "email_exists");
            return "user/signUp";
        } else {
            if (userDAO.loadUserByUsername(login) != null) {
                model.addAttribute("Status", "user_exists");
                return "user/signUp";
            } else {
                if (!password.equals(password2)) {
                    model.addAttribute("Status", "password!=password2");
                    return "user/signUp";
                } else {
                    userDAO.create(login, password, email);
                    return "redirect:/start";
                }
            }
        }
    }
}


