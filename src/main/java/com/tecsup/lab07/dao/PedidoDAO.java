package com.tecsup.lab07.dao;

import com.tecsup.lab07.model.Pedido;
import java.util.List;

public interface PedidoDAO {
    void crear(Pedido pedido);
    Pedido buscarPorId(int id);
    List<Pedido> listarTodos();
    List<Pedido> listarPorCliente(int clienteId);
    void actualizar(Pedido pedido);
    void eliminar(int id);
}