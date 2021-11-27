package kh.edu.updown.model.service;

import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// ���ٿ� ���� ����
	// 1 ~ 100 ���� ���� �� �����ϰ� �� ���ڸ� �����ϰ� ��/�ٿ� ������ ����
	// ���� Ƚ���� ���� �α����� ȸ���� ���� �Ǵ� �ְ� ����� ��� ȸ���� highScore �ʵ� ���� ����
	public void startGame(Member loginMember) {
		
		System.out.println("[Game Start...]");
		int random = (int)((Math.random()*100)+1);
//		System.out.println(random);
		int count = 1;
		while(true) {
			System.out.print(count + "��° �Է� : ");
			int num = sc.nextInt();
			sc.nextLine();
			if(random < num) {
				System.out.println("-- DOWN --");
			}else if (random > num) {
				System.out.println("-- UP --");
			}else {
				System.out.println("����!!");
				System.out.println("�Է� �õ� Ƚ�� : "+ count);
				if(loginMember.getHighScore() == 0 || count < loginMember.getHighScore()) {
					loginMember.setHighScore(count);
					System.out.println("*** �ְ� ��� �޼� ***");
				}
				break;
			}
			count++;
		}
	}

	
	// �� ���� ��ȸ
	// �α����� ����� ���� �� ��й�ȣ�� ������ ������ ������ ȭ�鿡 ���
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[�� ���� ��ȸ]");
		System.out.println("���̵� : " + loginMember.getMemberId());
		System.out.println("�̸� : " + loginMember.getMemberName());
		System.out.println("�ְ����� : " + loginMember.getHighScore()+"ȸ");
	}

	// ��ü ȸ�� ��ȸ
	// ��ü ȸ���� ���̵�, �ְ������� �ⷰ
	public void selectAllMember(Member[] members, int memberCount) {
		
		System.out.println("[��ü ȸ�� ��ȸ]");
		System.out.println("[���̵�]\t[�ְ�����]");
		for(int i=0; i < memberCount; i++) {
			System.out.print(members[i].getMemberId()+"   ");
			System.out.printf("%3d",members[i].getHighScore());
			System.out.println();
		}
		
	}

	// ��й�ȣ ����
	// ���� ��й�ȣ�� �Է� �޾� 
	// ���� ��쿡�� �� ��й�ȣ�� �Է� �޾� ��й�ȣ ����
	public void updatePassword(Member loginMember) {
		
		System.out.println("[��й�ȣ ����]");
		System.out.println("���� ��й�ȣ �Է� : ");
		String pw = sc.next();
		sc.nextLine();
		if(loginMember.getMemberPw().equals(pw)) {
			System.out.println("�� ��й�ȣ : ");
			String newPw = sc.next();
			loginMember.setMemberPw(newPw);
			System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
		}else {
			System.out.println("���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		
		
	}
	

	
	
}