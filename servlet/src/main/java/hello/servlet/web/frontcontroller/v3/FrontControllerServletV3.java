package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*") // front-controller/v2 하위의 모든 호출은 이 컨트롤러를 거친다.
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        // 요청될 url 과 그에 맞는 controller 들을 { key - value } 값으로 저장한다.
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        // 현재 요청된 url 을 불러옴 (요청된 url 이 Map 의 key 이다.)
        String requestURI = request.getRequestURI();

        // 예를 들어 front-controller/v2/members/new-form 로 둘어왔을 시엔 controllerMap MemberFormControllerV2 이 return 된다.
        ControllerV3 controller = controllerMap.get(requestURI);

        if (controller == null) { // controllerMap 에서 Controller 를 찾지 못했을 경우
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 디테일한 로직이므로 매서드 뽑아내기 -> (option + cmd + M)
        Map<String, String> paramMap = createParamMap(request);

        // 현재 접속한 url 에 맞는 컨트롤러 내부에 있는 process 함수를 호출
        // 이름은 같으나 서로 다른 컨트롤러에 있는 process 메소드로 Java 의 다형성을 활용
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); // 논리이름 뽑아오기 ex)new-form

        MyView myView = viewResolver(viewName);

        myView.render(mv.getModel(), request, response);

        // 이렇게 컨트롤러와 HttpServlet 매개변수들을 분리할 수 있었다.
        // 또한, viewResolver 메소드를 통해 경로를 유연하게 변경할 수 있게 되었다.
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}



