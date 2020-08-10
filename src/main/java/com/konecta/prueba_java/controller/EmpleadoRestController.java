package com.konecta.prueba_java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konecta.prueba_java.entity.Empleado;
import com.konecta.prueba_java.service.EmpleadoService;


@RestController
@RequestMapping("/pruebajava_konecta")

public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> findAll(){
        return empleadoService.findAll();
    }

    @GetMapping("/empleados/{empleadoId}")
    public Empleado getEmpleado(@PathVariable int empleadoId){
        Empleado empleado = empleadoService.findById(empleadoId);
        if(empleado == null) {
            throw new RuntimeException("Empleado no encontrado -" + empleadoId);
        }
        return empleado;
    }

    @PostMapping("/empleados")
    public Empleado addEmpleado(@RequestBody Empleado empleado) {
        empleado.setId(0);
        empleadoService.save(empleado);
        return empleado;
    }

    @PutMapping("/empleados")
    public Empleado updateEmpleado(@RequestBody Empleado empleado) {
        empleadoService.save(empleado);
        return empleado;
    }

    @DeleteMapping("empleados/{empleadoId}")
    public String deleteEmpleado(@PathVariable int empleadoId) {
        Empleado empleado = empleadoService.findById(empleadoId);
        if(empleado == null) {
            throw new RuntimeException("Empleado no encontrado -" + empleadoId);
        }
        empleadoService.deleteById(empleadoId);
        return "Deleted empleado id - " + empleadoId;
    }
}