package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*") // front-controller/v2 하위의 모든 호출은 이 컨트롤러를 거친다.
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        // 요청될 url 과 그에 맞는 controller 들을 { key - value } 값으로 저장한다.
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        // 현재 요청된 url 을 불러옴 (요청된 url 이 Map 의 key 이다.)
        String requestURI = request.getRequestURI();

        // 예를 들어 front-controller/v2/members/new-form 로 둘어왔을 시엔 controllerMap MemberFormControllerV2 이 return 된다.
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) { // controllerMap 에서 Controller 를 찾지 못했을 경우
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 현재 접속한 url 에 맞는 컨트롤러 내부에 있는 process 함수를 호출
        // 이름은 같으나 서로 다른 컨트롤러에 있는 process 메소드로 Java 의 다형성을 활용
        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}



