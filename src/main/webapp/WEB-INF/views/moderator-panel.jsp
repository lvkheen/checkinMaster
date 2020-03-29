<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Moderator panel </h1>

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

                <c:url var="banUser" value="/moderator/banUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>

                <c:url var="restoreUser" value="/moderator/restoreUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>


                <tr>
                    <td>${tempUser.username}</td>
                    <td>${tempUser.password}</td>
                    <td>
                        <a href="${banUser}"
                           onclick="if (!(confirm('Ban user?'))) return false"> Ban </a>
                        |
                        <a href="${restoreUser}"
                           onclick="if(!(confirm('Restore ${tempUser.username}?'))) return false"> Restore </a>
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
