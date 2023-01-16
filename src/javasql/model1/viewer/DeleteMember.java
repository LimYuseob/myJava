package javasql.model1.viewer;

import java.util.Scanner;

import javasql.model1.daos.ModelDAO;

public class DeleteMember {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("회원 탈퇴하려면 ID 입력 해 : ");
		String id = sc.nextLine();
		String password = null;
		
		if(ModelDAO.getInstance().isMember(id) == 0) {
			System.out.println("존재하지 않는 ID 입니다.");
		}else {
			System.out.println("암호 입력해  : ");
			password =  sc.nextLine();
			
			//암호 검즘
			if(ModelDAO.getInstance().checkPassword(id,password)) {
				//암호까지 맞다면, 삭제를 로직 구현 함.
				if(ModelDAO.getInstance().deleteMember(id) == 1) {
					System.out.println(id + " 님 회원탈퇴가 아쉽네요..다음에 또 뵈요");
				}
			}else {
				System.out.println("비밀번호가 틀립니다..");
			}
		}
	}

}
