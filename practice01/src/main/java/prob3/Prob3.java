package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("값을 입력해주십시오 : ");
		int num = scanner.nextInt();
		
		int sum = 0;
		
		if (num%2 == 0) {
			for( int i = 0 ; i <= num ; i= i+2 ) {
				sum = sum + i;
			}
			System.out.println("0부터" + num + "까지의 짝수 합은 "+sum+"입니다.");
			
		} else {
			for( int i = 1 ; i <= num ; i= i+2 ) {
				sum = sum + i;
				
			}
			System.out.println("0부터" + num + "까지의 홀수 합은 "+sum+"입니다.");
		}


		
		scanner.close();
	}
}
