package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		String k1 = "one";
		m.put("one", 11); // auto boxing이 일어났다.
		m.put("two", 2); 
		m.put("three", 3);
		
		System.out.println(m.get("one"));
		
		int i = m.get("one"); // 오토 박싱
		int j = m.get(new String("one"));
		
		System.out.println(i + ":" + j);
		
		m.put("three", 3333333);
		System.out.println(m.get("three"));
		
		// 순회하기
		Set<String> s = m.keySet();
		for(String key : s) {
			System.out.println(m.get(key));
		}
		
		
	}

}
