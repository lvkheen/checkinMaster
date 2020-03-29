<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>

    <h1><b>CheckinMaster</b></h1>
    <hr>
        <h2>Hello, <security:authentication property="principal.username"/>!</h2>
        <h2>Your roles: <security:authentication property="principal.authorities"/></h2>

        <hr>

            <security:authorize access="hasRole('MODERATOR')">
        <a href="${pageContext.request.contextPath}/moderator/moderator-panel">Moderator panel</a>
        <p/>
            </security:authorize>

            <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/admin-panel">Admin panel</a>
        <hr>
            </security:authorize>

        <div id="wrapper">
            <div id="header">
                <h2> CheckinMaster table </h2>
            </div>
        </div>

        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th> City </th>
                        <th> Place </th>
                        <th> Visitor name </th>
                        <th> Rating </th>
                        <th> Comment </th>
                        <security:authorize access="hasAnyRole('MODERATOR', 'ADMIN')">
                        <th> Action </th>
                        </security:authorize>
                    </tr>

                    <c:forEach var="locationMaster" items="${locations}">

                        <c:url var="deleteLocation" value="/deleteLocation">
                            <c:param name="locationId" value="${locationMaster.id}"/>
                        </c:url>

                        <tr>
                            <td>${locationMaster.city}</td>
                            <td>${locationMaster.place}</td>
                            <td>${locationMaster.visitorName}</td>
                            <td>${locationMaster.rating}</td>
                            <td>${locationMaster.comment}</td>
                            <security:authorize access="hasAnyRole('MODERATOR', 'ADMIN')">
                            <td>
                                <a href="${deleteLocation}"
                                   onclick="if (!(confirm('Are you sure?'))) return false"> Delete </a>
                            </td>
                            </security:authorize>
                        </tr>
                    </c:forEach>

                    <input type="button" value="Add location"
                           onclick="window.location.href='newLocationForm'; return false;"
                    />
                    <br><br>

                </table>
            </div>
        </div>

    <hr>

            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                <input type="submit" value="logout"/>
            </form:form>

    </body>
</html>
