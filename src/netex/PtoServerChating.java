package netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//송신을 담당하는 쓰래드 클래스 정의
//이 클래스는 송신을 담당하기 때문에 송신 대상 즉, Socket 정보가 필요합니다.
//따라서 필드로 Socket 을 선언하고, 객체화시에 초기화 합니다.
//이후 얻어낸 소켓대상에 사용자의 입력(Scanner) 을 기다리다가, 입력된 값을 Socket 대상에게
//sending 하는 역활을 합니다.
class Sender extends Thread{
	Socket socket;
	DataOutputStream dos;
	String userName;
	
	//생성자정의..객체생성시에 Socket 객체를 초기화 합니다.
	public Sender(Socket socket,String name) {
		this.socket = socket;
		this.userName = "[" + name + "] ";
		//얻어낸 소켓을 이용 OutputStream 얻어내서 dos 바인딩 합니다.
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			
			userName = "[Yuseob] : ";
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println(e.getMessage());
		}
	}
	//run() 오버라이드..얻어낸 소켓에 사용자의 입력을 writeUTF()로 보냅니다.
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(dos != null) {
			try {
				dos.writeUTF(userName + sc.nextLine());
		}catch (Exception e) {
			System.out.println("송신예외 발생 함 " + e.getMessage());
			}
		}
	}
}
/*
 * 메세지 수신 쓰래드 정의 : run() 에는 연결된 소켓으로 부터 오는 메세지를 readUTF() 로
 * 읽어서 콘솔에 출력합니다. 이를 위해서 Socket 정보와 여기서 할당 받은 InputStream 을
 * DataInputStream에 바인딩 하여 구현토록 합니다.
 */
class Reciever extends Thread{
	Socket socket;
	DataInputStream dis;
	
	public Reciever(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void run() {
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
	

public class PtoServerChating {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(40001);
			socket = serverSocket.accept();
			
			//쓰래드에 소켓 주고 start() 시킴.
			Thread senderThread = new Sender(socket, "Server Yuseob");
			Thread recieveThread = new Reciever(socket);
			senderThread.start();
			recieveThread.start();
			
			if(serverSocket.isBound()) {
				serverSocket.close();
			}
		}catch (Exception e) {
			System.out.println("서버소켓 예외 발생 : " + e.getMessage());
		}
	}

}
