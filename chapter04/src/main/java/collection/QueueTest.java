package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
//		q.offer("마이콜");
//		q.offer("둘리");
//		q.offer("도우너");
//
//		while(!q.isEmpty()) {
//			String s = q.poll();
//			System.out.println(s);
//		}
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("도우너");

		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.peek());
		
		// Queue는 비어있어도 예외가 발생하지 않는다.
		
	}

}
