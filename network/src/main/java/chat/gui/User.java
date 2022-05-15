package chat.gui;

public class User {
	private String name;
	private String grade;
	
	public User(String name) {
		this.name = name;
		this.grade = "[N]";
	}
	
	public  String getName() {
		return name;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
}