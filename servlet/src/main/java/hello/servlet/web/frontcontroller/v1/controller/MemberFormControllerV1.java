package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 { // option + enter 로 바로 전구 클릭 가능

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  servletMVC - MvcMemberFormServlet 에서 가져온 코드들이다.

        // 이동할 url
        String viewPath = "/WEB-INF/views/new-form.jsp"; // new-form.jsp 내부에 있는 form-action 의 경로가 상대경로이기 때문에 문제가 없다.
        // controller 에서 view 로 이동할 떄 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 JSP 로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다.
        dispatcher.forward(request, response);
    }
}
