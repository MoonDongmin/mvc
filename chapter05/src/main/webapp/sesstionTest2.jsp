<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Include Page</h1>
<table>
    <tr>
        <td>session 영역에 저장된 내용</td>
    </tr>
    <tr>
        <td>이름</td>
        <td><%=session.getAttribute("name")%>
        </td>
    </tr>
    <tr>
        <td>이메일</td>
        <td><%=session.getAttribute("email")%>
        </td>
    </tr>
    <tr>
        <td>아이디</td>
        <td><%=session.getAttribute("id")%>
        </td>
    </tr>

</table>

</body>
</html>
