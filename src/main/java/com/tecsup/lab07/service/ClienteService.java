package com.tecsup.lab07.service;

import com.tecsup.lab07.model.Cliente;
import java.util.List;

public interface ClienteService {
    void guardarCliente(Cliente cliente);
    Cliente buscarClientePorId(int id);
    List<Cliente> listarTodosClientes();
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
}