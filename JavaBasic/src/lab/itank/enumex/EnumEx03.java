package lab.itank.enumex;

public class EnumEx03 {
	
	enum Season{
		SPRING("º½", "3~6¿ù"), SUMMPER("¿©¸§", "7~8¿ù"), FALL("°¡À»", "9~11¿ù"), WINTER("°ÜÀ²", "12~2¿ù");
		
		String name;
		String term;
		
		Season(String name, String term){
			this.name = name;
			this.term = term;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTerm() {
			return term;
		}

		public void setTerm(String term) {
			this.term = term;
		}
		
		
	}

	public static void main(String[] args) {
		
		Season[] seasonArray = Season.values();
		
		for (Season season : seasonArray) {
			System.out.println(season);
		}
		
		System.out.println(Season.SPRING.getName());
		System.out.println(Season.SPRING.getTerm());
		
		Season.SPRING.setName("º½º½º½");
		System.out.println(Season.SPRING.getName());
	}

}
