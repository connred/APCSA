import java.util.Date;

public abstract class Employee extends Person {
	private double salary;
	private String office;
	private Date DateHired;

	public Employee(String name) {
		super(name);
	}
	public Employee(String name, String address, String phoneNumber, String email, double salary, String office,
			Date DateHired) {
		super(name, address, phoneNumber, email);
		this.salary = salary;
		this.office = office;
		this.DateHired = DateHired;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Date getDateHired() {
		return DateHired;
	}
	public void setDateHired(Date DateHired) {
		this.DateHired = DateHired;
	}
	@Override
	public String toString() {
		return super.toString() + " Salary: " + getSalary() + " Office: " + getOffice() + " Date Hired: " + getDateHired();
	}
}
