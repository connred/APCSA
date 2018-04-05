import java.util.Date;

public class Faculty extends Employee {
	private String officeHours;
	private String rank;
	public Faculty(String name) {
		super(name);
	}
	public Faculty(String name, String address, String phoneNumber, String email, double salary, String office, Date DateHired, String officeHours, String rank) {
		super(name,address,phoneNumber,email, salary, office, DateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return super.toString() + " Office Hours: " + getOfficeHours() + " Rank: " + getRank();
	}
}
