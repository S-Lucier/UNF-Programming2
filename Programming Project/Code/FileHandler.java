import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Handles file interactions, including logging
 */
public class FileHandler {

	/**
	 * Reads employee data, creates employee object for each, adds to employeeList
	 * 
	 * @param employeeFileName The file name to read
	 */
	public static void readEmployeeData(String employeefileName) throws FileNotFoundException {

		// log
		FileHandler.logger("Loading Employee Data");

		// declare scanner
		File inputFile = new File(employeefileName);
		Scanner scnr = new Scanner(inputFile);

		// declare arrayList for all unseparated String lines of the file
		ArrayList<String> unseperatedLines = new ArrayList<String>();

		// read in data to arrayList
		while (scnr.hasNextLine()) {
			unseperatedLines.add(scnr.nextLine());
		}

		// close file scanner, remove first line of unseperatedLines, as it's the header
		// line and isn't needed
		scnr.close();
		unseperatedLines.remove(0);

		// for each line in unseperatedLines, separate at comma locations and add to
		// relevant Employee object, add that to employeeList
		for (int i = 0; i < unseperatedLines.size(); ++i) {

			// declare current line for ease of writing reasons - otherwise I'd have to use
			// unseperatedLines.get(i) each time
			String currentLine = unseperatedLines.get(i); // this might also improve performance

			// find all nine comma locations
			int one = -1;
			int two = -1;
			int three = -1;
			int four = -1;
			int five = -1;
			int six = -1;
			int seven = -1;
			int eight = -1;
			int nine = -1;
			for (int j = 0; j < currentLine.length(); ++j) {
				if (currentLine.charAt(j) == ',') {
					if (one == -1) {
						one = j;
					} else if (two == -1) {
						two = j;
					} else if (three == -1) {
						three = j;
					} else if (four == -1) {
						four = j;
					} else if (five == -1) {
						five = j;
					} else if (six == -1) {
						six = j;
					} else if (seven == -1) {
						seven = j;
					} else if (eight == -1) {
						eight = j;
					} else if (nine == -1) {
						nine = j;
					}

				}
			}

			// check if tier 2 employee, if so create new tier2 and add to employee list
			if (currentLine.substring(eight + 1, nine).equals("tier2")) {
				Tier2Employee tier2Employee = new Tier2Employee(currentLine.substring(one + 1, two),
						currentLine.substring(two + 1, three), currentLine.substring(four + 1, five),
						currentLine.substring(five + 1, six), currentLine.substring(two + 1, three),
						currentLine.substring(0, one), currentLine.substring(six + 1, seven),
						currentLine.substring(six + 1, seven), currentLine.substring(nine + 1, currentLine.length()));
				Project3.employeeList.add(tier2Employee);
			}
			// same for tier 1
			else {
				Employee employee = new Employee(currentLine.substring(one + 1, two),
						currentLine.substring(two + 1, three), currentLine.substring(four + 1, five),
						currentLine.substring(five + 1, six), currentLine.substring(two + 1, three),
						currentLine.substring(0, one), currentLine.substring(six + 1, seven),
						currentLine.substring(six + 1, seven));
				Project3.employeeList.add(employee);
			}
		}
	}

