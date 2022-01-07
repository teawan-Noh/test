import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Practice {
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
		
		HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
        
        int result2 = grade.remove("B");
        System.out.println(result2);  // 80 Ãâ·Â
        System.out.println(grade);
        
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);
        
        HashSet<Integer> num = new HashSet<>(numbers);
        System.out.println(num);
	}
}
