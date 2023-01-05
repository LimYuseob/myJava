package utilex;

import java.util.ArrayList;

/*
 * 이 클래스는 필요한 DTO 객체를 필요한 만큼 생성해서 List Type 으로
 * DAO 에게 보내는 역활을 합니다.
 */
public class SendDTO {
	
	public static void main(String[] args) {
		
		StudentDTO dto1 = new StudentDTO();
		dto1.setNumber(1);
		dto1.setName("임유섭");
		dto1.setTel("11111111");
		dto1.setGroup(2);
		
		StudentDTO dto2 = new StudentDTO();
		dto2.setNumber(2);
		dto2.setName("윤태종");
		dto2.setTel("2222222");
		dto2.setGroup(2);
		
		StudentDTO dto3 = new StudentDTO();
		dto3.setNumber(3);
		dto3.setName("조기제");
		dto3.setTel("33333333");
		dto3.setGroup(2);
		
		StudentDTO dto4 = new StudentDTO();
		dto4.setNumber(4);
		dto4.setName("임진우");
		dto4.setTel("44444444444");
		dto4.setGroup(2);
		
		StudentDTO dto5 = new StudentDTO();
		dto5.setNumber(5);
		dto5.setName("조정기");
		dto5.setTel("5555555555");
		dto5.setGroup(2);
		
		StudentDTO dto6 = new StudentDTO();
		dto6.setNumber(6);
		dto6.setName("심지석");
		dto6.setTel("666666666666");
		dto6.setGroup(2);
		
		//Generic 을 이용해서 Element type 을 제한 합니다.
		ArrayList<StudentDTO> members = new ArrayList<StudentDTO>();
		members.add(dto1);
		members.add(dto2);
		members.add(dto3);
		members.add(dto4);
		members.add(dto5);
		members.add(dto6);
		
		//DAO 의 특정 메서드에 이 정보를 보냅니다.
		//메서드 이름은 putDtos(ArraysList<StudentDTO>list) 형태가 됩니다.
		StudentDAO dao = StudentDAO.getInstance();
		dao.putDtos(members);
				
			}
}
