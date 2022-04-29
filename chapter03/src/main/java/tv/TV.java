package tv; // 

public class TV {
	private int channel; // 1~255까지 로테이션이된다.
	private int volume;  // 볼륨은 0~100까지 로테이션되는 기능이 있다.
	private boolean power;	

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}
	
	public void volume(int volume) {
		this.volume = volume;
		
	}

	public void status() {
		System.out.println("TV[channel= " + channel + " , volume=" + volume + ", power=" + 
				(power ? "on" : "off"));
	}
}
