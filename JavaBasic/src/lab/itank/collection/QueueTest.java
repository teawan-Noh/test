package lab.itank.collection;

import java.util.LinkedList;

public class QueueTest {

	public static void main(String[] args) {
		
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		
		while(queue.peek()!=null) {
			System.out.println(queue.poll());
		}
		

	}

}
