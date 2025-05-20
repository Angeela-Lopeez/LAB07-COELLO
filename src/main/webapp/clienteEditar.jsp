<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h1 class="mb-4">Editar Cliente</h1>

<form action="clientes" method="post">
    <input type="hidden" name="action" value="actualizar">
    <input type="hidden" name="id" value="${cliente.id}">

    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}" required>
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" name="email" value="${cliente.email}" required>
    </div>

    <div class="mb-3">
        <label for="telefono" class="form-label">Teléfono:</label>
        <input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">
    </div>

    <button type="submit" class="btn btn-success">Actualizar</button>
    <a href="clientes?action=listar" class="btn btn-secondary">Cancelar</a>
</form>
</body>
</html>
