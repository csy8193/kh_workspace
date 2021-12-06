package ncs.memberList.model;

import java.util.Calendar;

public class MemberVO {
	// *** (요구사항3) ncs.memberList.model.MemberVO 클래스를 생성하시오 *** //
	
	
	// *** (요구사항10) ***
	// ncs.memberList.model.MemberVO 클래스내에 다음과 같은 2개의 메소드 getAge() 와 getSexual() 을 추가하였다.
	// 가입된 회원정보가 보여지도록 웹브라우저에 번호, 아이디, 성명, 나이, 성별이 보여지도록 /WEB-INF/ncstestMember/memberVOList.jsp 파일을 작성하시오.


	public int getAge() {
		Calendar currentDate = Calendar.getInstance();
		int currentYear = currentDate.get(Calendar.YEAR);

		int age = 0;
		try {
			age = currentYear - Integer.parseInt(birthday.substring(0, 4)) + 1;
		} catch (NumberFormatException e) { 
			e.printStackTrace(); 
		}
		return age;
	}

	public String getSexual() {
		if(gender==1) return "남";

		else return "여";

	}
}
