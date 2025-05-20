package com.tecsup.lab07.service.impl;

import com.tecsup.lab07.dao.ClienteDAO;
import com.tecsup.lab07.dao.impl.ClienteDAOImpl;
import com.tecsup.lab07.model.Cliente;
import com.tecsup.lab07.service.ClienteService;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDAO.crear(cliente);
    }

    @Override
    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDAO.listarTodos();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteDAO.actualizar(cliente);
    }

    @Override
    public void eliminarCliente(int id) {
        clienteDAO.eliminar(id);
    }
}