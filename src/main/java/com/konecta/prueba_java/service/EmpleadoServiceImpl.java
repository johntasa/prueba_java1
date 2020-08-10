package com.konecta.prueba_java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.prueba_java.dao.EmpleadoDAO;
import com.konecta.prueba_java.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Override
    public List<Empleado> findAll() {
        List<Empleado> listEmpleados = empleadoDAO.findAll();
        return listEmpleados;
    }

    @Override
    public Empleado findById(int id) {
        Empleado empleado = empleadoDAO.findById(id);
        return empleado;
    }

    @Override
    public void save(Empleado empleado) {
        empleadoDAO.save(empleado);
    }

    @Override
    public void deleteById(int id) {
        empleadoDAO.deleteById(id);
    }
}