package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 핸들러 어댑터: 중간에 어댑터 역할을 하는 어댑터가 추가되었는데 이름이 핸들러 어댑터이다. 여기서
 * 어댑터 역할을 해주는 덕분에 다양한 종류의 컨트롤러를 호출할 수 있다.
 */
public interface MyHandlerAdapter {
    boolean supports(Object handler);
//    handler는 컨트롤러를 말한다.
//    어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드다.

    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;
//    어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환해야 한다.
//    실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도
//    반환해야 한다.
//    이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만 이제는 이 어댑터를 통해서 실제 컨트롤러가
//    호출된다.

    // 이후 5. 스프링 MVC - 구조 이해 로 들어간다.
}