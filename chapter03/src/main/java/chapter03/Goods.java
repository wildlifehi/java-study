package chapter03;

public class Goods {
	public static int countOfGoods;	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
	}
	
	
	
	public Goods(String name, int price, int countStock, int countSold) {
		
		//생성자 만들기, 이걸 안만들면 컴파일러가 기본생성자를 넣는다.
		// 왜 넣어주는가? >> 객체를 생성하기 위해서.  
		Goods.countOfGoods++; // 이는 Goods.countOfGood += 1;  Goods.countOfGood = Goods.countOfGood + 1; 와같다.
		
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold ; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		// 데이터 보호
		if(price < 0) {
			price = 0;
		}			
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	

	public void showInfo() {
		System.out.println(
				"name:" + name + 
				", price:" + price +
				", countStock:" + countStock +
				", countSold:" + countSold );
		
	}
	
	public int calcDiscountPrice(double discountRate) {
		return (int)(discountRate * price);
	}
}	