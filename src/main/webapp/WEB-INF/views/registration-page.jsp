<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>


<h1>Registration page</h1>
<hr>

<form:form method="post" modelAttribute="userForm">

    <p/>
    Username <form:input path="username" type="text" placeholder="Username"/>
    <p/>
    Password <form:input path="password" type="password" placeholder="Password"/>
    <p/>
    <button type="submit"> Register </button>
    <p/>

</form:form>

<hr>
<a href="${pageContext.request.contextPath}/"> Homepage </a>



</body>
</html>
