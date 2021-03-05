<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>OpenRekening</title>
</head>
<body>

<%--@elvariable id="user" type="com.example.demo.beans.User"--%>
<form:form action="/openRekening" method="post" modelAttribute="user">
    Bsn:<br>
    <input type="text" name="bsn"><br>
    Naam:<br>
    <input type="text" name="naam"><br>
    Password:<br>
    <input type="text" name="password"><br>
    <input type="submit" value="Druk hier"><br>
</form:form>
</body>
</html>
