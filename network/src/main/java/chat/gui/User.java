package chat.gui;

public class User {
	private String name;
	private static boolean master;
	
	public User(String name) {
		this.name = name;
		if(!master)
			master = true;
	}
	
	public static boolean getMaster() {
		return master;
	}
	public  String getName() {
		return name;
	}
	
}