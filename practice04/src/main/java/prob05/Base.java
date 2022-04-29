package prob05; //오버라이딩 문제.

public class Base {
	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else {
			night();
		}
	}
	
	public void day(){
		System.out.println("낮");
	}
	
	public void night(){
		System.out.println("night");
	}
}
