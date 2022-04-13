<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--  jsp 문법을 사용하지 않았을 경우  --%>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>

<%--  jsp 문법을 사용했을 경우  --%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>

</ul>
<a href="/index.html">메인</a>
</body>
</html>

