package lab.itank;

import java.util.Random;

public class RandomManager {
	
	//1~10������ ���� ���ڸ� ����� �����Ѵ�.
	public static int getRandomNumber() {
		
		Random random = new Random();
		int result = random.nextInt(10);
		
		return result;
	}
}
