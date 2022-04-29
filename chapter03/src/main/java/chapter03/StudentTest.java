package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		 Student s1 = new Student();
		 s1.setGrade(1);
		 
		 Person p1 = s1; //upcasting (암시적이다, 자식을 부모로 캐스팅하는 경우) 
		                 // 암시적이기때문에 굳이 s1 앞에 (person)을 써줄필요가없다.
		 p1.setName("둘리");
		 
		 Student s2 = (Student) p1; // downcasting( 부모에서 자식으로 캐스팅하는 경우 명시해줘야한다)
		 s2.setMajor("cs");
	}

}
