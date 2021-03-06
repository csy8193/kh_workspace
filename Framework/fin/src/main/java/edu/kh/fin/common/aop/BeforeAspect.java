package edu.kh.fin.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import edu.kh.fin.member.model.vo.Member;

// Aspect: 공통적으로 특정 위치에서 사용될 기능이 작성된 클래스

@Aspect // 공통 관심사가 작성된 클래스임을 명시(해당 클래스 Advice, Pointcut이 작성 되어 있어야 함)
@Component // 런타임 중 Advice 코드가 동적으로 추가될 수 있도록 스프링이 제어 가능한 Bean으로 등록
public class BeforeAspect {
	
	private Logger logger = LoggerFactory.getLogger(BeforeAspect.class);
	
	// JoinPoint : Advice가 가능한 모든 지점
	// Pointcut : JoinPoint 중 특정 지점(관점)을 지정하는 것
	// 				-> Advice 지정 부분
	
	// @Before("Pointcut") : Pointcut으로 지정된 메소드가 수행되기 전에 Advice를 수행
	// Pointcut 작성법 3가지
	// 1) 직접작성
	// -> execution([접근제한자(생략가능)] 리턴타입 패키지명+클래스명.메소드명([매개변수]) )
	// 		* : 모든, 아무 값
	// 		.. : 하위 모든 패키지 or 0개 이상의 매개변수
	// 					(패키지)		(매개변수(
	
	// 2) Pointcut이 작성된 메소드명을 작성
	// 3) 타 클래스에 작성된 Pointcut 메소드를 작성
	
	
	// 모든 컨트롤러 메소드 수행 전
	// @Before("execution(* edu.kh.fin..*Controller.*(..))")
	@Before("PointcutCollection.controllerPointcut()")
	public void controllerLog(JoinPoint jp) {
		
		// JoinPoint : Advice가 적용될 수 있는 모든 지점
		
		// JoinPoint 인터페이스 : 부가기능 메소르들 제공하는 인터네피스
		// - before, after, around  등 모든 관점 수행 시
		// 매개변수로 JointPoint 인터페이스를 구현한 객체를 전달 받음
		
		
		// 컨트롤러로 요청이 와서 수행되기 전에 로그를 출력
		// logger.debug("요청이 전달돼서 컨트롤러 메소드가 실행됨");
		
		// jp.getArgs() : 수행되는 메소드 모든 매개변수를 배열로 얻어오기
		// logger.debug(Arrays.toString( jp.getArgs() ));
		
		// jp.getTarget() : 타겟이 된 객체를 얻어옴
		String className = jp.getTarget().getClass().getSimpleName(); // 클래스명
		
		// jp.getSignature() : 수행되려는 메소드 선언부(시그니쳐)를 얻어옴
		String methodName = jp.getSignature().getName(); // 메소드명
		
		// HttpServletRequest 객체 얻어오기
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		// 로그인 된 회원 정보 얻어오기, 없으면 null
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		
		String str = "";
		
		// ip 주소 얻어오기
		str += "[ip]" + getRemoteAddr(request);
		
		// 로그인이 되어있는 경우 id도 추가
		if(loginMember != null) {
			str += "(id:" + loginMember.getMemberId() + ")";
		}
		
		str += " [Controller]" + className + "," + methodName + "()";
		
		
		logger.info(str);
	}
	
	   public static String getRemoteAddr(HttpServletRequest request) {

	        String ip = null;

	        ip = request.getHeader("X-Forwarded-For");

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("WL-Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_CLIENT_IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-Real-IP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-RealIP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("REMOTE_ADDR");
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getRemoteAddr(); 
	        }

	      return ip;

	   }
}
