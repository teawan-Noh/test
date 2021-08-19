package lab.itank.packageClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarAndDate {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();  //getInstance() : ��ü ȣ���ϴ� �޼ҵ�
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);  // 0���� ���� ������ +1����� �Ѵ�
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.AM_PM)); // 0:���� 1:���� 
		
		System.out.println(Calendar.AM); // 0:����
		System.out.println(Calendar.PM); // 1:���� 
		
		if(calendar.get(Calendar.AM_PM) == Calendar.AM) {
			System.out.println("���� �Դϴ�");
		}
		else {
			System.out.println("���� �Դϴ�");
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
