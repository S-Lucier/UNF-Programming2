/**
 * Contains customer data
 */
public class Customer extends Person implements Printable {

	// class variables
	private String customerId;
	private String accountNumber;

	// backup constructor
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email) {
		super(firstName, lastName, address, phoneNumber, email);
	};

	// main constructor
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email,
			String customerId, String accountNumber) {
		
		// assign parameters to class and superclass variables
		super(firstName, lastName, address, phoneNumber, email);
		this.customerId = customerId;
		this.accountNumber = accountNumber;
	}

	// converts Customer object to string representation in csv form
	@Override
	public String getFileData() {
		String fileData = customerId + "," + getFirstName() + "," + getLastName();
		return fileData;
	}

	// getters and setters for class variables
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String s) {
		customerId = s;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String s) {
		accountNumber = s;
	}
}
