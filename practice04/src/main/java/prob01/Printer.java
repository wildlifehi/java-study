package prob01;

public class Printer {

//	public <T> void println(T t) {  // 제네릭으로 생성하는 방법.
//		System.out.println(t);
//	}
	
	public <T> void println(T... ts) {  // 제네릭으로 생성하는 방법.
		for(T t : ts) {
		System.out.println(t + " ");
		}
	}

	public int sum(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum +=n;
		}
		return sum;
	}
}
