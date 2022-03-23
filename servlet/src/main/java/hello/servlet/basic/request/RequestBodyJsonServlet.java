package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * http://localhost:8080/request-body-json
 *
 * JSON 형식 전송
 * content-type: application/json
 * message body: {"username": "hello", "age": 20}
 *
 */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

//    option + cmd + v 로 String username 바로 생성(윈도우에선 ctrl + alt + v)
//    String username = request.getParameter("username");

//    ctrl + o 를 누르면 HttpServlet 의 내장 메소드들을 가져오는 것이 가능
//    public 말고 protected 로 가져오기


    // 우리가 만든 모델인 HelloData 를 사용하려면 라이브러리가 필요한데, Spring boot 에서는 기본으로 jackson 이라는 라이브러리를 제공한다.
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 여기까진 이전과 동일

        System.out.println("messageBody = " + messageBody);

        // messageBody 에서 정보를 읽어와서, class 형식인 HelloData 에 대입한다.
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.getUsername() = " + helloData.getUsername());
        System.out.println("helloData.getAge() = " + helloData.getAge());

        response.getWriter().write("ok");

    }
}
