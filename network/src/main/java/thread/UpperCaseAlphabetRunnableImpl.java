package thread;

public class UpperCaseAlphabetRunnableImpl extends AlphabetThread implements Runnable {

	@Override
	public void run() {
		for(char c = 'A' ; c <= 'z' ; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		super.run();
	}
	

	
}
