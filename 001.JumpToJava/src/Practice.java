import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Practice {
	//10번
	 static void printCoffeePrice(String type) {
         HashMap<String, Integer> priceMap = new HashMap<>();
         priceMap.put("AMERICANO", 3000);  // 1: 아메리카노
         priceMap.put("ICE_AMERICANO", 4000);  // 2: 아이스 아메리카노
         priceMap.put("CAFE_LATTE", 5000);  // 3: 카페라떼
         int price = priceMap.get(type);
         System.out.println(String.format("가격은 %d원 입니다.", price));
     }
	public static void main(String[] args) {
		String a = "881120-1068234";
		String yymmdd;
		yymmdd = a.substring(0,6);
		String extra;
		extra = a.substring(7);
		System.out.println(extra);
		System.out.println(yymmdd);
		
		System.out.println(a.charAt(7));
		
		String c = "a:b:c:d";
		System.out.println(c.replaceAll(":", "#"));
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "3", "5", "4", "2"));
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
		String result = String.join(" ", list);
		System.out.println(result);
		
		//8번
		HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
        
        int result2 = grade.remove("B");
        System.out.println(result2);  // 80 출력
        System.out.println(grade);
        
        //9번
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);
        
        HashSet<Integer> num = new HashSet<>(numbers);
        System.out.println(num);
        
        //10번 (상단에 메소드 있음)
        printCoffeePrice("AMERICANO");  // "가격은 3000원 입니다." 출력
        printCoffeePrice("ICE_AMERICANO");  // NullPointerException 발생
	}
}
