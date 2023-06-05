package com.perreria.backend.controller;

import com.perreria.backend.model.Seguimiento;
import com.perreria.backend.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3001")
public class UserController {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @PostMapping("/seguimiento")
    Seguimiento newSeguimiento(@RequestBody Seguimiento newSeguimiento){
        return seguimientoRepository.save(newSeguimiento);
    }
    @GetMapping("/seguimientos")
    List<Seguimiento> getAllSeguimientos(){
        return seguimientoRepository.findAll();
    }


}
