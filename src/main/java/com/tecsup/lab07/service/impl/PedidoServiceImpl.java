package com.tecsup.lab07.service.impl;

import com.tecsup.lab07.dao.PedidoDAO;
import com.tecsup.lab07.dao.impl.PedidoDAOImpl;
import com.tecsup.lab07.model.Pedido;
import com.tecsup.lab07.service.PedidoService;
import java.util.List;

public class PedidoServiceImpl implements PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();

    @Override
    public void guardarPedido(Pedido pedido) {
        pedidoDAO.crear(pedido);
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        return pedidoDAO.buscarPorId(id);
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return pedidoDAO.listarTodos();
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(int clienteId) {
        return pedidoDAO.listarPorCliente(clienteId);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        pedidoDAO.actualizar(pedido);
    }

    @Override
    public void eliminarPedido(int id) {
        pedidoDAO.eliminar(id);
    }
}