package lab.itank.packageClass;

/*   WrapperClass : �⺻���� Ŭ���������� �ٲ��ִ� Ŭ������
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
		
		Integer i2 = 3; //����ڽ�  (�⺻�� --> Ŭ������)
		System.out.println(i2.equals(3)); //3�� ����ڽ� ���༭ ���̵ȴ�
		
		int i3 = i2;  //���� ��ڽ�(Ŭ������ --> �⺻��)
		
		int a = Integer.parseInt("123");  // ���ڷε� ���ڿ��� ���ڷ� �ٲ���

	}

}
