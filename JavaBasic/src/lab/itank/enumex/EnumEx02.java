package lab.itank.enumex;

import lab.itank.enumex.EnumEx01.Day;
import lab.itank.enumex.EnumEx01.Season;

public class EnumEx02 {

	public static void main(String[] args) {
		
		Season s = null;
		
		s = Season.SPRING;  
		s = Season.FALL;  
		
		System.out.println(s);
		
		Day[] days = Day.values();
		
		for (Day day : days) {
			System.out.println(day);
		}
	}
}
