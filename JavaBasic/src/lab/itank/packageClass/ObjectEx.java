package lab.itank.packageClass;

//Object : �ֻ��� Ŭ���� (�����ϰ� �ƹ��͵� ��ӹ��� ����)
public class ObjectEx { //extends Object�� �����Ǿ�����
	//�θ� Object�� �޼ҵ� 11�� �����Ǿ�����
	public static void main(String[] args) {
		
		ObjectEx parent0 = new ObjectEx();
		
		System.out.println("hashCode() = "+ parent0.hashCode()); //��ü�� ������ ��ȣ 
		System.out.println("getClass() = "+ parent0.getClass()); //��ü������ �Ҽ� ������ ������
		System.out.println("toString() = "+ parent0.toString()); //
		System.out.println("toString() ���� = "+ parent0); //
		
		ObjectEx parent1 = new ObjectEx();
		
		System.out.println(parent0.equals(parent1)); //��ü�� ������ ���� �Լ� 
		System.out.println(parent0.equals(parent0)); //��ü�� ������ ���� �Լ� 
		System.out.println(parent0 == parent0); //
		
		
	}
}
