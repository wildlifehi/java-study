package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.xml.crypto.Data;

public class TCPServer {
	public static void main(String[] args) {
		//ppt에 나온 대로 절차를 기술해줄것
		ServerSocket serverSocket = null ;
		
		try {
			//1. 서버소켓 생성(생성자도 오버로드가 되어있다)
			serverSocket = new ServerSocket();
			
			
			//1-1 TIME_WAIT 상태에서도 소켓 포트 번호를 할당이 가능하도록 하기 위해서...
			serverSocket.setReuseAddress(true);
			
			//2. 바인딩
			// Socket의 InetSocketAddress(IP Address + port)를 바인딩 한다.
			// IPAddress(0.0.0.0)는 특정 호스트 IP를 바인딩 하지 않는다. 
			// backlog : 요청 queue(10) << 5000포트 뒤에 10 부분 
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5555), 10);
			
			//3. accept
			// 클라이언트로부터 요청을 기다린다. (Listen이라고도 한다) (지금 ppt4 오른쪽 부분하는중)
			Socket socket = serverSocket.accept(); // 여기에서 blocking이 일어나 클라이언트가 찌를때까지 기다린다.
			
			//코드 구조상 위로 올라갈 수 없으니 여기서 위로 올라갈 수 있도록 작성하는 것 
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress(); // 부모의 클래스 값으로 리턴하기에 캐스팅을 해주어야한다.
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress(); // 반대편 소켓 어드래스를 달라고하는 것.
			int remoteHostPort = inetSocketAddress.getPort();
			System.out.println("[Server] connected by client[" +remoteHostAddress+ ":" + remoteHostPort + "]");
			
			try {
			//4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream(); 
			

				while(true) {			
					//5. 데이터 읽기.
					byte[] buffer = new byte[256];
					int	readByteCount = is.read(buffer); //여기서도 blocking이 이루어진다.
					if(readByteCount == -1 ) {
						//클라이언트가 정상적으로 종료, close()를 명시적으로 호출했음을 의미.
						System.out.println("[server] closed by client");
						break;
					}		
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: " + data);
					
					//6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
					
					
				}
			} catch(IOException ex) {
				System.out.println("[Server] error: " + ex);
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch(SocketException ex) {
				System.out.println("[Server] suddenly closed by client");
				}
			}
		}catch (IOException ex) {
			System.out.println("[Server] error: " + ex);
		
			ex.printStackTrace();
		} finally {
			try {
				if(serverSocket !=null && !serverSocket.isClosed()) {
					serverSocket.close();
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
