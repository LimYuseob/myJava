package netex;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class InetEx2_Soket {

	public static void main(String[] args) {
		byte[] remoteAddr = {14,42,124,125};
		int port = 8080;
		String uri = "/web_program/04/Lesson04_JS.html";
		
		InetAddress ia = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader br = null;
		
		try {
			//쌤 서버에 접속해 본다.
			ia = InetAddress.getByAddress(remoteAddr);
			//System.out.println(ia.getHostName());
			
			//연결이 잘 되었으면 스트림을 얻어낸다.
			//지금은 서버에 브라우저로 요청한것과 같은 효과를 내기 위해
			//in/out stream 모두를 연결합니다.
			socket = new Socket(ia, 8080);//8080포트에 소켓생성
			
			out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("모든 스트림 잘 연결됨");
		}catch (Exception e) {
			System.out.println("연결 오류 : " + e.getMessage());
		}
		/*
		 * 웹브라우저 처럼 우리가 접근 하려는곳이 웹서버이기 때문에
		 * 기본요청 메서드인 GET 을 요청헤더에 포함시켜, 요청문서 정보를 보냅니다.
		 * 이때, 문서가 올바르게 존재 한다면, 스트림을 통해 문서의 내용을 얻어냅니다.
		 */
		
		out.println("GET http://" + ia.getHostAddress() + uri);
		out.flush();
		
			try {
				while(true) {
				String str = br.readLine();
				if(str == null) {
					break;
			}
				System.out.println(str);
			}
				
				socket.shutdownInput();
				socket.shutdownOutput();
				socket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

