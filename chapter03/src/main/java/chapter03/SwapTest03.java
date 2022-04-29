package chapter03;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);
		
		System.out.println(a.val + ":" + b.val);
		  
		swap(a, b);
		
		System.out.println(a.val + ":" + b.val);
	}

	public static swap(Value p, Value q) {
		//아까전에는 값을 그대로 넘긴것이고, 지금은 객체의 레퍼런스를 넘긴 것이다.
		
		/* swap */
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}
}
