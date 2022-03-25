package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse - HTML 응답
 *
 *
 * HTTP 응답 메시지는 주로 다음 내용을 담아서 전달한다.
 * 단순 텍스트 응답
 * 앞에서 살펴봄 ( writer.println("ok"); )
 * HTML 응답
 * HTTP API - MessageBody JSON 응답
 *
 *
 * 이번 클래스에서는 HttpServletResponse 의 HTML 응답을 다뤄본다.
 * */

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 우선 컨텐트 타입을 잡아준다.
        // Content-Type: texthtml;charset=utf-8
        response.setContentType("text/html"); // 초기엔 이런 설정을 직접 다 해줘야 웹 브라우저가 html랜더링을 했다
        response.setCharacterEncoding("utf-8"); // 이렇게 설정하지 않으면 한글이 깨진다.

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("    <div>안녕?</div>");
        writer.println("</body>");
        writer.println("</html>");


    }
}
