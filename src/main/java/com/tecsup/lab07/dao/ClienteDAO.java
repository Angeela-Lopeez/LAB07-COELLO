package com.tecsup.lab07.dao;

import com.tecsup.lab07.model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void crear(Cliente cliente);
    Cliente buscarPorId(int id);
    List<Cliente> listarTodos();
    void actualizar(Cliente cliente);
    void eliminar(int id);
}
