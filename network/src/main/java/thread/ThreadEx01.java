package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
		//여기가 메인 스레드가 될 것.
//		for(int i = 0; i <= 10 ; i++) {
//			System.out.print(i);
//		}
		
		new DigitThread().start(); // 여기서
		
//		for(char c = 'a' ; c <= 'z' ; c++) {
//			System.out.print(c);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		

	}

}
