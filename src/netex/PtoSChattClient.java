package netex;

import java.io.IOException;
import java.net.Socket;

public class PtoSChattClient {

	public static void main(String[] args) {
		
		/*
		 * 서버에 소켓 연결후 연결됨 소켓을 쓰래드에 바인딩후
		 * 쓰래드 start() 시킵니다.
		 */
		String severIp = "14.42.124.102";
		int port = 40001;
		
		try {
			Socket socket = new Socket(severIp, port);
			
			Thread sThread = new Sender(socket, "Yuseob");
			Thread rThread = new Reciever(socket);
			
			sThread.start();
			rThread.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
