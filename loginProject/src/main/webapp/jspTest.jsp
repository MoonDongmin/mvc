<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, javax.naming.*, javax.sql.DataSource" %>
<%
    Connection conn = null;
    boolean connect = false;

    try {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/jsptest");
        conn = ds.getConnection();
        connect = true;
        conn.close();
    } catch (Exception e) {
        connect = false;
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>JDBC Connection Test</title>
</head>
<body>
<h3>
    <% if (connect) { %>
    Connection successful!
    <% } else { %>
    Connection failed!
    <% } %>
</h3>
</body>
</html>