package lab.itank.enumex;

//한정된 값만을 갖는 데이터 타입
public class EnumEx01 {
	
	enum Season{
		SPRING, SUMMPER, FALL, WINTER
	}
	
	enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, FRIDAY, SATURDAY
	}
	
	
	public static void main(String[] args) {
		Season s = null;  //new Season 이렇게 들어가는게 아니라
		
		s = Season.SPRING;  //이렇게 값을 넣는다
		s = Season.FALL;  //Season에 있는 값만 넣을 수 있다
		
		System.out.println(s);
		
		Day[] days = Day.values();
		
		for (Day day : days) {
			System.out.println(day);
		}
	}
}
