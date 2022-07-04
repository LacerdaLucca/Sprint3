<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 03/07/2022
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pedido Feito</title>
</head>
<body>
    Cliente: ${compra.cliente.nome}
    Valor da Compra: R$${compra.valorCompra}
    Valor do Frete: R$${compra.valorFrete}
    Dia da Entrega: <fmt:formatDate value="${compra.dataEntrega}" pattern="dd/MM/yyyy"/>
</body>
<a href="/Loja_war/entrada?acao=NovaCompraForm">NOVA COMPRA</a>
<a href="/Loja_war/entrada?acao=FinalizarCompraJSON">VER JSON</a>
</html>
