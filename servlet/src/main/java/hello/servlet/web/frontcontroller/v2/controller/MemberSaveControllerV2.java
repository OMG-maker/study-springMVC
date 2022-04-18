package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 위 두 정보를 넣은 Member 변수를 생성하고, memberRepository 에 저장
        Member member = new Member(username, age);
        memberRepository.save(member);

        // model 에 데이터를 보관한다.
        // request 객체 내부 저장소의 맵에 member 를 저장
        request.setAttribute("member", member);


        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
