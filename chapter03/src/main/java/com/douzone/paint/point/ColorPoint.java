package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint() {
	}
	
	public ColorPoint(int x, int y, String color) {
		//this.x = x;     	// this가 엑박뜨는 이유는 private으로 설정되어있기 때문에
		//this.y = y;			// 
		//setX(x);
		//setY(y);
		super(x,y); 
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color=" + color + "]을 그렸습니다.");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
