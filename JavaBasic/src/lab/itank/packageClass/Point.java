package lab.itank.packageClass;

public class Point {
	int x;
	int y;
	
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		
		if(this == obj)  //this = p01°´Ã¼
			return true;
			
		if(obj instanceof Point) {
			
			Point p = (Point)obj;
			
			if((x == p.x)&&(y == p.y)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Point p01 = new Point(3, 5);
		Point p02 = new Point(3, 5);
		
		System.out.println(p01.equals(p02));
	}
	
	
}
