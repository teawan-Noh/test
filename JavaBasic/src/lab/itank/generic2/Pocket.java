package lab.itank.generic2;  

public class Pocket<T> { // <T> : generic class , T�ڸ����� Class �̸��� �� (�������� �ʾ����� T)
	
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}
