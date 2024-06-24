/**
* Contains general person data, name, phone number, etc.
*/
public class Person implements Printable{

	// declare variables
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	
	// Constructor
	public Person(String firstName, String lastName, String address, String phoneNumber, String email) {
		
		//assign parameters to class variables
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	//the UML chart says to implement printable even for classes we where we don't use it.
	@Override
	public String getFileData() {
		String fileData = firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email;
		return fileData;
	}
	
	// getters for class variables
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	// setters for class variables
	public void setFirstName(String s) {
		firstName = s;
	}

	public void setLastName(String s) {
		lastName = s;
	}

	public void setaddress(String s) {
		address = s;
	}

	public void setPhoneNumber(String s) {
		phoneNumber = s;
	}

	public void setEmail(String s) {
		email = s;
	}
}
