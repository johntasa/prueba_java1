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

import com.konecta.prueba_java.entity.Solicitud;
import com.konecta.prueba_java.service.SolicitudService;

@RestController
@RequestMapping("/pruebajava_konecta")

public class SolicitudRestController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/solicitudes")
    public List<Solicitud> findAll(){
        return solicitudService.findAll();
    }

    @GetMapping("/solicitudes/{solicitudId}")
    public Solicitud getSolicitud(@PathVariable int solicitudId){
        Solicitud solicitud = solicitudService.findById(solicitudId);
        if(solicitud == null) {
            throw new RuntimeException("Solicitud no encontrada -" + solicitudId);
        }
        return solicitud;
    }

    @PostMapping("/solicitudes")
    public Solicitud addSolicitud(@RequestBody Solicitud solicitud) {
        solicitud.setId(0);
        solicitudService.save(solicitud);
        return solicitud;
    }

    @PutMapping("/solicitudes")
    public Solicitud updateSolicitud(@RequestBody Solicitud solicitud) {
        solicitudService.save(solicitud);
        return solicitud;
    }

    @DeleteMapping("solicitudes/{solicitudId}")
    public String deleteSolicitud(@PathVariable int solicitudId) {
        Solicitud solicitud = solicitudService.findById(solicitudId);
        if(solicitud == null) {
            throw new RuntimeException("Solicitud no encontrada -" + solicitudId);
        }
        solicitudService.deleteById(solicitudId);
        return "Deleted solicitud id - " + solicitudId;
    }
}