package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 프론트 컨트롤러를 이용하기 전의 모델이다.
// 이후에는 프론트 컨트롤러로 우선 호출을 받은 알맞은 컨트롤러를 호출하게 된다.
@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);
        String viewPath = "/WEB-INF/views/members.jsp";

        // controller 에서 view 로 이동할 떄 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 다른 서블릿이나 JSP 로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다.
        dispatcher.forward(request, response);
    }
}
