package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		Integer i = new Integer(10); // 이건 error가 아니라 deprecated
		Character c = new Character('C');
		Boolean b = new Boolean(true);
		
		
		// Auto Boxing
		Integer j1 = 10 ;
		Integer j2 = 20 ;

		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		// Auto UnBoxing 객체 안에 있는 값이 호출될때 기본값으로 나오는 것
		int m = j1.intValue() + 10;
		
	}

}
