package netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


public class MultiChatSever {
	HashMap clients;
	//채팅 사용자의 소켓 정보 및 스트림 정보를 관리하는 HashMap 선언.
	
	public MultiChatSever() {
		//생성자를 통해 맵객체 초기화 및 동기화된 맵 get
		clients = new HashMap();
		//아래의 Collections 메서드를 이용하면 동기화가 자동 적용된 Map 객체로 변환됩니다.
		Collections.synchronizedMap(clients);
	}
	public void start() {
		//서버소켓 생성 및 클라이언트 별 쓰래드 생성 구현
		try {
			ServerSocket sSocket = new ServerSocket(40001);
			System.out.println("서버시작됨..");
			Socket socket = null;
			
			while(true) {
				socket=sSocket.accept();
				System.out.println(socket.getInetAddress() + "의 사용자가 " + 
				socket.getPort() + " 로 접속함");
				
				//생성된 소켓을 쓰래드에 넘김..
				ServerReciever thread = new ServerReciever(socket);
				thread.start();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	//접속된 모든 사용자에게 Broadcasting(한곳에서 다중으로 일방적으로 송출을 뜻함) 메서드 정의
	public void sendToAll(String msg) {
		//클라이언트의 키 정보를 Iterator 를 리턴받느낟.
		Iterator it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out =
							(DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new MultiChatSever().start();
	}
	//서버 리시버 클래스를 inner 로 정의 합니다..
	//Outer의 멤버와 메서드를 사용하기 위함입니다..
	class ServerReciever extends Thread{
		
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		public ServerReciever(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				System.out.println("서버 리시버 쓰래드 스트림 예외 : " + e.getMessage());
				}
			}
		@Override
		public void run() {
			String name = "";
			
			try {
				name = in.readUTF();
				
				sendToAll("[" + name + "] 님이 입장하였습니다.");
				
				//접속한 사용자의 name 을 key , outputStream 객체를 Value 로 넣어준다
				clients.put(name, out);
				System.out.println("현재 접속자 수 : " + clients.size());
				while(in != null) {
					sendToAll(in.readUTF());
				}
			} catch (Exception e) {
				System.out.println("쓰래드의 클라이언트 메세지 전송 예외 : " + e.getMessage());
			}finally {
				sendToAll(name + " 님이 채팅을 나갔습니다.");
				clients.remove(name);
				System.out.println("현재 사용자 수 : " + clients.size());
			}
		}
		}
	}

