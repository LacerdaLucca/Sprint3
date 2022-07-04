<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 03/07/2022
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkedServlet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Previsao Tempo</title>
</head>
<body>
<form action="${linkedServlet}" method="post">

    Cidade: <input type="text" name="nome"  />
    Estado(UF): <input type="text" name="uf"  />
    <input type="hidden" name="acao" value="ListaPrevisao">

    <input type="submit" />
</form>
</body>
</html>
