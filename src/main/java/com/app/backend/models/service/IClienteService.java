package com.app.backend.models.service;

import com.app.backend.models.entitys.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);

}
