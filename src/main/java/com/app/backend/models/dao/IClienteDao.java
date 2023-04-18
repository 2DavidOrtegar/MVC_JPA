package com.app.backend.models.dao;

import com.app.backend.models.entitys.Cliente;

import java.util.List;

public interface IClienteDao {

    List<Cliente> findAll();
    void save(Cliente cliente);

    Cliente findOne(Long id);

}
