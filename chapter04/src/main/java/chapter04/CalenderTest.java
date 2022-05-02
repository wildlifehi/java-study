package chapter04;


import java.util.Calendar;

public class CalenderTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 11); // 12가 된다. MONTH는 +1이되므로.
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		
		cal.set(2021, 4, 15); // 기념하고 싶은 날. 가운데 month는 4+1이 됨을 인지!!
		cal.add(Calendar.DATE, 1);
		printDate(cal);
	
		

	}

	private static void printDate(Calendar cal) {
		
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일요일)~7(토요일)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year +  "년 " +
				(month + 1 < 10 ? "0" : "") + (month+1) + "월 " +
			    ((date < 10) ? "0" : "") + date + "일 " +
				DAYS[day-1] + "요일 " + 
				hour + ":" +
			    minute + ":" +
				second
				);

				
		
	}

}
