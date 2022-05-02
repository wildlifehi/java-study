package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		
		// String method들..
//		String s1 = "aBcABCabcAbc";
//		System.out.println(s1.length()); // 문자열 길이 반납
//		System.out.println(s1.charAt(3)); // 3번지에있는 문자 반납
//		System.out.println(s1.indexOf("abc")); // abc 있는지 찾아보기
//		System.out.println(s1.indexOf("abc",7)); // abc 있는지 찾아보고, 없으면 -1 반납
//		System.out.println(s1.substring(3));
//		System.out.println(s1.substring(3,5));
		
		String s2 = "  ab  cd  ";
		String s3 = "efg,hij,klm,nop,qrs";
		
//		String s4 = s2.concat(s3);
//		System.out.println(s4);
//		
//		System.out.println("---"+s2.trim()+"---"); // space 전부 없애기.
//		System.out.println("---"+s2.replaceAll(" ", "") + "---"); 
				
		String[] tokens = s3.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s3.split(" ");
		for(String e : tokens2 ) {
			System.out.println(e);
			
		// +: String concat(연결) 연산자; 
		//	String s5 = "Hello" + "World" + "Java" + "1.8";
			String s5 = new StringBuffer("Hello")
				.append("World")
				.append("Java")
				.append(1.8).toString();
			
//			String s6 = "";
//			for (int i = 0 ; i < 1000000; i++) {
//				s6 = s6 + i;
				// s6 = new StringBuffer(s6).append(i).toString();
//			}
			
			StringBuffer sb6 = new StringBuffer("");
			for (int i = 0 ; i < 1000000; i++) {
				sb6.append(i);
			}
			
			String s7 = sb6.toString();
			System.out.println(s7.length());
			
			
			
		}
	}

}
