<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Include Page</title>
</head>
<body>
<h1>Include Page</h1>
<table border="1">
    <tr>
        <td colspan="2">Session 영역에 저장된 내용들</td>
    </tr>
    <%
        Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String attributeName = (String) e.nextElement();
            String attributeValue = (String) session.getAttribute(attributeName);
    %>
    <tr>
        <td><%=attributeName %>
        </td>
        <td><%=attributeValue %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>