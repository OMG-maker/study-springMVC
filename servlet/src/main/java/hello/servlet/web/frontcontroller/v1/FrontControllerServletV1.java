package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") // front-controller/v1 하위의 모든 호출은 이 컨트롤러를 거친다.
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // 현재 요청된 url 을 불러옴
        String requestURI = request.getRequestURI();

        // 예를 들어 front-controller/v1/members/new-form 로 둘어왔을 시엔 controllerMap MemberFormControllerV1 이 return 된다.
        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) { // controllerMap 에서 Controller 를 찾지 못했을 경우
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 현재 접속한 url 에 맞는 컨트롤러 내부에 있는 process 함수를 호출
        // 이름은 같으나 서로 다른 컨트롤러에 있는 process 메소드로 Java 의 다형성을 활용
        controller.process(request, response);
    }
}



