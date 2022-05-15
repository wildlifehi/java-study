package chat.gui;

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
	private List<Writer> listWriters;
	private List<User> listUsers;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters, List<User> listUsers) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.listUsers = listUsers;
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
				if("JOIN".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				}
				else if("MESSAGE".equals(tokens[0]))
					doMessage(tokens[1]);
				else if("QUIT".equals(tokens[0])) {
					doQuit(pw);
					break;
				}
				else 
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");					
			}
		} catch(SocketException ex) {
			System.out.println(ex);
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
		
		//ack
		pw.println("JOIN:OK");
		
		// 사용자 추가에 대한 유저 리스트 선행 삭제
		doUserListDelete();
		
		/*writer pool & User pool에 저장*/
		addWriter(writer);
		addUser(new User(nickname));
		
		// 사용자 추가에 대한 유저 리스트 업데이트
		doUserListUpdate();
		
		
		
		
		
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
	
	private void addUser(User user) {
		synchronized(listUsers) {
			listUsers.add(user);
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
	
//	private void doUserAdd(String name) {
//		synchronized(listWriters) {
//			for(int i=0; i < listWriters.size(); i++) {
//				if(!name.equals(listUsers.get(i).getName()))
//					pw.println("USER:" + name);
//			for(Writer writer : listWriters) {
//				PrintWriter printWriter = (PrintWriter)writer;
//				printWriter.println(nickname + ":"+ data);
//				printWriter.flush();
//			}
//		}
//	}
	
	private void doUserListUpdate() {
		System.out.println("유저리스트 업데이트 토큰 보냄");
		synchronized(listWriters) {
			String data = "USERS:";	
			for(int i=0; i< listUsers.size() ;i++) {
				if(i != listUsers.size()-1)
					data += listUsers.get(i).getName() + ":";
				else
					data += listUsers.get(i).getName();
			}
			
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
			
		}
	}
	
	private void doUserListDelete() {
		System.out.println("유저리스트 삭제 토큰 보냄");
		synchronized(listWriters) {
			String data = "DELETE:";
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
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