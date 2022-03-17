package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// API 방식으로 데이터를 주고받는 방법
// HTTP 메시지 바디에 데이터를 직접 담아서 요청
// 최근엔 주로 JSON 을 사용(예전엔 JSON, XML, TEXT)

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // http 바디의 정보를 바이트 형태로 받아옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 바이트 형태로 받아온 정보를 String 형태로 바꿈

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
