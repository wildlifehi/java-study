package chapter04;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		printdate01(now);
		printDate02(now);
		
	}
	
	private static void printDate02(Date d) {
		
		// 년도는 1900을 더해주어야한다 2000년 밀레니엄시 컴퓨터가 망할줄 알고....
		int year = d.getYear();
		
		// 월은 0~11까지 있다. +1을 더해주어야한다.
		int month = d.getMonth();
		
		// 일
		int date = d.getDate();
		
		// 시
		int hours = d.getHours();
		
		// 분
		int minutes = d.getMinutes();
		
		// 초
		int seconds = d.getSeconds();
		
		System.out.println(
				(year + 1900) + "-" +
				(month + 1) + "-" + 
			    ((date < 10) ? "0" : "") + date + " " +
				hours + ":" +
			    minutes + ":" +
				seconds
				);
		
		
	}

	private static void printdate01 (Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
		String date = sdf.format(d);
		
		System.out.println(date);
	}

}
