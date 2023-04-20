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
    @Override
    public List<Cliente> findAll() {
        /** Cosulta JPQL*/
        return em.createQuery("select c from Cliente c").getResultList();
    }

    @Override
    public void save(Cliente cliente) {

        if (cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id) {
        //Obtenemos el cliente con el id
        Cliente cliente = findOne(id);
        //lo eliminamos
        em.remove(cliente);
    }
}
