package chat.gui;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final String IP= "192.168.10.4";
	private static final int PORT = 6666;
	private static List<Writer> listWriters;
	private static List<User> listUsers;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		listWriters = new ArrayList<Writer>();
		listUsers = new ArrayList<User>()
				;
		try {
			
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩
			serverSocket.bind(new InetSocketAddress(IP, PORT));
			log("연결 기다림 " + IP + ":" + PORT);
			
			//3. 요청 대기
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters, listUsers).start();
			}
			
		} catch (IOException e) {
			log(" error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[Chat Server] " + log);
	}

}