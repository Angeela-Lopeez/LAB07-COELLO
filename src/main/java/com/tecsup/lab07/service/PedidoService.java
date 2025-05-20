package com.tecsup.lab07.service;

import com.tecsup.lab07.model.Pedido;
import java.util.List;

public interface PedidoService {
    void guardarPedido(Pedido pedido);
    Pedido buscarPedidoPorId(int id);
    List<Pedido> listarTodosPedidos();
    List<Pedido> listarPedidosPorCliente(int clienteId);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(int id);
}