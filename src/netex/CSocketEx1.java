package netex;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Client Socket 은 Socket 생성시에 서버의 IP, Port 정보를 가지고 객체를 생성합니다.
 * 문제가 없다면, 이후 Stream 을 얻어내고 메세지를 송신 or 수신 합니다.
 * 지금은 서버에서 보낸 메세지를 수신만 하도록 정의합니다.
 */
public class CSocketEx1 {

   public static void main(String[] args) {
      try {
         String ip = "14.42.124.102"; int port = 40001;
         
         Socket socket = new Socket(ip, port);
         
         //연결된 소켓에 스트림을 얻어낸다
         DataInputStream dis = new DataInputStream(socket.getInputStream());
         
         String msg = "자바가 참 재미있어요.";
         //PrintWriter 를 이용해서 데이터 보내기..
         PrintWriter pw = null;
         BufferedWriter bw =null;
         OutputStream out = socket.getOutputStream();
         bw = new BufferedWriter(new OutputStreamWriter(out));
         pw = new PrintWriter(bw);
         
         //OutputStream 을 bw 객체로 변환 했으니, println() 을 이용해서
         //메세지 전송해봅니다.
         pw.println(msg);
         pw.flush();
         
         System.out.println("소켓으로 받은 데이터 출력합니다. : " + dis.readUTF());
         
         //스트림 종료, 소켓 종료
         dis.close();
         socket.close();
         System.out.println("연결이 해제됨.");
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}