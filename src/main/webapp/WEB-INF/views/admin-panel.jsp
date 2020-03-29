<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <th> Permissions </th>
            </tr>

            <c:forEach var="tempUser" items="${users}">

                <c:url var="deleteUser" value="/admin/deleteUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>

                <c:url var="banUser" value="/admin/banUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>

                <c:url var="restoreUser" value="/admin/restoreUser">
                    <c:param name="userId" value="${tempUser.username}"/>
                </c:url>

                <c:url var="setAdminPermissions" value="/admin/setAdminPermissions">
                    <C:param name="userId" value="${tempUser.username}"/>
                </c:url>

                <c:url var="setModeratorPermissions" value="/admin/setModeratorPermissions">
                    <C:param name="userId" value="${tempUser.username}"/>
                </c:url>


                <tr>
                    <td>${tempUser.username}</td>
                    <td>${tempUser.password}</td>
                    <td><a href="${deleteUser}"
                    onclick="if (!(confirm('Delete ${tempUser.username}?'))) return false"> Delete</a>
                        |
                        <a href="${banUser}"
                           onclick="if (!(confirm('Ban ${tempUser.username}?'))) return false"> Ban </a>
                        |
                        <a href="${restoreUser}"
                           onclick="if(!(confirm('Restore ${tempUser.username}?'))) return false"> Restore </a>
                    </td>
                    <td> <a href="${setAdminPermissions}"
                    onclick="if (!(confirm('Set ${tempUser.username} as admin?'))) return false"> Admin </a>
                        |
                        <a href="${setModeratorPermissions}"
                            onclick="if (!(confirm('Set ${tempUser.username} as moderator?'))) return false"> Moderator </a>
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
