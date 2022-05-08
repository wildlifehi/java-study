package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		System.out.print("액수를 입력해 보시죠 : ");
		int money = scanner.nextInt();
		
		int m ;
		
		for (int i = 0; i < MONEYS.length ; i++) {
			m = money/MONEYS[i];
			money = money%MONEYS[i];
			if (m == 0) { continue; }
			System.out.println(MONEYS[i] + "원 " + m + "개" );
		}
		
		scanner.close();
 	}
}