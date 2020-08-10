package com.konecta.prueba_java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.prueba_java.dao.SolicitudDAO;
import com.konecta.prueba_java.entity.Solicitud;


@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudDAO solicitudDAO;

    @Override
    public List<Solicitud> findAll() {
        List<Solicitud> listSolicitudes = solicitudDAO.findAll();
        return listSolicitudes;
    }

    @Override
    public Solicitud findById(int id) {
        Solicitud solicitud = solicitudDAO.findById(id);
        return solicitud;
    }

    @Override
    public void save(Solicitud solicitud) {
        solicitudDAO.save(solicitud);
    }

    @Override
    public void deleteById(int id) {
        solicitudDAO.deleteById(id);
    }
}