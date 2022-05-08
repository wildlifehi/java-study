package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		
		char[] cha = str.toCharArray(); // 문자열을 char형 배열로 바꾸어주는 메소드

		char[] cha2 = new char[cha.length];
		
		for (int i = 0 ; i < cha.length ; ++i) {
			cha2[i]=cha[(cha.length-1)-i]; 
		}
		return cha2;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}