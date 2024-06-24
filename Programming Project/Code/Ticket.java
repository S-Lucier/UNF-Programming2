/**
 * Contains ticket data
 */
public class Ticket implements Printable {

	// class variables
	private Customer customer;
	private String createdAt;
	private String ticketId;

	// constructor
	public Ticket(Customer customer, String createdAt, String ticketId) {
		this.customer = customer;
		this.createdAt = createdAt;
		this.ticketId = ticketId;
	}

	// converts Customer object to string representation in csv form
	@Override
	public String getFileData() {
		String fileData = customer.getCustomerId() + "," + customer.getFirstName() + "," + customer.getLastName() + ","
				+ ticketId + "," + createdAt;
		return fileData;
	}

	// getters and setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer c) {
		customer = c;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String s) {
		createdAt = s;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String s) {
		ticketId = s;
	}
}
