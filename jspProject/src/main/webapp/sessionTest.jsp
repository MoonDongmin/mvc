<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Attribute Test</title>
</head>
<body>
<h2>Session 실습</h2>
<%
    request.setCharacterEncoding("UTF-8");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String name = request.getParameter("name");


    session.setAttribute("email", email);
    session.setAttribute("address", address);
    session.setAttribute("name", name);
%>
<h3><%=name %>님의 정보가 모두 저장되었습니다.</h3>
<jsp:include page="sessionTest2.jsp">
    <jsp:param name="name" value="<%=name%>"/>
    <jsp:param name="email" value="<%=email%>"/>
    <jsp:param name="address" value="<%=address%>"/>
</jsp:include>
</body>
</html>