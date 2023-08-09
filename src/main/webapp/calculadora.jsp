<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
    <title>Calculadora</title>
  <!-- Outras meta tags, títulos, etc... -->
  <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

    <h1>Calculadora</h1>

    <html:form action="calculadora" method="post">

        <input type="text" name="minhaString">
            <html:submit value="Calcular"/>

    </html:form>
    
    <c:if test="${not empty mainForm.message}">
        <h2>Resultado:</h2>
        <p>${mainForm.message}</p>
    </c:if>
    

</body>
</html>
