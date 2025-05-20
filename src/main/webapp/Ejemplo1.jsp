<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<head>
    <title>Title</title>
</head>
<body>

<form method="post">

    <input type="number" name="num1" placeholder="Ingrese nro.">
    <input type="number" name="num2" placeholder="Ingrese nro.">
    <select name="operacion">
        <option value="sumar">Sumar</option>
        <option value="restar">Restar</option>
        <option value="multiplicar">Multiplicar</option>
        <option value="dividir">Dividir</option>
    </select>

    <button type="submit">Calcular</button>

</form>

<c:set var="n1" value="${param.num1}"></c:set>
<c:set var="n2" value="${param.num2}"></c:set>
<c:set var="op" value="${param.operacion}"></c:set>

<c:set var="resultado" value="0"></c:set>

<c:choose>
    <c:when test="${op=='sumar'}">
        <c:set var="resultado" value="${n1+n2}" />
    </c:when>
    <c:when test="${op=='restar'}">
        <c:set var="resultado" value="${n1-n2}" />
    </c:when>

</c:choose>

${resultado}


</body>
</html>
