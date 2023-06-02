package com.adopcion.FormularioAdopcion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@SpringBootApplication
public class FormularioAdopcion {
    //@Autowired
    //private iAdopcion IAdopcion;
    @Autowired
    private iReportes IReportes;
    ArrayList<Adopcion> adopciones = new ArrayList<>();
    ArrayList<Reporte> reportes = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(FormularioAdopcion.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hola Rest";
    }

    @RequestMapping(value = "/Adopcion", method = RequestMethod.GET)
    public ArrayList<Adopcion> getAdopciones() {
        return adopciones;
    }

    @RequestMapping(value = "/Adopcion", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<String> addAdopcion(@RequestBody Adopcion adopcion) {
        adopciones.add(adopcion);
        return ResponseEntity.ok("Adopcion añadido exitosamente.");
    }

    /*@RequestMapping(value = "/reporte/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> assignReporte(@PathVariable int id, @RequestBody Reportes reporte) {
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getId().equals(id)) {
                adopcion.setReporte(reporte);
                return ResponseEntity.ok("Reporte creado exitosamente.");
            }
        }
        return ResponseEntity.notFound().build();
    }*/

    @GetMapping("/reporte/{id}")
    public Reportes getReporte(@PathVariable("id") int id) {
        System.out.println("Hola");
        Reportes reportes = new Reportes();
        reportes = IReportes.findById(id).get();
        return reportes;
        }
    
    @GetMapping("/reporte")
    public Reportes getReportes() {
        Reportes reportes = new Reportes();
        return reportes;
    }


    @RequestMapping(value = "/reporte", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<String> addReportes(@RequestBody Reportes reportes) {
        Reportes.add(reportes);
        return ResponseEntity.ok("Reporte añadido exitosamente.");
    }
        
    }
        


    