	/**
	 * Reads ticket data, creates ticket objects, assigns to linked list
	 * 
	 * @param ticketFileName The file name to read
	 * @return tickets The linked list of ticket objects created
	 */
	public static LinkedList<Ticket> readTicketData(String ticketFileName) throws FileNotFoundException {

		// log
		FileHandler.logger("Loading Ticket Data");

		// declare scanner
		File inputFile = new File(ticketFileName);
		Scanner scnr = new Scanner(inputFile);

		// declare arrayList for all unseperated String lines of the file, declare
		// ticket list
		ArrayList<String> unseperatedLines = new ArrayList<String>();
		LinkedList<Ticket> tickets = new LinkedList<Ticket>();

		// read in data to arrayList
		while (scnr.hasNextLine()) {
			unseperatedLines.add(scnr.nextLine());
		}

		// close file scanner, remove first line of unseperatedLines, as it's the header
		// line and isn't needed
		scnr.close();
		unseperatedLines.remove(0);

		// for each line in unseperatedLines, separate at comma locations and add to
		// relevant ticket object, add that to ticket list
		for (int i = 0; i < unseperatedLines.size(); ++i) {

			// declare current line for ease of writing reasons - otherwise I'd have to use
			// unseperatedLines.get(i) each time
			String currentLine = unseperatedLines.get(i); // this might also improve performance

			// find all eight comma locations
			int one = -1;
			int two = -1;
			int three = -1;
			int four = -1;
			int five = -1;
			int six = -1;
			int seven = -1;
			int eight = -1;
			for (int j = 0; j < currentLine.length(); ++j) {
				if (currentLine.charAt(j) == ',') {
					if (one == -1) {
						one = j;
					} else if (two == -1) {
						two = j;
					} else if (three == -1) {
						three = j;
					} else if (four == -1) {
						four = j;
					} else if (five == -1) {
						five = j;
					} else if (six == -1) {
						six = j;
					} else if (seven == -1) {
						seven = j;
					} else if (eight == -1) {
						eight = j;
					}
				}
			}

			// create customer object from file data
			Customer Customer = new Customer(currentLine.substring(one + 1, two), currentLine.substring(two + 1, three),
					currentLine.substring(four + 1, five), currentLine.substring(five + 1, six),
					currentLine.substring(three + 1, four), currentLine.substring(0, one),
					currentLine.substring(six + 1, seven));

			// create ticket object from file data
			Ticket ticket = new Ticket(Customer, currentLine.substring(eight + 1, currentLine.length()),
					currentLine.substring(seven + 1, eight));
			tickets.add(ticket);
		}
		return tickets;
	}

	/**
	 * Writes work orders to a created csv file. Thought it's not in the
	 * instructions, the sample output file has tier2 work orders printed first, so
	 * I included that functionality
	 * 
	 * @param workOrderFileName File name for work order file
	 * @throws IOException
	 */
	public static void writeData(String workOrderFileName) throws IOException {

		// declares
		ArrayList<WorkOrder> tier1WorkOrders = new ArrayList<>();
		FileWriter csvFile = new FileWriter(workOrderFileName);

		// log, print header
		FileHandler.logger("Writing Work Order Data to File");
		csvFile.write(
				"customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,"
						+ "employee_id,employee_first_name,employee_last_name,clocked_in,certification\n");

		// loop through work orders
		for (int i = 0; i < Project3.workOrderList.size(); ++i) {

			// if tier 2 print right away
			if (Project3.workOrderList.get(i).getEmployee().toString().substring(0, 5).equals("Tier2")) {

				csvFile.write(Project3.workOrderList.get(i).getFileData() + "\n");
				logger(Project3.workOrderList.get(i).getFileData());
			}
			// if tier 1 save to print later
			else {
				tier1WorkOrders.add(Project3.workOrderList.get(i));
			}
		}
		// print tier1 work orders
		for (WorkOrder order : tier1WorkOrders) {
			csvFile.write(order.getFileData() + "\n");
			logger(order.getFileData());
		}
		// print end message to console + log, close output stream
		csvFile.close();
		System.out.println("Work Orders created. Program Exiting");
		logger("Work Orders created. Program Exiting");
	}

	/**
	 * Adds log entry w/date and time
	 * 
	 * @param log String to write to log file
	 */
	public static void logger(String log) {
		try {
			// get current date and time
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date currentTime = new Date();
			String outputTime = format.format(currentTime);

			// create filewriter, append to log.txt file
			FileWriter out = new FileWriter("log.txt", true);
			out.append("log: " + outputTime + " : " + log + "\n");
			out.close();
		} catch (IOException exception) {
			System.out.println("Something went wrong with printing to the log file");
		}
	}
}
