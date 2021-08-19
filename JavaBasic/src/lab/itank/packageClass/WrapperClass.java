package lab.itank.packageClass;

/*   WrapperClass : 기본형을 클레스형으로 바꿔주는 클레스들
 Byte
 Short
 Integer
 Long
 Float
 Double
 */

public class WrapperClass {

	public static void main(String[] args) {
		Integer i = new Integer(3);
		
		Integer i2 = 3; //오토박싱  (기본형 --> 클레스형)
		System.out.println(i2.equals(3)); //3을 오토박싱 해줘서 말이된다
		
		int i3 = i2;  //오토 언박싱(클레스형 --> 기본형)
		
		int a = Integer.parseInt("123");  // 숫자로된 문자열을 숫자로 바꿔줌

	}

}
