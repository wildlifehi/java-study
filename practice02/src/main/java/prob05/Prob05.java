package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			
			System.out.print("랜덤 번호가 생성되었습니다. 1~100 중 예상되는 숫자를 입력해주세요 : ");
			int i = scanner.nextInt();
			while (correctNumber != i) {
				if (correctNumber > i ){
					System.out.println("up");
				} else {
					System.out.println("down");
				}
				System.out.print("숫자를 다시 입력해주세요 : ");
				i = scanner.nextInt();
			}
			
			System.out.println("정답입니다!!");

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}