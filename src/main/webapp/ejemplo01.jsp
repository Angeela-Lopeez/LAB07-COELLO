<%@ page contentType="text/html; charset=UTF-8" %>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Calculadora JSP</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">


<h2 class="mb-4">Calculadora JSP con JSTL</h2>


<form method="post" class="mb-4">
    <div class="row mb-3">

        <div class="col">
            <input type="number" name="num1" class="form-control" placeholder="Número 1" required />
        </div>

        <div class="col">
            <input type="number" name="num2" class="form-control" placeholder="Número 2" required />
        </div>

    <div class="col">
        <select name="operacion" class="form-select" required>
            <option value="sumar">Sumar</option>
            <option value="restar">Restar</option>
            <option value="multiplicar">Multiplicar</option>
            <option value="dividir">Dividir</option>
        </select>
    </div>

    <div class="col">
        <button type="submit" class="btn btn-primary">Calcular</button>
    </div>
    </div>
</form>


<c:set var="n1" value="${param.num1}" />
<c:set var="n2" value="${param.num2}" />
<c:set var="op" value="${param.operacion}" />


<c:if test="${not empty n1 and not empty n2 and not empty op}">


    <c:set var="resultado" value="0" />




    <c:choose>

        <c:when test="${op == 'sumar'}">
            <c:set var="resultado" value="${n1 + n2}" />
        </c:when>


        <c:when test="${op == 'restar'}">
            <c:set var="resultado" value="${n1 - n2}" />
        </c:when>


        <c:when test="${op == 'multiplicar'}">
            <c:set var="resultado" value="${n1 * n2}" />
        </c:when>


        <c:when test="${op == 'dividir'}">

            <c:if test="${n2 != 0}">
                <c:set var="resultado" value="${n1 / n2}" />
            </c:if>
        </c:when>
    </c:choose>

    <%-- Mostrar el resultado en un mensaje de exito --%>
    <div class="alert alert-success">
        <strong>Resultado:</strong>
            ${n1}
            <%-- Mostrar el símbolo de la operación --%>
        <c:choose>
            <c:when test="${op == 'sumar'}">+</c:when>
            <c:when test="${op == 'restar'}">-</c:when>
            <c:when test="${op == 'multiplicar'}">x</c:when>
            <c:when test="${op == 'dividir'}">/</c:when>
        </c:choose>
            ${n2} = <strong>${resultado}</strong>
    </div>

    <%-- Mostrar error si se intentó dividir entre cero --%>
    <c:if test="${op == 'dividir' and n2 == 0}">
        <div class="alert alert-danger">X No se puede dividir entre cero.</div>
    </c:if>
</c:if>

</body>
</html>