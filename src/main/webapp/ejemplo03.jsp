<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manipulación de Datos con JSTL</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<h2 class="mb-4">Manipulación de Datos con JSTL</h2>

<%-- Crear una lista de nombres como un String separado por comas --%>
<c:set var="nombres" value="ana,juan,carlos,maria,beatriz" />

<%-- Convertir la cadena separada por comas a una lista --%>
<c:set var="nombresList" value="${fn:split(nombres, ',')}" />

<%-- Mostrar los datos manipulados en una tabla --%>
<table class="table table-bordered">
    <thead class="table-light">
    <tr>
        <th>#</th>
        <th>Nombre original</th>
        <th>Mayúsculas</th>
        <th>Número de caracteres</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="nombre" items="${nombresList}" varStatus="estado">
        <tr>
            <td>${estado.count}</td>
            <td>${nombre}</td>
            <td>${fn:toUpperCase(nombre)}</td>
            <td>${fn:length(nombre)}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%-- Filtro: Mostrar nombres con más de 5 caracteres --%>
<h4 class="mt-4">Nombres con más de 5 letras:</h4>
<ul>
    <c:forEach var="nombre" items="${nombresList}">
        <c:if test="${fn:length(nombre) > 5}">
            <li>${fn:toUpperCase(nombre)} (${fn:length(nombre)} letras)</li>
        </c:if>
    </c:forEach>
</ul>
</body>
</html>