<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 02/07/2022
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkedServlet"/>
<!DOCTYPE html>
<html>
<head>
    <title>Criar perfil Cliente</title>
</head>
<body>
<form action="${linkedServlet}" method="post">

  Nome: <input type="text" name="nome"  />
  CPF: <input type="text" name="cpf"  />
  Senha: <input type="password" name="senha"  />
  Endereço: <input type="text" name="endereco"  />
  <input type="hidden" name="acao" value="NovoCliente">

  <input type="submit" />
</form>
</body>
</html>
