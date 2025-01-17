<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="joinBean" class="io.wisoft.tutorial.jspproject.JoinBean" scope="page"/>
<jsp:setProperty name="joinBean" property="*"/>


<html>
<head>
    <title>회원가입 입력 정보 확인 페이지</title>
    <link href="css/joinChk.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <td><b>아이디 : </b><%=joinBean.getId()%>
        </td>
        <td></td>
    </tr>
    <tr>
        <td><b>비밀번호 : </b><%=joinBean.getPass()%>
        </td>
        <td></td>
    </tr>
    <tr>
        <td><b>이름 : </b><%=joinBean.getName()%>
        </td>
        <td></td>
    </tr>
    <tr>
        <td><b>성별 : </b><%=joinBean.getSex()%>
        </td>
        <td></td>
    </tr>
    <tr>
        <td><b>나이 : </b><%=joinBean.getAge()%>
        </td>
        <td></td>
    </tr>
    <tr>
        <td><b>이메일주소 : </b><%=joinBean.getEmail()%>
        </td>
        <td></td>
    </tr>
</table>
</body>
</html>