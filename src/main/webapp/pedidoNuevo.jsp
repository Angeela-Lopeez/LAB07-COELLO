<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Nuevo Pedido</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h1 class="mb-4">Nuevo Pedido</h1>

<form action="pedidos" method="post">
  <input type="hidden" name="action" value="guardar">

  <div class="mb-3">
    <label for="clienteId" class="form-label">Cliente:</label>
    <select class="form-select" id="clienteId" name="clienteId" required>
      <option value="">Seleccione un cliente</option>
      <c:forEach var="cliente" items="${clientes}">
        <option value="${cliente.id}">${cliente.nombre} (${cliente.email})</option>
      </c:forEach>
    </select>
  </div>

  <div class="mb-3">
    <label for="fechaPedido" class="form-label">Fecha:</label>
    <input type="date" class="form-control" id="fechaPedido" name="fechaPedido" required>
  </div>

  <div class="mb-3">
    <label for="total" class="form-label">Total:</label>
    <input type="number" step="0.01" class="form-control" id="total" name="total" required>
  </div>

  <div class="mb-3">
    <label for="estado" class="form-label">Estado:</label>
    <select class="form-select" id="estado" name="estado" required>
      <option value="PENDIENTE">PENDIENTE</option>
      <option value="PROCESANDO">PROCESANDO</option>
      <option value="ENVIADO">ENVIADO</option>
      <option value="ENTREGADO">ENTREGADO</option>
      <option value="CANCELADO">CANCELADO</option>
    </select>
  </div>

  <button type="submit" class="btn btn-success">Guardar</button>
  <a href="pedidos?action=listar" class="btn btn-secondary">Cancelar</a>
</form>
</body>
</html>