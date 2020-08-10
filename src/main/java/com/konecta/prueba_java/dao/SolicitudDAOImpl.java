package com.konecta.prueba_java.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.konecta.prueba_java.entity.Empleado;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.konecta.prueba_java.entity.Solicitud;

@Repository
public class SolicitudDAOImpl implements SolicitudDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Solicitud> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Solicitud> theQuery = currentSession.createQuery("from solicitud", Solicitud.class);
        List<Solicitud> solicitudes = theQuery.getResultList();
        return solicitudes;
    }

    @Override
    public Solicitud findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Solicitud solicitud = currentSession.get(Solicitud.class, id);
        return solicitud;
    }

    @Override
    public void save(Solicitud solicitud) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(solicitud);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Solicitud> theQuery = currentSession.createQuery("delete from solicitud where id=:idSolicitud");
        theQuery.setParameter("idSolicitud", id);
        theQuery.executeUpdate();
    }
}
