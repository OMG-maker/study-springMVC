<%--아래는 이 파일이 JSP 파일이라는 뜻--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--basic/hello-form 내부의 form 내용과 같음--%>
<%--단 하나 다르다면, action="/request-param" 이 action="/jsp/members/save.jsp" 으로 변경--%>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
