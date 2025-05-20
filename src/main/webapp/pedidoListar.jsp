<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Listado de Pedidos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h1 class="mb-4">Listado de Pedidos</h1>

<c:if test="${param.clienteId != null}">
  <div class="alert alert-info">
    Mostrando pedidos del cliente ID: ${param.clienteId}
  </div>
</c:if>

<a href="pedidos?action=nuevo" class="btn btn-primary mb-3">Nuevo Pedido</a>
<a href="clientes?action=listar" class="btn btn-secondary mb-3">Ver Clientes</a>

<table class="table table-striped">
  <thead class="table-dark">
  <tr>
    <th>ID</th>
    <th>Cliente</th>
    <th>Fecha</th>
    <th>Total</th>
    <th>Estado</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="pedido" items="${pedidos}">
    <tr>
      <td>${pedido.id}</td>
      <td>${pedido.clienteNombre}</td>
      <td><fmt:formatDate value="${pedido.fechaPedido}" pattern="dd/MM/yyyy"/></td>
      <td><fmt:formatNumber value="${pedido.total}" type="currency"/></td>
      <td>${pedido.estado}</td>
      <td>
        <a href="pedidos?action=editar&id=${pedido.id}" class="btn btn-warning btn-sm">Editar</a>
        <a href="pedidos?action=eliminar&id=${pedido.id}" class="btn btn-danger btn-sm">Eliminar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
