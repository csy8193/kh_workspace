package kh.edu.updown.model.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class MainService {

	private Scanner sc = new Scanner(System.in);
	
	// ȸ�� ���Ե� ȸ���� ������ ������ �迭 ���� �� �Ҵ�
	private Member[] members = new Member[3];  
	
	private int memberCount = 0; // ���� ������ ȸ�� �� (ȸ�� ���� �� members �ε��� ������ ��� ����)
	
	// ���� �α����� ȸ���� ������ ������ ���� ����.
	private Member loginMember = null; // �α��� X == null,  �α��� O != null
	
	// LoginService ����
	private LoginService loginService = new LoginService();
	
	
	// �޴� ��� �޼ҵ�
	// * �޴� ��� �޼ҵ带 �м��غ�����!
	public void displayMenu() {

		int sel = 0; // �޴� ���ÿ� ����
		
		do {
			try {
				
				System.out.println();
				System.out.println("=== UP/DOWN ���� ===");
				if(loginMember == null) { // �α����� �Ǿ����� ���� ���
				
					System.out.println("[���� �޴�]");
					System.out.println("1. ȸ������");
					System.out.println("2. �α���");
					System.out.println("0. ����");
					System.out.print("�޴� ���� >> ");
					
					sel = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					switch(sel) {
					case 1 : signUp(); break;
					case 2 : login(); break;
					case 0 : System.out.println("[���α׷� ����]"); break;
					default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �������ּ���.");
					}
				
				}else { // �α����� �Ǿ��ִ� ���
					
					System.out.println("[�α��� �޴�]");
					System.out.println("1. ��/�ٿ� ���� start");
					System.out.println("2. �� ���� ��ȸ");
					System.out.println("3. ��ü ȸ�� ��ȸ");
					System.out.println("4. ��й�ȣ ����");
					System.out.println("9. �α׾ƿ�");
					System.out.println("�޴� ���� >> ");
					
					sel = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					switch (sel) {
					case 1: loginService.startGame(loginMember); break;
					case 2: loginService.selectMyInfo(loginMember); break;
					case 3: loginService.selectAllMember(members, memberCount); break;
					case 4: loginService.updatePassword(loginMember); break;
					
					case 9 : System.out.println("�α׾ƿ� �Ǿ����ϴ�."); 
							 loginMember = null; // loginMember �ʵ忡 �ƹ��͵� �����ϰ� ���� ������ �ǹ��ϴ� null�� ����
							 break;
					
					default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �������ּ���.");
					}
					
				}
				
				
			}catch (InputMismatchException e) {
				
				System.out.println("������ �Է����ּ���.");
				sc.nextLine(); // ���ۿ� �����ִ� ���ڿ� ����
			}
			
			
		}while(sel != 0);
		
	}
	
	// ȸ�� ����
	// * ȸ�� ���� �ڵ带 �м��غ�����.
	public void signUp() { 
		
		System.out.println("[ȸ�� ����]");
		
		// memberCount�� members �迭 ���� �̻��� ��� == ȸ�� ���� ������ �� �� ����
		if(memberCount >= members.length) { 
			System.out.println("ȸ�� ������ ������ �� �̻� ������ �� �� �����ϴ�.");
		
			
		} else { // ȸ�� ������ ������ ���
			
			String memberId = null; // ���̵� �Է� �޾� ������ ����
			
			while(true) {
				System.out.print("���̵� : ");
				memberId = sc.next();
				
				boolean flag = true; // �ߺ� ���̵� üũ�� ����
				
				for(int i=0 ; i<members.length ; i++) {
					
					if(members[i] != null) { // members �迭 ��Ұ� null�� �ƴѰ�� == ȸ�� ������ �ִ� ���
						
						// �Է� ���� ���̵�� ���� ���̵� members�� �����ϴ� ���
						if( memberId.equals(members[i].getMemberId()) ) {
							System.out.println("�ߺ��Ǵ� ���̵� �Դϴ�. �ٽ� �Է����ּ���.");
							
							flag = false;
							break; // �ߺ��˻� for�� ����
						}
						
					}else { // members �迭��Ұ� null�� ��� == ȸ�� ������ ���� ���
						break; // �ߺ��˻� for�� ����
					}
				} // end for
				
				if(flag) { // �ߺ� ���̵� �ƴ� ���
					break; // ���̵� �ݺ������� �Է� �޴� while�� ����
				}
			} // end while
			
			System.out.print("��й�ȣ : ");
			String memberPw = sc.next();
			
			System.out.print("�̸� : ");
			String memberName = sc.next();
			
			// �Է� ���� ���� �̿��� ���ο� Member ��ü�� �����ϰ� members �迭�� ��� �� 
			// memberCount��° ��Ұ� ������ �� �ֵ��� �ּҸ� ����
			members[memberCount] = new Member(memberId, memberPw, memberName);
			
			// ���ο� ȸ���� ���ԵǾ����Ƿ� memberCount�� 1 ����
			memberCount++;
			
			System.out.println("*** ȸ�� ������ �Ϸ�Ǿ����ϴ�. ***");
			
		} // end else (ȸ�� ������ ������ ���)
		
	} // end signUp()
	
	
	
	// �α���
	// ���̵�, ��й�ȣ�� �Է� �޾� ��ġ�ϴ� ȸ���� members�� ���� ��� �α���
	// ������ "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." ���
	public void login() {
		
//		Member[] members = new Member[3];
		
		System.out.print("���̵� �Է����ּ��� : ");
		String id = sc.next();
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		String pw = sc.next();
			for(int i=0; i<memberCount; i++) {
				if(members[i].getMemberId().equals(id) && members[i].getMemberPw().equals(pw)) {
					System.out.println("�α��� �Ϸ�");
					loginMember = members[i];
					break;
				}else {
					System.out.println("�α��ο� �����Ͽ����ϴ�.");
				}
			}
	}
	
	
	
	
	
}