package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		// 서버 소켓 객체 생성
		ServerSocket serverSoket = new ServerSocket();

		// 바인드 192.168.0.26 10001
		serverSoket.bind(new InetSocketAddress("192.168.0.26", 10001));

		System.out.println("<서버시작>");
		System.out.println("==================================");
		System.out.println("[연결을 기다리고 있습니다.]");

		while (true) {// 억셉트 오면 출장 보내기(반복)
			// accept
			Socket socket = serverSoket.accept();
			System.out.println("[클라이언트가 연결 되었습니다.]");

			// 출장보내기 .start();
			Thread thread = new ServerThread(socket); // 누구랑 일할지 알려주는 것
			thread.start();

		}
		
		
		/*
		System.out.println("===============================");
		System.out.println("<서버종료>");
		serverSoket.close();
		*/

	}

}
