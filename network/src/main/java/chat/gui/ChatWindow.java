package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;
import java.awt.List;

public class ChatWindow {
	private Frame frame;
	private Panel pannel;
	private Panel pannel2;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private List userList;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		pannel2 = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		userList = new List(4);
	}

	public void show() {
		try {	
			pw = new PrintWriter(new OutputStreamWriter(
					 socket.getOutputStream(),
					 "UTF-8"), true
					);

			br = new BufferedReader(new InputStreamReader(
									socket.getInputStream(),
									"UTF-8")
									);
				
			/**
			 * 1. UI 초기화
			 */
			// Button
			buttonSend.setBackground(new Color(112, 112, 112));
			buttonSend.setForeground(Color.WHITE);
			buttonSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					sendMessage();
				}
			});
	
			// Textfield
			textField.setColumns(80);
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char keyCode = e.getKeyChar();
					if(keyCode == KeyEvent.VK_ENTER) {
						sendMessage();
					}
				}
			});
				
			// Pannel
			pannel.setBackground(new Color(207, 207, 207));
			pannel.add(textField);
			pannel.add(buttonSend);
			frame.add(BorderLayout.SOUTH, pannel);
			
			// Pannel2
			pannel2.setBackground(new Color(158, 158, 158));
			pannel2.add(userList);
			frame.add(BorderLayout.EAST, pannel2);
	
			// TextArea
			textArea.setEditable(false);
			textArea.setBackground(new Color(158, 158, 158));
			frame.add(BorderLayout.CENTER, textArea);

			// Frame
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					finish();
				}
			});
			
			frame.setVisible(true);
			frame.pack();
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/**
		 * 3. Chat Client Thread 생성하고 실행
		 */
		new ChatClientThread().start();
	}
	private void userAdd(String user) {
		userList.add(user);
	}
	
	private void userRemove(int index) {
		userList.remove(index);
	}
	
	private void sendMessage() {
		if(!textField.getText().isEmpty()) {
			String message = textField.getText();
			textField.setText("");
			textField.requestFocus();
			pw.println("MESSAGE:" + message);	
		}
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		pw.println("QUIT:");
		try {
			if(socket != null && !socket.isClosed())
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * @author hwimin-kim
	 * Receive Thread from Chat Server
	 *
	 */
	private class ChatClientThread extends Thread {	
			
		@Override
		public void run() {
			try {					
				while(true) {
					String request = br.readLine();
					if(request  == null) {	
						ChatClientApp.log("closed by client");
						break;
					}else if("USERS".equals(request.split(":")[0])){
						int count = request.split(":").length;
						for(int i = 1; i<count  ;i++) {
							userAdd(request.split(":")[i]);
						}
					}else if("DELETE".equals(request.split(":")[0])){
						for(int i = userList.getItemCount() -1; i >=0 ; i--) {
							userRemove(i);
						}
					}else
						updateTextArea(request);
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
}