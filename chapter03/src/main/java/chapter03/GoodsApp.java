package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();	// Goods는 생성자를 만들었기 때문에 사용할 수 있는것이다.
		
		goods.setName("nikon");
		goods.setPrice(-1);
		goods.setCountSold(50);
		goods.setCountStock(30);
		
		goods.showInfo();
				
		Goods goods2 = new Goods("tv", 10000, 10, 10);
		goods2.showInfo();
		
		Goods goods3 = new Goods();
		System.out.println("Goods Count:" + Goods.countOfGoods );
				
		// discount price 구하기
		goods.setPrice(2000);
		int discountPrice = goods.calcDiscountPrice(0.5);
		System.out.println("Goods Discount Price:" + discountPrice);
	}

}
