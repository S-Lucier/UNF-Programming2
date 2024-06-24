/**
 * Contains tier 1 employee data
 */
public class Employee extends Person implements Printable {

	// declare variables
	private String employeeId;
	private String clockedIn;
	private String hiredDate;

	// backup constructor
	public Employee(String firstName, String lastName, String address, String phoneNumber, String email) {
		super(firstName, lastName, address, phoneNumber, email);
	};

	// Main Constructor
	public Employee(String firstName, String lastName, String address, String phoneNumber, String email,
			String employeeId, String clockedIn, String hiredDate) {

		// assign parameters to class and superclass variables
		super(firstName, lastName, address, phoneNumber, email);
		this.employeeId = employeeId;
		this.clockedIn = clockedIn;
		this.hiredDate = hiredDate;

	}

	// converts Employee object to string representation in csv form
	@Override
	public String getFileData() {
		String fileData = employeeId + "," + getFirstName() + "," + getLastName() + "," + clockedIn;
		return fileData;
	}

	// getters and setters for class variables
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String newId) {
		employeeId = newId;
	}

	public String getClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(String newClockIn) {
		clockedIn = newClockIn;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String newHiredData) {
		hiredDate = newHiredData;
	}
}
