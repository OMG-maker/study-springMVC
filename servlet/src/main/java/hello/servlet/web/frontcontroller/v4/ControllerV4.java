package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

/**
 * 이번 버전은 인터페이스에 ModelView가 없다. model 객체는 파라미터로 전달되기 때문에 그냥
 * 사용하면 되고, 결과로 뷰의 이름만 반환해주면 된다.
 */
public interface ControllerV4 {

    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}

/**
 * 정리
 * 이번 버전의 컨트롤러는 매우 단순하고 실용적이다. 기존 구조에서 모델을 파라미터로 넘기고, 뷰의 논리
 * 이름을 반환한다는 작은 아이디어를 적용했을 뿐인데, 컨트롤러를 구현하는 개발자 입장에서 보면 이제
 * 군더더기 없는 코드를 작성할 수 있다.
 * 또한 중요한 사실은 여기까지 한번에 온 것이 아니라는 점이다. 프레임워크가 점진적으로 발전하는 과정
 * 속에서 이런 방법도 찾을 수 있었다.
 *
 * : 프레임워크나 공통 기능이 수고로워야 사용하는 개발자가 편리해진다.
 */
