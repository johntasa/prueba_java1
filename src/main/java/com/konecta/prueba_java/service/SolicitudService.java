package com.konecta.prueba_java.service;

import java.util.List;

import com.konecta.prueba_java.entity.Solicitud;


public interface SolicitudService {

    public List<Solicitud> findAll();

    public Solicitud findById(int id);

    public void save(Solicitud solicitud);

    public void deleteById(int id);
}