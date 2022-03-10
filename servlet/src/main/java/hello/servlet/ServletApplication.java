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
// 커밋 확인 - Preferences
}
