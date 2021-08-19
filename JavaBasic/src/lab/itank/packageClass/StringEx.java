package lab.itank.packageClass;

public class StringEx {

	public static void main(String[] args) {
		//String 객체 생성법
		String str01 = new String("dog");
		
		char[] c = {'d', 'o', 'g'};
		String str02 = new String(c);
		
		String str03 = "dog";
		String str04 = "dog";
		String str06 = "dog";
		String str07 = "d";
		
		String str05 = new String("dog");
		
		System.out.println(str01 == str02);
		System.out.println(str03 == str04);  //new하지 않고 같은 문자열을 넣어주면 같은 주소값을 가진다
		System.out.println(str04 == str05);
		System.out.println(str02 == str03);
		System.out.println(str04 == str06);  //new하지 않고 같은 문자열을 넣어주면 새로운 객체를 만들않고 같은 곳에 넣어준다
		System.out.println(str04 == str07);  

		System.out.println("문자열 길이 =" + str01.length()); //3
		System.out.println("특정자리 문자 = " + str01.charAt(2)); //g
		
		//문자 추출
		String str08 = "teacher";
		System.out.println("일부 문자 추출 = " + str08.substring(3)); //3부터 끝까지
		System.out.println("일부 문자 추출 = " + str08.substring(0)); //0부터 끝까지
		System.out.println("일부 문자 추출 = " + str08.substring(1, 4)); //1부터 (4 - 1)까지
		
		//내용비교 
		String str09 = "friend";
		String str10 = "FRIEND";
		System.out.println(str09 == str10); 
		System.out.println(str09.equals(str10)); // 대소문자까지 확인하여 문자열 같은지 확인 flase
		System.out.println(str09.equalsIgnoreCase(str10)); //대소문자 무시하고 같은지 확인 true
		
		String str11 = "Good";
		String str12 = "Mother";
		System.out.println(str11.concat(str12)); //GoodMother  문자열 합쳐줌
		System.out.println(str11.concat(str12).substring(5)); //GoodMother 합쳐진 문자에서 5번부터 끝까지  //other 
		System.out.println(str11.concat(str12).charAt(5)); //GoodMother 합쳐진 문자에서 5번  //o 

		String str13 = "     space space    ";
		String str14 = "     space    ";
		String str15 = "space";
		System.out.println(str13.trim());  //space space
		System.out.println(str14.trim());  //space
		System.out.println(str13.equals(str14)); //false
		System.out.println(str14.trim().equals(str15)); //true
	}

}
