package thread;

public class UpperCaseAlphabet {
	public void print() {
		for(char c = 'A' ; c <= 'z' ; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
