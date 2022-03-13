package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
//    ctrl + o 를 누르면 HttpServlet 의 내장 메소드들을 가져오는 것이 가능
//    public 말고 protected 로 가져오기
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      printStartline 함수 내의 내용을 service에 적어둔 뒤 전체를 드래그하고
//      ctrl + t 를 누른 후 메소드 추출을 누르면 아래처럼 바로 메소드로 따로 추출이 가능하다.
        printStartLine(request);
        printHeaders(request);
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocal() = " + request.getProtocol()); //  HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-test
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " +
                request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    //Header 모든 정보 직접 확인해보기
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

//        예전 방식
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){ // 봐서 다음 값이 존재하면
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName = " + headerName);
//        }

//        요즘 방식
        request.getHeaderNames().asIterator()
                .forEachRemaining((headerName -> System.out.println("headerName = " + headerName)));

        System.out.println("--- Headers - end ---");
        System.out.println();
    }
}
