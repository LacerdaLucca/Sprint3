<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 02/07/2022
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>
<%@ page import="java.util.List,loja.modelo.Compras.Produto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping</title>
</head>
<body>
<ul>
    <c:forEach items="${produtos}" var="produto">

        <li>
                ${produto.nome} - ${produto.preco}
            <a href="/Loja_war/entrada?acao=AdicionaCarrinho&id=${produto.id}">adicionar</a>
        </li>
    </c:forEach>
    <a href="/Loja_war/entrada?acao=ListaCarrinho">Carrinho</a>
</ul>
</body>
</html>
