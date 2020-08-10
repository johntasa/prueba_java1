package com.konecta.prueba_java.dao;

import java.util.List;

import com.konecta.prueba_java.entity.Solicitud;


public interface SolicitudDAO {

    public List<Solicitud> findAll();

    public Solicitud findById(int id);

    public void save(Solicitud solicitud);

    public void deleteById(int id);
}