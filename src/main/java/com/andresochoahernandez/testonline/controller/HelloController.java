package com.andresochoahernandez.testonline.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(Principal principal)
    {
        return "Hello " + principal.getName();
    }

    @PreAuthorize("hasAuthority('SCOPE_DOCENTE')")
    @GetMapping("/docente")
    public String docente()
    {
        return "Hello docente!";
    }

    @PreAuthorize("hasAuthority('SCOPE_STUDENTE')")
    @GetMapping("/studente")
    public String studente()
    {
        return "Hello studente!";
    }
}
