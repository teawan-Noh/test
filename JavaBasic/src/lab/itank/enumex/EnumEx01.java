package lab.itank.enumex;

//������ ������ ���� ������ Ÿ��
public class EnumEx01 {
	
	enum Season{
		SPRING, SUMMPER, FALL, WINTER
	}
	
	enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, FRIDAY, SATURDAY
	}
	
	
	public static void main(String[] args) {
		Season s = null;  //new Season �̷��� ���°� �ƴ϶�
		
		s = Season.SPRING;  //�̷��� ���� �ִ´�
		s = Season.FALL;  //Season�� �ִ� ���� ���� �� �ִ�
		
		System.out.println(s);
		
		Day[] days = Day.values();
		
		for (Day day : days) {
			System.out.println(day);
		}
	}
}
