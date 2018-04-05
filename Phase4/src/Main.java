import java.util.*;
import java.util.Date;


public class Main {
	List<String> people = new ArrayList<String>();
	Date date = new Date();
	
	Student student = new Student("John", "1237 W Nerd", "911", "nerd@icloud.com", "FRESHMEN");
	Faculty faculty = new Faculty("Steve", "1234 E", "913", "steve@aol.com", 10000, "South", date, "8AM-3PM", "President" );
	Staff staff = new Staff("Max", "1324 S", "923", "max@mail.com", 15000, "South", date,"Mr");
	String s1 = student.toString();
	String f1 = faculty.toString();
	String s2 = staff.toString();
}
