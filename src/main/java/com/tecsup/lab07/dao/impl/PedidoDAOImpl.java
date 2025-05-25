package com.tecsup.lab07.dao.impl;

import com.tecsup.lab07.dao.PedidoDAO;
import com.tecsup.lab07.model.Pedido;
import com.tecsup.lab07.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void crear(Pedido pedido) {
        String sql = "INSERT INTO pedidos(cliente_id, fecha_pedido, total, estado) VALUES(?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, pedido.getClienteId());
            stmt.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            stmt.setDouble(3, pedido.getTotal());
            stmt.setString(4, pedido.getEstado());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pedido.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        Pedido pedido = null;
        String sql = "SELECT p.*, c.nombre as cliente_nombre FROM pedidos p " +
                "JOIN clientes c ON p.cliente_id = c.id WHERE p.id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pedido = new Pedido();
                    pedido.setId(rs.getInt("id"));
                    pedido.setClienteId(rs.getInt("cliente_id"));
                    pedido.setFechaPedido(rs.getDate("fecha_pedido"));
                    pedido.setTotal(rs.getDouble("total"));
                    pedido.setEstado(rs.getString("estado"));
                    pedido.setClienteNombre(rs.getString("cliente_nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as cliente_nombre FROM pedidos p " +
                "JOIN clientes c ON p.cliente_id = c.id";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setClienteId(rs.getInt("cliente_id"));
                pedido.setFechaPedido(rs.getDate("fecha_pedido"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setClienteNombre(rs.getString("cliente_nombre"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public List<Pedido> listarPorCliente(int clienteId) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as cliente_nombre FROM pedidos p " +
                "JOIN clientes c ON p.cliente_id = c.id WHERE p.cliente_id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setId(rs.getInt("id"));
                    pedido.setClienteId(rs.getInt("cliente_id"));
                    pedido.setFechaPedido(rs.getDate("fecha_pedido"));
                    pedido.setTotal(rs.getDouble("total"));
                    pedido.setEstado(rs.getString("estado"));
                    pedido.setClienteNombre(rs.getString("cliente_nombre"));
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void actualizar(Pedido pedido) {
        String sql = "UPDATE pedidos SET cliente_id = ?, fecha_pedido = ?, total = ?, estado = ? WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getClienteId());
            stmt.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            stmt.setDouble(3, pedido.getTotal());
            stmt.setString(4, pedido.getEstado());
            stmt.setInt(5, pedido.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

