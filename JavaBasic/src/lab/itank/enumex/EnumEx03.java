package lab.itank.enumex;

public class EnumEx03 {
	
	enum Season{
		SPRING("��", "3~6��"), SUMMPER("����", "7~8��"), FALL("����", "9~11��"), WINTER("����", "12~2��");
		
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
