package com.konecta.prueba_java.service;

import com.konecta.prueba_java.entity.Empleado;

import java.util.List;


public interface EmpleadoService {

    public List<Empleado> findAll();

    public Empleado findById(int id);

    public void save(Empleado empleado);

    public void deleteById(int id);
}
