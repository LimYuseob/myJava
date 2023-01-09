package ioex;
/*
 * 객체직렬화 및 Object InOutputStream : 객체를 통째로 파일이나, 특정 대상에 쓰고, 읽을 수 있는
 * 스트림입니다. 직렬화 대상 객체는 반드시 Serialzation 타입이어야 하며,
 * 직렬화해서 보내게 되면, 필드들과 그 값이 모두 전송되어 쓰여집니다.
 * 이때, 직렬화의 비대상 필드는 static, transient 필드 입니다.
 * static 의 클래스 소유이기 때문이고, transient 키워드는 휘발성 요소로 필드를
 * 관리할 때 사용됩니다.(예를 들어 중요한 정보는 객체직렬화에서 빼고 싶다면, transient 선언을 하면 됩니다.)
 * 직렬화 및 역직렬화 할때 JVM 은 같은 클래스 버전인지를 확인 후 역직렬화 합니다.
 * 따라서 특정 객체를 직렬화시 반드시 직렬화 버전(시리얼넘버) 를 유니크(Unique) 하게 줘야 하고
 * 두 값이 같아야 역직렬이 되어집니다. 기억하세요.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Builder //필드초기화 생성자를 동적으로 세팅하는 룸복 어노테이션.
@NoArgsConstructor
@AllArgsConstructor
@ToString
//직렬화 대상인 Member, Product 라는 클래스 정의 합니다. 모두 Serialization 을 구현합니다.
class Member implements Serializable{
	
	
	/**
	 *직렬화 클래스 versionID
	 */
	private static final long serialVersionUID = -2748961815571596973L;
	//직렬화 대상인 멤버필드를 선언 합니다.
	private String id;
	private String name;
	//아래 두개는 직렬화 대상에서 빠집니다.
	private static int clsNum = 612;
	private transient String passwor = "1234";
}
@ToString
@Builder
class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6370479361932124128L;
	private String name;
	private int price;
	
}
public class ObjectInOutEx {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("objectOut.dat");
		//객체 출력스트림 생성.
		ObjectOutputStream oop = new ObjectOutputStream(fos);
		
		//Member 객체생성하기.
		
		Member member = Member.builder()
		.id("yuseob")
		.name("유섭")
		.passwor("1234")
		.build();
		
		Product p = Product.builder()
		.name("맥북")
		.price(2500000)
		.build();
		
		int[] arr1 = {1,2,3};
		
		oop.writeObject(member);
		oop.writeObject(p);
		oop.writeObject(arr1);
		
		oop.flush();
		oop.close();
		
		System.out.println("객체가 파일에 잘 쓰여짐..");
		
		//쓰여진 객체를 역직렬화 해서 읽습니다.
		//역직렬화는 클래스의 버전을 보고 알아서 하기 때문에, 버전만 맞다면 그냥 읽기만 하면
		//됩니다.
		
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("objectOut.dat"));
		
		//읽을땐 쓴순서 그대로 읽어서 클래스 캐스팅을 통해 Ref 합니다.
		Member member2 = (Member)ios.readObject();
		Product p2 = (Product)ios.readObject();
		int[] arr2 = (int[])ios.readObject();
		
		ios.close();
		
		System.out.println(member2);
		System.out.println(p2);
		System.out.println(arr2);
		
		
		
	}

}
