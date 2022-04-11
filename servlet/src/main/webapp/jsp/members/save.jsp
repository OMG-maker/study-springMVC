<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%--아래는 이 파일이 JSP 파일이라는 뜻--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  <% ~~ %> 내부에는 자바 코드를 입력할 수 있다.  --%>
<%--  <%= ~~ %> 내부에는 자바 코드를 출력할 수 있다.  --%>
<%
    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");

    //request에서 username 과 age 받아오기
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    // 위 두 정보를 넣은 Member 변수를 생성하고, memberRepository 에 저장
    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
