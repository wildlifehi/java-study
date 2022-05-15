package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "192.168.10.4";
	private static final int SERVER_PORT = 8888;
	
	public static void main(String[] args) throws IOException {
		String name = null;
		Socket socket = null;
		Scanner scanner = null;
		
			//1. 소켓 및 키보드 생성
			socket = new Socket();
			scanner = new Scanner(System.in);
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			//3. get iostream(pipline established)
			PrintWriter pw = new PrintWriter(
							 new OutputStreamWriter(
							 socket.getOutputStream(),
							 "UTF-8"), true
							 );
			
			BufferedReader br = new BufferedReader(
								new InputStreamReader(
								socket.getInputStream(),
								"UTF-8")
								);
			
			while( true ) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (name.isEmpty() == false ) {
					break;
				}
				
				System.out.println("대화명은 한 글자 이상 입력해야 합니다.\n");
			}
			// 자원 종료
			scanner.close();

			//4. join protocol 처리
			pw.println("JOIN:" + name);
			String line = br.readLine();
			if("JOIN:OK".equals(line)) {
				System.out.println(line);
				new ChatWindow(name,socket).show();
			}
			
		
	}
	
	static void log(String log) {
		System.out.println("[Chat Client]" + log);
	}

}