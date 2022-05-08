package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.println(" < 숫자를 5개 입력해주셔야 합니다. > ");
		for (int i = 0 ; i < 5 ; i++ ) {

			System.out.print("숫자를 입력해주세요 : ");
			int num = scanner.nextInt();
			intArray[i] = num;
			
		}
			
		/* 배열에 저장된 정수 값 더하기 */
		
		for (int i = 0 ; i < 5 ; i++) {
			sum = sum + intArray[i];
		}
		
		/* 출력 */
		
		sum = sum/5;
		System.out.print("입력해주신 배열 [");
		for (int i = 0 ; i < 5 ; i++) {
			System.out.print(intArray[i]+" ");
		}
		System.out.println("] 의 평균은 " + sum + " 입니다.");
		
		/* 자원정리 */
		scanner.close();
	}
}
