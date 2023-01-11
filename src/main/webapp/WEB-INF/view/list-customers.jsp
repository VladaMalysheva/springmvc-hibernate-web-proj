<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 11.01.2023
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css"
    rel="stylesheet"
    href = "${pageContext.request.contextPath}/jspresources/css/style.css">
    <title>Title</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Customer relationships manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">


        <input type="button" value="Add customer" onclick="window.location.href='showFormForAdd'" class="add-button"/>


        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Action</th>

            </tr>

            <c:forEach var="tempCustomer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormUpdate" >
                    <c:param name="id" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete" >
                    <c:param name="id" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="${updateLink}" >Update</a>
                        | <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete this customer?')">Delete</a>
                    </td>


                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
