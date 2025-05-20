<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h1 class="mb-4">Listado de Clientes</h1>

<a href="clientes?action=nuevo" class="btn btn-primary mb-3">Nuevo Cliente</a>

<table class="table table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Teléfono</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nombre}</td>
            <td>${cliente.email}</td>
            <td>${cliente.telefono}</td>
            <td>
                <a href="clientes?action=editar&id=${cliente.id}" class="btn btn-warning btn-sm">Editar</a>
                <a href="clientes?action=eliminar&id=${cliente.id}" class="btn btn-danger btn-sm">Eliminar</a>
                <a href="pedidos?action=listar&clienteId=${cliente.id}" class="btn btn-info btn-sm">Ver Pedidos</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>