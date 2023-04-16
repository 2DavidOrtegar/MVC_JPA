package com.app.backend.models.dao;

import com.app.backend.models.entitys.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Marcar la clase como una clase de acceso a datos
@Repository
public class ClienteDaoImpl implements IClienteDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        /** Cosulta JPQL*/
        return em.createQuery("select c from Cliente c").getResultList();
    }
}
