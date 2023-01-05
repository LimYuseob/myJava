package utilex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//https://projectlombok.org/download 에서 최신 lombok.jar 를 c:\ 아닌 다른
//루트 드라이브에 다운받으세요...cmd창에 java -jar lombok.jar 입력.--> 설치할 이클립스 선택 화면 --> 설치&업데이트 -->이클립스 재부팅
//프로젝트 우클릭 --> new folder --> lib생성 --> lombok.jar 붙이기
//--> lombok.jar 우클릭 --> bulid path --> add to build path

//@Data : 이 어노테이션은 getter, setter, toString, hashCode, equals() 를 자동으로 생성해줍니다.
@Data
class Student {
   private String id;
   private String name;
   private int age;
}
//@NoArgsConstructor      //기본생성자를 포함시킨다.
//@AllArgsConstructor      //필드 초기화 생성자를 포함시킨다.
//@RequiredArgsConstructor   //기본적으로 생성자라 포함, 만약 final 또는 @notnull이 붙은 필드가 있다면 이 필드만 초기화하는 생성자를 포함.
//@Getter //getter 포함
//@Setter // Setter 포함
//@EqualsAndHashCode  //equal, hashCode포함
//@ToString  // tostring 포함

@NoArgsConstructor
@Data
@AllArgsConstructor

class Student2 {
   private String id;
   private String name;
   private int age;
}

@Data
class Student3 {
   private final String id = "Jenny";
   @NonNull private String name;
   private int age;
}

public class UseLombok {

   public static void main(String[] args) {
      Student stu1 = new Student();
      Student3 stu3 = new Student3("임유섭");
      
      System.out.println(stu1);
      System.out.println(stu3);
   }
}