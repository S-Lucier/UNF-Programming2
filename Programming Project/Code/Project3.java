import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Author: Scott Lucier
 * Course: COP3503
 * Project #: 3
 * Title : Work Order Generator
 * Due Date: 11/27/2023
 *
 * Creates work orders from employee and ticket data, given in csv files
 */

public class Project3 {

	// inter-class array lists
	public static ArrayList<Employee> employeeList = new ArrayList<>();
	public static Queue<Ticket> tier1TicketFile = new LinkedList<>();
	public static Queue<Ticket> tier2TicketFile = new LinkedList<>();
	public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();

	/**
	 * Creates work orders
	 */
	private static void createWorkOrders() {

		// print start statement
		System.out.println("Creating Work Orders");

		// get current date and time - could be inaccurate with a very long runtime,
		// shouldn't be an issue here.
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date currentTime = new Date();
		String outputTime = format.format(currentTime);

		// loops through employee list assigning tickets until both ticket files are empty
		int i = 0;
		while (tier1TicketFile.size() > 0 || tier2TicketFile.size() > 0) {

			// ticket matching for a tier 2 employee, tests object type to determine if
			// employee at index is tier 2
			if (employeeList.get(i).toString().substring(0, 5).equals("Tier2")) {
				
				// makes sure there are tickets left in the ticket file
				if (tier2TicketFile.size() > 0) {
					
					//make workorder, put in array
					WorkOrder tier2WorkOrder = new WorkOrder(employeeList.get(i), tier2TicketFile.remove(), outputTime);
					workOrderList.add(tier2WorkOrder);
				}
			}

			// same for tier 1 tickets
			else {
				if (tier1TicketFile.size() > 0) {
					WorkOrder workOrder = new WorkOrder(employeeList.get(i), tier1TicketFile.remove(), outputTime);
					workOrderList.add(workOrder);
				}
			}
			// increase i, reset if i exceeds number of employees (loops through employee list)
			++i;
			if (i >= employeeList.size()) {
				i = 0;
			}
		}
	}

	/**
	 * Calls methods
	 */
	public static void main(String[] args) {

		//print project name
		System.out.println("Project 3 Work Order Generator\n");

		// file names
		String employeeFileName = "employee_data.csv";
		String tier1TicketFileName = "tier1_ticket_data.csv";
		String tier2TicketFileName = "tier2_ticket_data.csv";
		String workOrderFileName = "workorder_data.csv";

		// call methods, with error catching
		try {

			// read employee data
			System.out.println("Loading Employee Data");
			FileHandler.readEmployeeData(employeeFileName);

			// read ticket data
			System.out.println("Loading Ticket Data");
			tier1TicketFile = FileHandler.readTicketData(tier1TicketFileName);
			tier2TicketFile = FileHandler.readTicketData(tier2TicketFileName);

			// create and print to file work orders
			createWorkOrders();
			System.out.println("Writing Work Order Data to File");
			FileHandler.writeData(workOrderFileName);

		} catch (FileNotFoundException exception) {
			System.out.println("File Not Found Error, please solve issue and restart program");
		} catch (IOException exeption) {
			System.out.println("Input Output Error, please solve issue and restart program");
		}
	}
}
