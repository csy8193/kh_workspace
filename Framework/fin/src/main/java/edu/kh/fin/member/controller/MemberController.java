package edu.kh.fin.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.fin.member.model.service.MemberService;
import edu.kh.fin.member.model.vo.Member;

// Controller : 요청에 따라 알맞은 서비스를 호출하고 결과에 따라 알맞은 응답을 제어하는 역할

// @RequestMapping : 요청 주소, 전달 방식에 따라 연결되는 클래스 또는 메소드를 지정하는 어노테이션
// 					 -> 클래스 + 메소드에 동시 작성하여 하나의 주소로 해석할 수 있음

// @RequestMapping 규칙
// 1. () 안에 작성되는 매개변수가 1개인 경우
// 		--> 매핑할 요청 주소로 해석(== value)

// 2. () 안에 작성되는 매개변수가 2개 이상인 경우
// 		--> 각 값을 해석하기 위해 value = , method = 과 key를 작성한다

// 3. method 키 미작성 시 get/post 관계없이 모두 처리한다

@Controller // 프레젠테이션 레이어, 웹앱에 전달된 요청과 응답을 처리하는 역할임을 명시 + Bean 등록

@RequestMapping("/member/*") // 	/fin/member/ 로 시작하는 모든 요청을 받아서 처리하는 컨트롤러
public class MemberController {
	
	// @Autowired
	// - component-scan(servlet-context.xml)을 통해
	//	 Bean으로 등록된 객체 중 타입이 같거나 상속 관계인 객체를 찾아
	//	 자동으로 의존성 주입(DI)을 하는 어노테이션
	@Autowired
	private MemberService service; 
	
	
	//@RequestMapping(value = "login", method = RequestMethod.POST) // 	/fin/member/login 요청을 처리하는 메소드
	public String login(HttpServletRequest req) {
		// -> 컨트롤러 메소드에 원하는 객체의 타입을 매개변수로 작성하면
		// 	  요청, 응답 관련 객체를 얻어오거나
		//    새로운 객체를 생성해서 의존성 주입(DI) 해줌
		
		System.out.println(req.getParameter("memberId"));
		System.out.println(req.getParameter("memberPw"));
		
		// 로그인은 JSP를 이용한 응답 페이지를 만드는 forward보다
		// 이미 만들어진 요청-응답 처리 메소드를 재용청하는 redirect를 사용하는 것이 맞다
		
		return "redirect:/"; // 	/fin/로 재요청
	}
	
	
	// (주의) 요청 매핑 주소 중복되지 않게 주의하자!
	
	
	// 2. @RequestParam 어노테이션을 이용한 파라미터 전달 받기
	// - 메소드 매개변수 앞에 작성
	// --> @RequestParam 뒤졲에 작성된 매개변수에 파라미터가 저장됨
	
	// @RequestParam 속성
	// value = 전달 받을 input 태그의 name 속성 값 (매개변수 1개일 때 기본값)
	
	// required = 파라미터 필수로 전달되어야 하는지 여부(기본값 : true == 필수)
	// -> required=true 일 때 파라미터가 없으면 : 400 Bad Request(잘못된 요청) 발생
	
	// defaultValue = 전달 받은 파라미터 값이 없을 때 지정할 기본값
	
	//@RequestMapping(value = "login", method = RequestMethod.POST) // 	/fin/member/login 요청을 처리하는 메소드
	public String login2(@RequestParam("memberId") String id,
						 @RequestParam("memberPw") String pw,
						 @RequestParam(value="test", required=false, defaultValue="기본값") String t) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(t);
		
		return "redirect:/";
	}
	
	// 3. @RequestParam 생략
	// - input태그의 name 속성값과,
	//   파라미터를 저장할 매개변수명이 같으면 생략 가능
	
	//@RequestMapping(value="login", method=RequestMethod.POST)
	public String login3(String memberId, String memberPw) {
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPw : " + memberPw);
		
		return "redirect:/";
	}
	
	
	// 4. @ModelAttribute
	// - 요청 시 전달 받은 파라미터를 객체 형태로 매핑하는 역하을 하는 어노테이션
	// -> 객체로 매핑하기 위한 조건
	// 1) input 태그 name 속성 값과 객체의 멤버변수(필드)명이 같아야 함
	// 2) 객체로 만들어질 클래스에 기본 생성자가 있어야함
	//	  -> 스프링이 객체를 자동 생성할 때 사용
	// 3) setter가 작성되어 있어야 함
	
	// - 메소드/매개 변수 레벨로 사용 가능
	
	// @ModelAttribute를 이용해 파라미터가 세팅된 객체 == 커맨드 객체
	
	//@RequestMapping(value="login", method=RequestMethod.POST)
	public String login4(@ModelAttribute Member member) {
		
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		
		return "redirect:/";
	}
	
	
	// 5. @ModelAttribute 생략
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login5(Member member) {
		
		
		// 로그인이란? DB에서 아이디, 비밀번호 일치하는 회원 정보를 조회하여 Session에 추가
		Member loginMember = service.login(member);
		
		return "redirect:/";
	}
}
