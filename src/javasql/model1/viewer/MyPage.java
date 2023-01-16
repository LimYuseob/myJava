package javasql.model1.viewer;

import java.util.Scanner;

import javasql.model1.daos.ModelDAO;
import javasql.model1.model.MemberDTO;

/*
 * 이 클래스는 마이페이지와 같은 기능을 합니다.
 * 
 * DAO 의 myPage 메서드를 정의 해서 여기서 해당 메서드를 호출 하여
 * 지정된 ID 에 해당하는 정보를 출력하도록 하세요.
 * 당연히 파라미터정보나, 리턴 정보는 여러분이 생각해서 정의해야 합니다.
 * 모든 정보가 다 나열되어야 합니다.
 * 
 * sql 은 Select * from users where userid = ? 이렇게 되야 합니다.
 */
public class MyPage {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ModelDAO dao = ModelDAO.getInstance();
		System.out.println("찾으시는 ID 를 입력 하세요 : ");
		String id = sc.nextLine();
		MemberDTO members = dao.MyPage(id);
		
		
		System.out.println("ID : " + members.getUserId());
		System.out.println("Name : " + members.getUserName());
		System.out.println("Password : " + members.getUserPassword());
		System.out.println("age : " + members.getUserAge());
		System.out.println("Email : " + members.getUserEmail());
		
		
		System.out.println("바꾸시려는 password를 입력하여 주세요.");
		String password = sc.nextLine();
		MemberDTO mem = dao.Update(password);
		
		System.out.println("변경된 비밀번호는  : " + mem.getUserPassword());
		
		
		
		}
	}

