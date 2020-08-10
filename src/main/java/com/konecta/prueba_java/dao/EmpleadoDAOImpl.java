package com.konecta.prueba_java.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.konecta.prueba_java.entity.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Empleado> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Empleado> theQuery = currentSession.createQuery("from empleado", Empleado.class);
        List<Empleado> empleados = theQuery.getResultList();
        return empleados;
    }

    @Override
    public Empleado findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Empleado empleado = currentSession.get(Empleado.class, id);
        return empleado;
    }

    @Override
    public void save(Empleado empleado) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(empleado);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Empleado> theQuery = currentSession.createQuery("delete from empleado where id=:idEmpleado");
        theQuery.setParameter("idEmpleado", id);
        theQuery.executeUpdate();
    }
}