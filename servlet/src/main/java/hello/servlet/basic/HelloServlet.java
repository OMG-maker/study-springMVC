package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

//        option + cmd + v 로 String username 바로 생성(윈도우에선 ctrl + alt + v)
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plane"); // 단순 문자로 보내겠다
        response.setCharacterEncoding("utf-8"); // 문자 인코딩 정보, 요즘엔 웬만하면 다 utf-8을 사용
        response.getWriter().write("hello " + username); // http 메시지 바디에 데이터가 들어감

//        HttpServletRequest 객체는 추가로 여러가지 부가기능도 함꼐 제공한다.
//
//        "임시 저장로 기능"
//        해당 HTTP 요청이 시작부터 끝날 떄 까지 유지되는 임시 저장소 기능
//        저장:
//        request.setAttribute(name, value);
//        조회:
//        request.getAttribute(name);
//
//        "세션 관리 기능"
//        request.getSession(create: true)
//
//        "종요"
//        HttpServletRequest, HttpServletResponse를 사용할 때 가장 중요한 점은 이 객체들이 HTTP요청 메시지, HTTP 응답 메시지를
//        편리하게 사용하도록 도와주는 객체라는 점이다. 따라서 이 기능에 대해서 깊이있는 이해를 하려면 HTTP스펙이 제공하는 요청, 응답 메시지 자체를 이해해야 한다.




    }
}
