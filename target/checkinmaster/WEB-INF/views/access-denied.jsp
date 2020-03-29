<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Access denied</title>
</head>
<h1 style="color : red">Sorry, you have no permission to check this page.</h1>
<hr>

<a href="${pageContext.request.contextPath}/"><h3>Welcome page</h3></a>

<p>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="logout"/>
    </form:form> </p>
</body>
</html>
