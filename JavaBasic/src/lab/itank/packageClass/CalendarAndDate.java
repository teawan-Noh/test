package lab.itank.packageClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarAndDate {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();  //getInstance() : 객체 호출하는 메소드
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);  // 0부터 새기 때문에 +1해줘야 한다
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.AM_PM)); // 0:오전 1:오후 
		
		System.out.println(Calendar.AM); // 0:오전
		System.out.println(Calendar.PM); // 1:오후 
		
		if(calendar.get(Calendar.AM_PM) == Calendar.AM) {
			System.out.println("오전 입니다");
		}
		else {
			System.out.println("오후 입니다");
		}
		
		System.out.print(calendar.get(Calendar.HOUR)+":");
		System.out.print(calendar.get(Calendar.MINUTE)+":");
		System.out.println(calendar.get(Calendar.SECOND));
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss day");
		
		Date date = gregorianCalendar.getTime();
		System.out.println(date);
		
		String today = simpleDateFormat.format(date);
		System.out.println(today);
		
	}

}
