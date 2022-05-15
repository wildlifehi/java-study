package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private static List<Writer> listWriters;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	public void run() {	
		//1. Remote Host Information
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetSocketAddress.getPort();
		
		ChatServer.log("connected by clinet[" + 
						remoteHostAddress + ":" + 
						remoteHostPort + "]"
					  );
		
		try {	
			//2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//3. 요청 처리
			while(true) {
				String request = br.readLine();
				if(request  == null) {					
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}	
				
				//4. 프로토콜 분석
				String[] tokens = request.split(":");
				if("join".equals(tokens[0]))
					doJoin(tokens[1], pw);
				else if("message".equals(tokens[0]))
					doMessage(tokens[1]);
				else if("quit".equals(tokens[0]))
					doQuit(pw);
				else 
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");							
			}
		} catch(SocketException ex) {
			ChatServer.log(" suddenly close by clinet:" + ex);
		} catch(IOException ex) {
			ChatServer.log(" error:" + ex);
		} finally {
			try {
				if(socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/*writer pool에 저장*/
		addWriter(writer);
		
		//ack
		pw.println("join:ok");
	}

	private void broadcast(String data) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}

	private void doMessage(String data) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(nickname + ":"+ data);
				printWriter.flush();
			}
		}
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}
}