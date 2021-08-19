package lab.itank.generic2;  

public class Pocket<T> { // <T> : generic class , T자리에는 Class 이름이 들어감 (정해지지 않았을땐 T)
	
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}
