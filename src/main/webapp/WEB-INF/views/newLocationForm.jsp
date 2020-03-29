<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New location</title>

    <style>
        .error {color:red}
    </style>


</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1> CheckinMaster </h1>
    </div>
</div>
<div id="container">
    <h3> Add new location </h3>
    <form:form action="saveLocation" modelAttribute="location" method="POST">

        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>City:</label></td>
                <td><form:input path="city"/>
                <form:errors path="city" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label>Place:</label></td>
                <td><form:input path="place"/>
                    <form:errors path="place" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label>Your name:</label></td>
                <td>
                    <form:input path="visitorName"/>
                    <form:errors path="visitorName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label>Rating:</label></td>
                <td><form:select path="rating">
                    <form:option value="1" label="1"/>
                    <form:option value="2" label="2"/>
                    <form:option value="3" label="3"/>
                    <form:option value="4" label="4"/>
                    <form:option value="5" label="5"/>
                </form:select>
                </td>
            </tr>
            <tr>
                <td><label>Comment(optional):</label></td>
                <td><form:input path="comment"/>
                    <form:errors path="comment" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/home">Homepage</a>
    </p>
</div>


</body>
</html>
