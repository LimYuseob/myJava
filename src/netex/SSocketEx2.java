package netex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SSocketEx2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
	         // 40001포트를 열어두고 클라이언트의 요청을 기다린다.
	         serverSocket = new ServerSocket(40001);
	         System.out.println("[Server is Ready]");
	         
	         while(true) {
	        	 try {
	        		 System.out.println("서버가 연결요청을 기다립니다.");
	        		 
	        		 //특정 시간동안 연결이 이루어지지 않으면 예외를 발생시키는 메서드 필요
//	        		 serverSocket.setSoTimeout(5000);
	        		 
	        		 Socket socket = serverSocket.accept();
	        		 
	        		 //접속자의 IP get..
	        		 System.out.println(socket.getInetAddress());
	        		 System.out.println("접속된 유저의 포트 : " + socket.getPort());
	        		 System.out.println("바인딩된 port " + socket.getLocalPort());
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
	        		 
	        	 }catch (Exception e) {
	        		 System.out.println(e.getMessage());
				}
	         }
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	 private static String getTime() {
	      // TODO Auto-generated method stub
	      SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
	      return sdf.format(new Date());
	   }
}
