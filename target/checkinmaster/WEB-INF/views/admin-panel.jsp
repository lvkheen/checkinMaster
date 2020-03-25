<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<h1>Admin panel</h1>
<hr>

<div id="wrapper">
    <div id="header">
        <h2> Users table </h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th> Username </th>
                <th> Password </th>
                <th> Action </th>
            </tr>

            <c:forEach var="tempUser" items="${users}">

                <c:url var="deleteUser" value="/deleteUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>


                <tr>
                    <td>${tempUser.username}</td>
                    <td>${tempUser.password}</td>
                    <td><a href="${deleteUser}"
                    onclick="if (!(confirm('Are you sure?'))) return false"> Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

<hr>
<br><br>

<a href="${pageContext.request.contextPath}/home">Home</a>

</body>
</html>
