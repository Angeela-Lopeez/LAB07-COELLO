package com.tecsup.lab07.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.tecsup.lab07.model.Cliente;
import com.tecsup.lab07.service.ClienteService;
import com.tecsup.lab07.service.impl.ClienteServiceImpl;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/clientes"})
public class ClienteServlet extends HttpServlet {
    private final ClienteService clienteService = new ClienteServiceImpl();

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        try {
            switch (action) {
                case "listar":
                    listarClientes(request, response);
                    break;
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "guardar":
                    guardarCliente(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "actualizar":
                    actualizarCliente(request, response);
                    break;
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                default:
                    listarClientes(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("error", "Error en la operación: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/clientes?action=listar");
        }
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/clienteListar.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/clienteNuevo.jsp").forward(request, response);
    }

    private void guardarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefono(request.getParameter("telefono"));

        try {
            clienteService.guardarCliente(cliente);
            request.getSession().setAttribute("mensaje", "Cliente guardado exitosamente");
        } catch (Exception e) {
            request.getSession().setAttribute("error", "Error al guardar cliente: " + e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/clientes?action=listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            request.getSession().setAttribute("error", "Cliente no encontrado");
            response.sendRedirect(request.getContextPath() + "/clientes?action=listar");
            return;
        }

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/clienteEditar.jsp").forward(request, response);
    }

    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(request.getParameter("id")));
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefono(request.getParameter("telefono"));

        try {
            clienteService.actualizarCliente(cliente);
            request.getSession().setAttribute("mensaje", "Cliente actualizado exitosamente");
        } catch (Exception e) {
            request.getSession().setAttribute("error", "Error al actualizar cliente: " + e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/clientes?action=listar");
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            clienteService.eliminarCliente(id);
            request.getSession().setAttribute("mensaje", "Cliente eliminado exitosamente");
        } catch (Exception e) {
            request.getSession().setAttribute("error", "Error al eliminar cliente: " + e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/clientes?action=listar");
    }
}


