<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
    <style>

        .failed{
            color: red;
        }
        .logout{
            color: green;
        }

    </style>
</head>
<body>

<h1> LOGIN PAGE </h1>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
        method="post">

        <c:if test="${param.error != null}">
        <i class="failed"> Invalid login\password. </i>
        </c:if>

        <c:if test="${param.logout != null}">
            <i class="logout"> Logged out </i>
        </c:if>

    <p>Username: <input type="text" name="username"></p>

    <p> Password: <input type="password" name="password"> </p>

    <input type="submit" value="Login"/>

</form:form>
<a href="${pageContext.request.contextPath}/registration"> Registration </a>


<hr>
<a href="${pageContext.request.contextPath}/"> Welcome page </a>

</body>

