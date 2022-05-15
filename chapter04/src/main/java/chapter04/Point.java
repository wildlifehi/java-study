package chapter04;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public static void main (String[] args) {

		Point p = new Point(4,6);

		System.out.println(p.toString());
	}
	
}

