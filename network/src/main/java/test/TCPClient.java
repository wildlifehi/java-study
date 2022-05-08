package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int  SERVER_PORT = 5555;
	public static void main(String[] args) {
		Socket socket = null;
		
			//ppt 오른편 만들어 볼 것.
		try {
			//1. 소켓 생성 (클라이언트 소켓(또는 데이터 소켓) 만들기)
			socket = new Socket(); 
		
			//2. 서버 연결 해보기
			socket.connect(new InetSocketAddress(SERVER_IP , SERVER_PORT));
			
			//3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("UTF-8"));
						
			//5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client] recevied: " + data);
			
		} catch (IOException e) {
			System.out.println("[client] error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
