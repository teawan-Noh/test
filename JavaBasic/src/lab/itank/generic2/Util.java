package lab.itank.generic2;

public class Util {
	public void putAll(Pocket<?> pocket) {}  //�ƹ��ų� ����
	
	public void putJewel(Pocket<? extends Jewel> pocket) {} //Jewel�� �����Ͽ� ��ӹ��� Ŭ������ 
	
	public void putRing(Pocket<? extends Ring> pocket) {}	//Ring�� �����Ͽ� ��ӹ��� Ŭ������ 
	
	public void putEarRing(Pocket<? super EarRing > pocket) {}  //EarRing�� �����Ͽ� �θ��� Ŭ������
	
	//public <T extends Ring> void putRing(Pocket<T> pocket) {}  8���ٰ� ���� T: Ring�� ��ӹ��� T
	
	//public <T super EarRing> void putEarRing(Pocket<T> pocket) {}  // super�� �̷��� ���� �ȵ� 
	//public <T> void putRing(Pocket<T extends Ring> pocket) // <T>�� ������ ������ <T extends Ring>: ��ӹ޴°� �ȵ� 12���ٸ� ����
}
