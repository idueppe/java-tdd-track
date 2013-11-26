package com.lsy.vehicle.dao.spi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lsy.vehicle.domain.ApplicationLog;

@Repository
public class ApplicationLogDao implements com.lsy.vehicle.dao.ApplicationLogDao {

    @PersistenceContext(unitName="vehicle-foundation")
    private EntityManager em;

    @Override
    public void log(ApplicationLog logEntry) {
        em.persist(logEntry);
    }

    @Override
    public List<ApplicationLog> findAll() {
        TypedQuery<ApplicationLog> query = em.createNamedQuery("ApplicationLog.LOAD_ALL", ApplicationLog.class);
        return query.getResultList();
    }
    
}