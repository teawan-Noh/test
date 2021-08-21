package lab.intank.lamdba;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class LamdbaTest2 {

	public static void main(String[] args) {
		
		//void accept(T t);
		Consumer<String> consumer = (t) -> { //파라미터로 받은걸
			System.out.println(t); 			 //소비한다
		};
		
		IntConsumer intConsumer = (t) -> {System.out.println(t);};
		//intConsumer.accept(5);
		
		//Function<T, R>  R:return형 선택  //R apply(T t)
		Function<String, Integer> function = (t) -> {return 5;}; 
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		numbers.add(3);
		
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
		
		//Consumer<Integer> integerConsumer = (t) -> {System.out.println(t);};
		//numbers.forEach(integerConsumer);
		
		numbers.forEach((t) -> {System.out.println(t);});  //34,35번줄과 같음
		
		ArrayList<Dog> dogs = new ArrayList<>();
		
		dogs.add(new Dog("A"));
		dogs.add(new Dog("B"));
		dogs.add(new Dog("C"));
		dogs.add(new Dog("D"));
		
		dogs.forEach(
				(t)->{
					System.out.println(t.getName());
				}
			);
		//Function<T, R>  R:return형 선택  //R apply(T t)
		Function<Integer, String> fun = (i) -> {return dogs.get(i).getName();};
		//System.out.println(fun.apply(1).getName());
	}

}
