<%--
  Created by IntelliJ IDEA.
  User: Lucca
  Date: 03/07/2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:directive.page isELIgnored="false"/>
<%@ page import="java.util.List,modelo.Previsao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Previsao</title>
</head>
<body>
<ul>
    <c:forEach items="${Previsoes}" var="previsao">

    <li>
        "<fmt:formatDate value="${previsao.dia}" pattern="dd/MM/yyyy"/>" - ${previsao.max} - ${previsao.minima}
    </li>
    </c:forEach>
</body>
</html>
