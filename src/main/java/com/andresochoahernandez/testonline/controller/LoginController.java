package com.andresochoahernandez.testonline.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/")
    public String index(Authentication auth)
    {
        if(auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_DOCENTE")))
        {
            //TODO: return the professors homepage
            System.out.println("DOCENTE");
        }
        else
        {
            //TODO: return the students homepage
            System.out.println("STUDENTE");
        }

        return "logout";
    }

    @GetMapping("/login-error")
    public String loginError(Model model)
    {
        model.addAttribute("IncorrectCredentials", "Credenziali non valide");
        return "login";
    }
}
