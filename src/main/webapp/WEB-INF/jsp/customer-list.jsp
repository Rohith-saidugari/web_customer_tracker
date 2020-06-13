<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rohit
  Date: 6/13/20
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRM</title>
</head>
<body>
<div id="wrapper">
    <div id="headder">
        <h2> CRM - Customer Relationship Manager</h2>
    </div>
</div>
${pageContext.request.contextPath}
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="tempcustomer" items="${customers}">
                <tr>
                    <td>${tempcustomer.firstName}</td>
                    <td>${tempcustomer.lastName}</td>
                    <td>${tempcustomer.emailId}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
