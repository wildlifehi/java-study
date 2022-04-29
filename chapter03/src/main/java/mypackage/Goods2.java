package mypackage;

public class Goods2 {
	public String name; 	// 모든 접근이 가능(접근 제한이 없다)
	protected int price; 	// *자식 접근이 가능(이내용이 중요하다) + 같은 패키지
	int countStock;			// default, 같은 패키지
	private int countSold;	// 클래스 내부에서만 접근이 가능하다.
	
	public void m() {
		countSold = 10;
	}
}
