package lab.itank.enumex;

public class EnumEx03 {
	
	enum Season{
		SPRING("봄", "3~6월"), SUMMPER("여름", "7~8월"), FALL("가을", "9~11월"), WINTER("겨율", "12~2월");
		
		String name;
		String term;
		
		Season(String name, String term){
			this.name = name;
			this.term = term;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
