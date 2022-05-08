package prob5;

public class Prob5 {

	public static void main(String[] args) {

	
	for (int i=1; i<=99; i++) {

		// 10의 자리가 0이 아닌 3의 배수입니까?
		if( i/10 != 0 && (i/10)%3 == 0) {
			
			//예라면, 1의 자리가 0이 아닌 3의 배수입니까?
			if ( i%10 != 0 && (i%10)%3 == 0 ) {
				System.out.println(i + " 짝짝");
			} else {
				System.out.println(i + "짝");
			}
							
			//아니오
		
		// 그럼 1의 자리는 0이 아닌 3의 배수입니까?
		}else if( i%10 != 0 && (i%10)%3 == 0 ) {
			//예
			System.out.println(i + " 짝");
		}
		
		
	}
	
	
	
	}
}
