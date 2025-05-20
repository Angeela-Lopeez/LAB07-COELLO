<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Editar Pedido</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h1 class="mb-4">Editar Pedido</h1>

<form action="pedidos" method="post">
  <input type="hidden" name="action" value="actualizar">
  <input type="hidden" name="id" value="${pedido.id}">

  <div class="mb-3">
    <label for="clienteId" class="form-label">Cliente:</label>
    <select class="form-select" id="clienteId" name="clienteId" required>
      <c:forEach var="cliente" items="${clientes}">
        <option value="${cliente.id}" ${cliente.id == pedido.clienteId ? 'selected' : ''}>
            ${cliente.nombre} (${cliente.email})
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="mb-3">
    <label for="fechaPedido" class="form-label">Fecha:</label>
    <input type="date" class="form-control" id="fechaPedido" name="fechaPedido"
           value="<fmt:formatDate value="${pedido.fechaPedido}" pattern="yyyy-MM-dd"/>" required>
  </div>

  <div class="mb-3">
    <label for="total" class="form-label">Total:</label>
    <input type="number" step="0.01" class="form-control" id="total" name="total"
           value="${pedido.total}" required>
  </div>

  <div class="mb-3">
    <label for="estado" class="form-label">Estado:</label>
    <select class="form-select" id="estado" name="estado" required>
      <option value="PENDIENTE" ${pedido.estado == 'PENDIENTE' ? 'selected' : ''}>PENDIENTE</option>
      <option value="PROCESANDO" ${pedido.estado == 'PROCESANDO' ? 'selected' : ''}>PROCESANDO</option>
      <option value="ENVIADO" ${pedido.estado == 'ENVIADO' ? 'selected' : ''}>ENVIADO</option>
      <option value="ENTREGADO" ${pedido.estado == 'ENTREGADO' ? 'selected' : ''}>ENTREGADO</option>
      <option value="CANCELADO" ${pedido.estado == 'CANCELADO' ? 'selected' : ''}>CANCELADO</option>
    </select>
  </div>

  <button type="submit" class="btn btn-success">Actualizar</button>
  <a href="pedidos?action=listar" class="btn btn-secondary">Cancelar</a>
</form>
</body>
</html>
