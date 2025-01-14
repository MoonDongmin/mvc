<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Session 실습</h1>

<%
    String name = request.getParameter("name");
    String id = request.getParameter("id");
    String email = request.getParameter("email");

    session.setAttribute("name", name);
    session.setAttribute("id", id);
    session.setAttribute("email", email);
%>

<%=name%>저장이 완료됨

<jsp:include page="sesstionTest2.jsp"/>
</body>
</html>
