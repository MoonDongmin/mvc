<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String pagefile = request.getParameter("page");
    if (pagefile == null) {
        pagefile = "newitem";
    }
%>
<html>
<head>
    <title>Template Test</title>
    <link href="<%= request.getContextPath()%>css/template.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <td height="43" colspan=3 align=left>
            <jsp:include page="top.jsp"/>
        </td>
    </tr>
    <tr>
        <td width="15%" align=right valign=top><br>
            <jsp:include page="left.jsp"/>
        </td>
        <td colspan=2 align=center>
            <jsp:include page='<%=pagefile+".jsp" %>'/>
        </td>
    </tr>
    <tr>
        <td width="100%" height="40" colspan="3">
            <jsp:include page="bottom.jsp"/>
        </td>
    </tr>
</table>
</body>
</html>
