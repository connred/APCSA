import java.util.Date;

public class Staff extends Employee {
	private String title;

	public Staff(String name) {
		super(name);
	}

	public Staff(String name,String address, String phoneNumber, String email,double salary, String office, Date DateHired, String title) {
		super(name,address, phoneNumber, email, salary, office, DateHired);
		this.title = title;
	}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	@Override
	public String toString() {
		return super.toString() + " Title: " + getTitle();
	}
}
