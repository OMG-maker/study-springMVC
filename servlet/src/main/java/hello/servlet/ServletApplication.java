package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록
// 어노테이션 - 내 패키지를 포함한 하위 패키지에서 서블릿 다 찾아서 서블릿을 자동으로 등록해 실행할수 있도록 한다
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
	// 서블릿 - 프로젝트 생성
	// 서블릿 - Hello 서블릿 (hello.servlet.basic.HelloServlet)
	// 서블릿 - HttpServletRequest - 개요
	// 서블릿 - HttpServletRequest - 기본 사용법 (hello.servlet.basic.request.RequestHeaderServlet)
	// 서블릿 - HTTP 요청 데이터 - 개요
	// 서블릿 - HTTP 요청 데이터 - GET 쿼리 파라미터 (hello.servlet.basic.request.RequestParamServlet)
	// 서블릿 - HTTP 요청 데이터 - POST HTML Form (src/main/webapp/basic/hello-form.html)
	// 서블릿 - HTTP 요청 데이터 - API 메시지 바디 - 단순 텍스트 (hello.servlet.basic.request.RequestBodyStringServlet)
	// 서블릿 - HTTP 요청 데이터 - API 메시지 바디 - JSON (hello.servlet.basic.request.RequestBodyJsonServlet / hello.servlet.basic.HelloData)
	// 서블릿 - HttpServletResponse - 기본 사용법 (hello.servlet.basic.response.ResponseHeaderServlet)
	// 서블릿 - HTTP 응답 데이터 - 단순 텍스트, HTML (hello.servlet.web.response.ResponseHtmlServlet)
	// 서블릿 - HTTP 응답 데이터 - API JSON (hello.servlet.web.response. ResponseJsonServlet)
}
