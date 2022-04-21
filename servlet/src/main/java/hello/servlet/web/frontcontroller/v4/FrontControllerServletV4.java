package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FrontControllerServletV4 는 사실 이전 버전과 거의 동일하다
 */

/**
 * 모델 객체 전달
 * Map<String, Object> model = new HashMap<>(); //추가
 * 모델 객체를 프론트 컨트롤러에서 생성해서 넘겨준다. 컨트롤러에서 모델 객체에 값을 담으면 여기에
 * 그대로 담겨있게 된다
 */

/**
 * 뷰의 논리 이름을 직접 반환
 * String viewName = controller.process(paramMap, model);
 * MyView view = viewResolver(viewName);
 */
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*") // front-controller/v2 하위의 모든 호출은 이 컨트롤러를 거친다.
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        // 요청될 url 과 그에 맞는 controller 들을 { key - value } 값으로 저장한다.
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        // 현재 요청된 url 을 불러옴 (요청된 url 이 Map 의 key 이다.)
        String requestURI = request.getRequestURI();

        // 예를 들어 front-controller/v2/members/new-form 로 둘어왔을 시엔 controllerMap MemberFormControllerV2 이 return 된다.
        ControllerV4 controller = controllerMap.get(requestURI);

        if (controller == null) { // controllerMap 에서 Controller 를 찾지 못했을 경우
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 디테일한 로직이므로 매서드 뽑아내기 -> (option + cmd + M)
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        // 현재 접속한 url 에 맞는 컨트롤러 내부에 있는 process 함수를 호출
        // 이름은 같으나 서로 다른 컨트롤러에 있는 process 메소드로 Java 의 다형성을 활용
        String viewName = controller.process(paramMap, model);

        MyView myView = viewResolver(viewName);

        myView.render(model, request, response);
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



