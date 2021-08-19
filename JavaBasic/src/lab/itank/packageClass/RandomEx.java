package lab.itank.packageClass;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// 1.Math.random()
		// 0이상 1미만의 double 타입 난수(난수 : 랜덤하게 나오는수)
		//System.out.println(Math.random());
		
		int num0 = (int)3.7;
		//System.out.println(num0);
		
		//1~10
		int num = (int)(Math.random() * 10) + 1;
		//System.out.println(num);
		
		//1~100
		int num2 = (int)(Math.random() * 100) + 1;
		
		// 2.Random class
		Random random = new Random();
		System.out.println(random.nextInt(100)); //1~100까지 랜덤값
		System.out.println(random.nextInt(10)); //1~10까지 랜덤값
		System.out.println(random.nextInt(5)); //1~5까지 랜덤값
		System.out.println("================"); //1~5까지 랜덤값

		Random random2 = new Random(7777L);   // random(seed)  seed값이 할당되어있어 고정값이됨
		System.out.println(random2.nextInt(100)); //1~100까지 랜덤값
		System.out.println(random2.nextInt(10)); //1~10까지 랜덤값
		System.out.println(random2.nextInt(5)); //1~5까지 랜덤값
		
	}

}
