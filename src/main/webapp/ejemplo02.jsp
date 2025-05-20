<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Cursos</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<h2 class="mb-4">Listado de Cursos</h2>


<c:set var="listaCursos" value="${[
        {'chrCurCodigo': 'C001', 'vchCurNombre': 'Matemáticas', 'intCurCreditos':3},
        {'chrCurCodigo': 'C002', 'vchCurNombre': 'Física', 'intCurCreditos':4},
        {'chrCurCodigo': 'C003', 'vchCurNombre': 'Historia', 'intCurCreditos':2}
    ]}" />

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Créditos</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="curso" items="${listaCursos}">
        <tr>
            <td>${curso.chrCurCodigo}</td>
            <td>${curso.vchCurNombre}</td>
            <td>${curso.intCurCreditos}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>