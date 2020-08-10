package com.konecta.prueba_java.dao;

import java.util.List;

import com.konecta.prueba_java.entity.Empleado;


public interface EmpleadoDAO {

    public List<Empleado> findAll();

    public Empleado findById(int id);

    public void save(Empleado empleado);

    public void deleteById(int id);
}