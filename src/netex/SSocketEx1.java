package netex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SSocketEx1 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      /*
       * ServerSocket 구현 방법 1. ServerSocket생성(port 번호 주고) 2. accept()호출 : 클라이언트의 요청이 올
       * 때까지 무한 루핑 3. 요청이 오면 accept()이 invoke(자동호출)되고 클라이언트로 1:1 연결된 Socket객체 리턴. 4.
       * Socket이 연결되면 in output stream연결 5. 데이터 주고받기.. 끝나면, 모두 닫기.
       */
      ServerSocket serverSocket = null;

      try {
         // 40001포트를 열어두고 클라이언트의 요청을 기다린다.
         serverSocket = new ServerSocket(40001);
         System.out.println("[Server is Ready]");

         // while을 통해 accept()가 호출되길 기다린다.
         while (true) {
            // 요청 연결되면 1:1 socket객체 리턴
            System.out.println(getTime() + "연결요청을 기다립니다.");
            Socket socket = serverSocket.accept();
            // 위 accept()이 호출되면 아래의 내용을 출력합니다.
            System.out.println(getTime() + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");
            
            //소켓으로부터 스트림 얻기
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            
            //클라이언트의 메세지 읽기..스트림을 BufferedReader 에 한방에 담기
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println(getTime() + " 에 클라이언트로부터 받은 메세지");
            System.out.println(br.readLine());
            
            dos.writeUTF("[MSG  From Server]안녕하세요. 유섭서버가 응답합니다.");
            System.out.println("클라이언트에 데이터 전송 완료");
            
            br.close();
            dos.close();
            socket.close();
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   private static String getTime() {
      // TODO Auto-generated method stub
      SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
      return sdf.format(new Date());
   }

}