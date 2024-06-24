/**
 * Contains tier 2 employee data
 */
public class Tier2Employee extends Employee implements Printable {

	// class variables
	private String certification;

	// constructor
	public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email,
			String employeeId, String clockedIn, String hiredDate, String certification) {

		// assign parameters to class and superclass variables
		super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
		this.certification = certification;
	}

	// converts Tier2Employee object to string representation in csv form
	@Override
	public String getFileData() {

		String fileData = getEmployeeId() + "," + getFirstName() + "," + getLastName() + "," + getClockedIn() + ","
				+ certification;
		return fileData;
	}

	// getters and setters for class variables
	public String getCertification() {
		return certification;
	}

	public void setCertification(String s) {
		certification = s;
	}
}
