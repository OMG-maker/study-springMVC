package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// response 는 request 에 비해서 비교적 간단하다.
// [스타트라인 세팅, 세더들 세팅, 바디컨텐트에 있는 내용 넣기] 정도만 하면 된다.

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line] : 응답 코드
        response.setStatus(HttpServletResponse.SC_OK);
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Status = 400 에러

        // [response-headers] : 아래 내용은 전부 http://localhost:8080/response-header 의 Network 에서 확인 가능
        // response.setHeader("Content-type", "text/plain");
//        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Pragma", "no-cache"); // 과거 버전까지 캐시를 없애는것
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 정보를 무효화하겠다.
        response.setHeader("Pragma", "no-cache"); // 과거 버전까지 캐시를 없애는것
        response.setHeader("my-header", "hello"); // 내가 원하는 임의의 헤더

        // [Header 편의 메서드] - content 세팅 메서드 예시
        // response.setHeader("Content-type", "text/plain;charset=utf-8"); 와 같은 효과
        content(response);

        // [cookie 편의 메서드] - cookie 세팅 메서드 예시
        cookie(response);

        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok");

    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2 // 생략해도 어차피 자동으로 content-body 에 있는 문자 길이를 계산해줌
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");

        // 위 코드와 같은 효과를 아래로 낼 수 있다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // 위 코드와 같은 효과를 아래로 낼 수 있다.
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 이 쿠키는 600초 동안 유효하다.
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302 // Http 상태코드를 302로 만들고
        //Location: /basic/hello-form.html // 로케이션 헤더를 /basic/hello-form.html로 보낼것이다.

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        // 위 코드와 같은 효과를 아래로 낼 수 있다.
        response.sendRedirect("/basic/hello-form.html");
    }

}
