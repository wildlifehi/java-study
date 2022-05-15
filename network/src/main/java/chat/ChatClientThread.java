package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {	
		try {			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				String request = br.readLine();
				if(request  == null) {					
					ChatClient.log("closed by client");
					break;
				}
				System.out.println(request);
			}
		} catch(SocketException ex) {
			System.out.println("[server] suddenly close by clinet:" + ex);
		} catch(IOException ex) {
			System.out.println("[server] error:" + ex);
		} finally {
			try {
				if(socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}