package lab.itank;

//Object : �ֻ��� Ŭ���� (�����ϰ� �ƹ��͵� ��ӹ��� ����)
public class Parent { //extends Object�� �����Ǿ�����
	//�θ� Object�� �޼ҵ� 11�� �����Ǿ�����
	public static void main(String[] args) {
		
		Parent parent0 = new Parent();
		
		System.out.println("hashCode() = "+ parent0.hashCode()); //��ü�� ������ ��ȣ 
		System.out.println("getClass() = "+ parent0.getClass()); //��ü������ �Ҽ� ������ ������
		System.out.println("toString() = "+ parent0.toString()); //
		System.out.println("toString() ���� = "+ parent0); //
		
		Parent parent1 = new Parent();
		
		System.out.println(parent0.equals(parent1)); //��ü�� ������ ���� �Լ� 
		System.out.println(parent0.equals(parent0)); //��ü�� ������ ���� �Լ� 
		System.out.println(parent0 == parent0); //
		
		
	}
}
