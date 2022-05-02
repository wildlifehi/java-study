package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");
		
		// 순회1 ; 순회를 해보자.
		for (int i = 0 ; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}

		// 삭제
		v.removeElementAt(2);
		
		// 순회2              >>> 벡터만 이렇게 쓸 수 있음을 기억하도록.
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
		
	}

}
