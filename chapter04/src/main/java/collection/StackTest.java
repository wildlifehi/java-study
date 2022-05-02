package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>(); // 스택연산만 가능.
	
		s.push("물리");
		s.push("마이콜");
		s.push("도우너");
		
		
		System.out.println(s);
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		// System.out.println(s.pop()); : 비어있는 경우 '예외'가 발생한다.
		
		s.push("물리");
		s.push("마이콜");
		s.push("도우너");
		
		System.out.println(s.peek());
	}

}
