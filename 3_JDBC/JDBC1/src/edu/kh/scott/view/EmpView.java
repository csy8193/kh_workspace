package edu.kh.scott.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.scott.model.service.EmpService;
import edu.kh.scott.model.vo.Emp;

public class EmpView {
	
	// View 클래스
	// - 사용자에게 보여지는 부분으로
	//	 사용자로부터 요청을 입력받고, 결과(응답)를 출력함
	
	// -> 해당 클래스에는 입력, 출력 받는 코드만 작성할 예정
	
	private Scanner sc = new Scanner(System.in);
	
	private EmpService service = new EmpService();
	// View -> Service
	
	public void displayMenu() {
		
		int sel = 0; // 메뉴 번호를 입력 받을 변수
		
		do {
			
			try {
				
				System.out.println("==================================");
	            System.out.println("[Main Menu]");
	            System.out.println("1. 전체 사원 정보 조회");
	            System.out.println("2. 사번으로 사원 정보 조회");
	            System.out.println("3. 새로운 사원 정보 삽입");
	            System.out.println("4. 사번으로 사원 정보 수정");
	            // 사번, 직책, 급여, 커미션 입력 받아
	            // 사번이 일치하는 사원의 직책, 급여, 커미션을 수정

	            System.out.println("5. 사번으로 사원 정보 삭제");
	            // 사번을 입력 받아 일치하는 사번을 가진 사원 정보 삭제

	            System.out.println("6. 사번, 이름이 모두 일치하는 사원 정보 조회");
	            System.out.println("7. 부서 번호를 입력 받아 일치하는 사원 정보 조회");
	            System.out.println("0. 프로그램 종료");
	            System.out.println("==================================");
	            
	            System.out.print("메뉴 선택 >>> ");
	            sel = sc.nextInt();
	            sc.nextLine(); // 입력 버퍼 개행문자 제거
	            
	            System.out.println(); // 줄 바꿈
	            
	            switch(sel) {
	            case 1 : selectAll();	break; // 1. 전체 사원 정보 조회
	            case 2 : selectOne();	break; // 2. 사번으로 사원 정보 조회
	            case 3 : insertEmp();	break; // 3. 새로운 사원 정보 삽입
	            case 4 : updateEmp();	break; // 4. 사번으로 사원 정보 수정
	            case 5 : deleteEmp();	break; // 5. 사번으로 사원 정보 삭제
	            case 6 : selectOne2();	break; // 6. 사번, 이름이 모두 일치하는 사원 정보 조회
	            case 7 : selectDeptNo();	break; // 7. 부서 번호를 입력 받아 일치하는 사원 정보 조회
	            case 0 : System.out.println("프로그램이 종료됩니다...");	break;
	            default : System.out.println("메뉴에 존재하는 번호만 입력해주세요");
	            }
				
			}catch(InputMismatchException e) {
				System.out.println("메뉴 번호만 입력 해주세요.");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력 값 제거
				sel = -1; // 첫 번째 반복에서 오류 발생 시 종료되는 것을 막기 위한 코드
				
			}
			
			
		}while( sel != 0 ); // sel이 0이 아니면 반복
	}
	
	
	// 1. 전체 사원 정보 조회
	private void selectAll() {
		
		// DB의 EMP테이블에 존재하는 모든 사원 정보를 얻어와서 출력
		
		// 1-1. EmpService에 있는 selectAll() 메소드를 호출
		List<Emp> empList = service.selectAll(); // DB 조회 결과가 담긴 List<Emp>가 반환됨
		
		// 1-15. empList 상태에 따라 출력 내용 가공
		if(empList == null) {
			System.out.println("오류가 발생하여 조회 실패");
			
		}else if(empList.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
			
		}else {
			
			// 향상된 for문으로 empList 내용을 모두 출력
			for(Emp emp : empList) {
				System.out.println(emp);
				
			}
			
		}
		
	}
	
	
	// 2. 사번으로 사원 정보 조회
	private void selectOne() {
		
		// 2-1. 사번 입력 받기
		System.out.print("조회할 사원 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// 2-2. 입력 받은 사번을 EmpService의 selectOne() 메소드로 전달
		Emp emp = service.selectOne(input);
		
		// 2-16. 조회 결과에 따른 출력화면 가공
		if(emp == null) {
			System.out.println("일치하는 사번의 사원이 없습니다.");
			
		}else {
			System.out.println(emp);
			
		}
		
	}
	
	private void selectDeptNo() {
		
		System.out.print("부서 번호 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		List<Emp> empList = service.selectDeptNo(input);
		
		if(empList == null) {
			System.out.println("오류가 발생하여 조회 실패");
			
		}else if(empList.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
			
		}else {
			
			// 향상된 for문으로 empList 내용을 모두 출력
			for(Emp emp : empList) {
				System.out.println(emp);
				
			}
			
		}
	}
	
	
	// 3. 새로운 사원 정보 삽입
	private void insertEmp() {
		
		// 3-1. 필요한 사원 정보 입력 받기
		System.out.print("이름 : ");
		String eName = sc.next();
		
		System.out.print("직책 : ");
		String job = sc.next();
		
		System.out.print("직속 상사 번호 :");
		int mgr = sc.nextInt();
		
		System.out.print("급여 : ");
		int sal = sc.nextInt();
		
		System.out.print("커미션 : ");
		int comm = sc.nextInt();
		
		System.out.print("부서번호 : ");
		int deptNo = sc.nextInt();
		sc.nextLine();
		
		// 3-2. Emp객체를 생성하여 입력 받은 정보를 저장하기
		Emp emp = new Emp(eName, job, mgr, sal, comm, deptNo);
		
		// 3-3. 입력 받은 값을 저장한 emp 객체를 DB까지 전달
		int result = service.insertEmp(emp);
		
		// 3-17. 삽입 결과에 따른 출력화면 제어
		if(result > 0) {
			System.out.println("사원 정보 삽입 성공");
			
		}else {
			System.out.println("사원 정보 삽입 실패");
			
		}
	}
	
	// 4. 사번으로 사원 정보 수정
	private void updateEmp() {
		
		System.out.print("수정할 사원의 사번 : ");
		int empNo = sc.nextInt();
		
		System.out.print("수정 후 직책 : ");
		String job = sc.next();
		
		System.out.print("수정 후 급여 : ");
		int sal = sc.nextInt();
		
		System.out.print("수정 후 커미션 : ");
		int comm = sc.nextInt();
		
		Emp emp = new Emp(empNo, job, sal, comm);
		
		int result = service.updateEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 정보 수정 성공");
			
		}else {
			System.out.println("일치하는 사번의 사원이 존재하지 않습니다");
			
		}
		
	}
	
	// 5. 사번으로 사원 정보 삭제
	private void deleteEmp() {
		
		System.out.print("삭제할 사원 사번 입력 : ");
		int empNo = sc.nextInt();
		
		int result = service.deleteEmp(empNo);
		
		if(result > 0) {
			System.out.println("사원 정보 삭제 성공");
			
		}else {
			System.out.println("일치하는 사번의 사원이 존재하지 않습니다");
			
		}
	}
	
	// 6. 사번, 이름이 모두 일치하는 사원 정보 조회
	private void selectOne2() {
		
		System.out.print("사번 : ");
		int empNo = sc.nextInt();
		
		System.out.print("이름 : ");
		String eName = sc.next();
		
		Emp emp = service.selectOne2(empNo, eName);
		
		if(emp == null) {
			System.out.println("일치하는 사원이 없습니다.");
			
		}else {
			System.out.println(emp);
			
		}
	}
}
