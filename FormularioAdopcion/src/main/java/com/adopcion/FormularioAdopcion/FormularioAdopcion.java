package com.adopcion.FormularioAdopcion;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class FormularioAdopcion {
    private ArrayList<Adopcion> adopciones = new ArrayList<>();
    private ArrayList<Reporte> reportes = new ArrayList<>();
    private int lastId = 0;

    @Autowired
    private iAdopcion iAdopcion;
    public static void main(String[] args) {
        SpringApplication.run(FormularioAdopcion.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hola Rest";
    }
    
    @GetMapping("/Adopcion")
    public List<Adopcion> buscarAdopciones() {
        Iterable<Adopcion> adopciones = iAdopcion.findAll();
        List<Adopcion> listaAdopciones = new ArrayList<>();
        
        for (Adopcion adopcion : adopciones) {
            listaAdopciones.add(adopcion);
        }
        
        return listaAdopciones;
    }
    
    @PostMapping("/Adopcion")
    public ResponseEntity<String> addAdopcion(@RequestBody Adopcion adopcion) {
        lastId++;
        adopcion.setId(lastId);
        adopciones.add(adopcion);
        iAdopcion.save(adopcion);
        return ResponseEntity.ok("Adopcion añadido exitosamente.");
    }
     

   /*  @GetMapping("/reporte/{id}")
    public Reportes getReporte(@PathVariable("id") int id) {
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getId() == id && adopcion.getReporte() != null) {
                return adopcion.getReporte();
            }
        }
        return null;
    }*/

    @GetMapping("/reporte")
    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    @PostMapping("/reporte")
    public ResponseEntity<String> addReporte(@RequestBody Reporte reporte) {
        reportes.add(reporte);
        return ResponseEntity.ok("Reporte añadido exitosamente.");
    }
}
/*Cambio */