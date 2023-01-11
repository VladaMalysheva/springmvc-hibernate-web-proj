<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: prost
  Date: 11.01.2023
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css"
          rel="stylesheet"
          href = "${pageContext.request.contextPath}/jspresources/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href = "${pageContext.request.contextPath}/jspresources/css/add-customer-style.css">
    <title>Save customer</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Customer relationships manager</h2>
    </div>

<form:form modelAttribute="customer" action="saveCustomer" method="post">
    <input type="hidden" value="${customer.id}">
    <table>
        <tbody>
        <tr>
            <td><label>First name</label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><label>Last name</label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><label>Email</label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>
        </tbody>
    </table>
</form:form>

<div style="clear: both;"></div>
<p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>
</div>
</body>
</html>
