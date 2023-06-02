package com.perreria.backend.controller;

import com.perreria.backend.model.Seguimiento;
import com.perreria.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/seguimiento")
    Seguimiento newSeguimiento(@RequestBody Seguimiento newSeguimiento){

        return userRepository.save(newSeguimiento);
    }

    @GetMapping("/seguimientos")
    List<Seguimiento> getAllSeguimientos(){
        return userRepository.findAll();
    }
}
