package com.tecsup.lab07.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.tecsup.lab07.model.Pedido;
import com.tecsup.lab07.service.PedidoService;
import com.tecsup.lab07.service.ClienteService;
import com.tecsup.lab07.service.impl.PedidoServiceImpl;
import com.tecsup.lab07.service.impl.ClienteServiceImpl;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedidos"})
public class PedidoServlet extends HttpServlet {
    private final PedidoService pedidoService = new PedidoServiceImpl();
    private final ClienteService clienteService = new ClienteServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        try {
            switch (action) {
                case "listar":
                    listarPedidos(request, response);
                    break;
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "guardar":
                    guardarPedido(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "actualizar":
                    actualizarPedido(request, response);
                    break;
                case "eliminar":
                    eliminarPedido(request, response);
                    break;
                default:
                    listarPedidos(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pedidos?action=listar");
        }
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> pedidos = pedidoService.listarTodosPedidos();
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("/pedidoListar.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("clientes", clienteService.listarTodosClientes());
        request.getRequestDispatcher("/pedidoNuevo.jsp").forward(request, response);
        System.out.println("Clientes cargados: " + clienteService.listarTodosClientes().size());
    }

    private void guardarPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException {
        Pedido pedido = new Pedido();
        pedido.setClienteId(Integer.parseInt(request.getParameter("clienteId")));
        pedido.setFechaPedido(parseFecha(request.getParameter("fechaPedido")));
        pedido.setTotal(Double.parseDouble(request.getParameter("total")));
        pedido.setEstado(request.getParameter("estado"));

        pedidoService.guardarPedido(pedido);
        response.sendRedirect("pedidos?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = pedidoService.buscarPedidoPorId(id);

        request.setAttribute("pedido", pedido);
        request.setAttribute("clientes", clienteService.listarTodosClientes());
        request.getRequestDispatcher("/pedidoEditar.jsp").forward(request, response);
    }

    private void actualizarPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException {
        Pedido pedido = new Pedido();
        pedido.setId(Integer.parseInt(request.getParameter("id")));
        pedido.setClienteId(Integer.parseInt(request.getParameter("clienteId")));
        pedido.setFechaPedido(parseFecha(request.getParameter("fechaPedido")));
        pedido.setTotal(Double.parseDouble(request.getParameter("total")));
        pedido.setEstado(request.getParameter("estado"));

        pedidoService.actualizarPedido(pedido);
        response.sendRedirect("pedidos?action=listar");
    }

    private void eliminarPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        pedidoService.eliminarPedido(id);
        response.sendRedirect("pedidos?action=listar");
    }

    private Date parseFecha(String fechaStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(fechaStr);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}