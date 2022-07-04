<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 03/07/2022
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${linkEntradaServlet }" method="post">

    CPF: <input type="text" name="cpf"  />
    Senha: <input type="password" name="senha"  />

    <input type="hidden" name="acao" value="Login">
    <input type="submit" />
</form>
<%--<form action="${linkEntradaServlet }" method="post">--%>
<%--    <input type="hidden" name="novoCliente" value="NovoClienteForm">--%>
<%--    <input type="submit" value="Cadastro Cliente"/>--%>
<%--</form>--%>

</body>
</html>