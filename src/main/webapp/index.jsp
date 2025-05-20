<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema de Ventas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<div class="text-center">
    <h1 class="mb-4">Sistema de Ventas</h1>

    <div class="d-grid gap-3 col-md-6 mx-auto">
        <a href="clientes?action=listar" class="btn btn-primary btn-lg">Gestión de Clientes</a>
        <a href="pedidos?action=listar" class="btn btn-success btn-lg">Gestión de Pedidos</a>
    </div>
</div>
</body>
</html>