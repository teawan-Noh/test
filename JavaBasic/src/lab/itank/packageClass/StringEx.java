package lab.itank.packageClass;

public class StringEx {

	public static void main(String[] args) {
		//String ��ü ������
		String str01 = new String("dog");
		
		char[] c = {'d', 'o', 'g'};
		String str02 = new String(c);
		
		String str03 = "dog";
		String str04 = "dog";
		String str06 = "dog";
		String str07 = "d";
		
		String str05 = new String("dog");
		
		System.out.println(str01 == str02);
		System.out.println(str03 == str04);  //new���� �ʰ� ���� ���ڿ��� �־��ָ� ���� �ּҰ��� ������
		System.out.println(str04 == str05);
		System.out.println(str02 == str03);
		System.out.println(str04 == str06);  //new���� �ʰ� ���� ���ڿ��� �־��ָ� ���ο� ��ü�� ����ʰ� ���� ���� �־��ش�
		System.out.println(str04 == str07);  

		System.out.println("���ڿ� ���� =" + str01.length()); //3
		System.out.println("Ư���ڸ� ���� = " + str01.charAt(2)); //g
		
		//���� ����
		String str08 = "teacher";
		System.out.println("�Ϻ� ���� ���� = " + str08.substring(3)); //3���� ������
		System.out.println("�Ϻ� ���� ���� = " + str08.substring(0)); //0���� ������
		System.out.println("�Ϻ� ���� ���� = " + str08.substring(1, 4)); //1���� (4 - 1)����
		
		//����� 
		String str09 = "friend";
		String str10 = "FRIEND";
		System.out.println(str09 == str10); 
		System.out.println(str09.equals(str10)); // ��ҹ��ڱ��� Ȯ���Ͽ� ���ڿ� ������ Ȯ�� flase
		System.out.println(str09.equalsIgnoreCase(str10)); //��ҹ��� �����ϰ� ������ Ȯ�� true
		
		String str11 = "Good";
		String str12 = "Mother";
		System.out.println(str11.concat(str12)); //GoodMother  ���ڿ� ������
		System.out.println(str11.concat(str12).substring(5)); //GoodMother ������ ���ڿ��� 5������ ������  //other 
		System.out.println(str11.concat(str12).charAt(5)); //GoodMother ������ ���ڿ��� 5��  //o 

		String str13 = "     space space    ";
		String str14 = "     space    ";
		String str15 = "space";
		System.out.println(str13.trim());  //space space
		System.out.println(str14.trim());  //space
		System.out.println(str13.equals(str14)); //false
		System.out.println(str14.trim().equals(str15)); //true
	}

}
