package com.douzone.paint.main; // 자기가 속한 패키지를 여기에 명시

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;

import com.douzone.paint.shape.Rectangle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		//Point point1 = new Point(); //
		//point1.setX(20);
		//point1.setY(10);
		// point1.show();
		Point point1 = new Point(20, 10); //
		draw(point1); 
		
		Point point2 = new Point(50, 100);  // 오버로딩을 하고있다.
		draw(point2);
		point2.show(false);
		
		ColorPoint point3 = new ColorPoint(40, 50, "red");
		//drawColorPoint(point3);
		//이제 포인트를 그리고싶다
		point3.show(true);
	
		Triangle triangle = new Triangle();
		draw(triangle);
		
		Rectangle rectangle = new Rectangle();
		draw(rectangle);
	
		Circle circle = new Circle();
		draw(circle);
		
		GraphicText graphictext = new GraphicText("hello World");
		draw(graphictext);
		
		// instanceof 연산자 테스트
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		// 아래의 것은 오류가 난다 : class는 hierachy 이므로 상위와 하위만 instanceof 연산자를 사용할 수 있다. 
		// System.out.println(circle instanceof Rectangle);
		// 인터페이스는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
		
		
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//}
//
//	public static void drawShape(Shape shape) {
//		shape.draw(); // 자식이 구현해놓은 shape 
//	
//	}
	

//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
		
}
