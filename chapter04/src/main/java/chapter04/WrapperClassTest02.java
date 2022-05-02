package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1); //<ㅡ String을 integer로 변환
		
		// cf1 반대로 해보기.
		String s2 = String.valueOf(i);  // <ㅡ integer를 String으로
		// cf2 반대로
		String s3 = "" + i;
		System.out.println(s1 + ":" + s2 + ":" + s3);
		
		char c = 'A';
		int a = Character.getNumericValue(c);
		System.out.println(a);
		
		// 2진수로 나타내기
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		// 16진수로 나타내기
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}
