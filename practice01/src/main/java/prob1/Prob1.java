package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		System.out.printf("숫자를 입력해주세요:");

		int in = scanner.nextInt();
		
		if (in % 3 == 0 ) {
			System.out.println("3의 배수입니다.");
		
		}else{
			System.out.println("3의 배수가 아닙니다");}
		scanner.close();
	}
}
