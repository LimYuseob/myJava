package ioex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
    * 이 클래스에서는 byte[]을 이용해서 JVM 메모리(가상 메모리)에 데이터를 쓰고 읽는 예제이다.
    * byte[]을 쓸 땐 문제가 없지만 읽을 때는 새롭게 읽은 개수를 리턴하는 것에 대해 주의해야 한다.
    */
public class UseBArrStreamEx2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      byte[] outSrc = null;

      byte[] temp = new byte[4];

      // byte배열에 쓰는 객체 선언
      ByteArrayInputStream input = null;
      ByteArrayOutputStream output = null;

      input = new ByteArrayInputStream(inSrc); // 스트림 오픈
      output = new ByteArrayOutputStream(); // 스트림 오픈
      try {
         while (input.available() > 0) {
            int count = input.read(temp);
            System.out.println("읽은 개수" + count);
//            input.read(temp);
            
            if(count == -1)
               break;
            
            output.write(temp);
            System.out.println("temp : " + Arrays.toString(temp));
         }
      } catch (Exception e) {

      }
   }
}