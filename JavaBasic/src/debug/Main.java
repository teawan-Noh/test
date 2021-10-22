package debug;

public class Main {

	public static void main(String[] args) {
		Counter count = new Counter();
		count.count();
		
		System.out.println("we have counted " + count.getResult());

	}

}
