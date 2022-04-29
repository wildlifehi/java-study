package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		  
		swap(a, b);
		
		System.out.println(a + ":" + b);
	}

	public static swap(int p, int q) {
		/* swap */
		int c = q;
		q = p;
		p = c;
	
	}
}
