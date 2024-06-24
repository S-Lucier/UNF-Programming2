/**
 * Contains work order data
 */
public class WorkOrder implements Printable {
	
	// class variables
	private Employee employee;
	private Ticket ticket;
	private String createdAt;

	// constructor
	public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
		this.employee = employee;
		this.ticket = ticket;
		this.createdAt = createdAt;
	}

	// converts Workorder object to string representation in csv form
	@Override
	public String getFileData() {
		String fileData = ticket.getFileData() + "," + createdAt + "," + employee.getFileData();
		return fileData;
	}

	// getters and setters
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee e) {
		employee = e;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket t) {
		ticket = t;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String s) {
		createdAt = s;
	}
}
