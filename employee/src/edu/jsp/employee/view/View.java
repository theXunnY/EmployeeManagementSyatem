package edu.jsp.employee.view;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.model.Employee;

public class View {

	Scanner scanner =new Scanner(System.in);
	Controller controller =new Controller();
	
	boolean loop=true;
	
	public static void main(String[] args) {
	
		View view =new View();		
		
		while(view.loop){
			view.mainView();
		}	
	}
	
	
	
	public void mainView() {
		System.out.println("............................Welcome..................................\n"
				
				+ "Select operation to perform \n"
				+ "1. SAVE EMPLOYEE \n"
				+ "2. GET EMPLOYEE \n"
				+ "3. GET ALL EMPLOYEE \n"
				+ "4. DELETE EMPLOYEE \n"
				+ "5. UPDATE EMPLOYEE \n"
				+ "6. EXIT");
		
				int choice =  scanner.nextInt();
			
		switch (choice) {
		case 1: {
			saveEmployee();
			break;
			
		}
		case 2: {
			getEmployee();
			break;
		}
		case 3: {
			getAllEmployees();
			break;
		}
		case 4: {
			deleteEmployee();
			break;
		}
		case 5: {
			updateEmployee();
			break;
		}
		case 6: {
			System.out.println("thank you");
			this.loop=false;
			break;
		}
		
		default:{
			System.out.println("INVALID INPUT");
		}
		}
				

	}

	void saveEmployee() {
		System.out.println("enter emplooyee id \n");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter employee name \n");
		String name=scanner.nextLine();
		
		System.out.println("enter employee salary \n");
		double salary=scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter employee contact \n");
		long contact=scanner.nextLong();
		scanner.nextLine();
		
		Employee employee= new Employee(id, name, salary, contact); 
		
		if (controller.saveEmployee(employee) != null) {
			System.out.println("Employee saved \n");
			
		} else {
			System.out.println("Something went wrong.....please try again \n");
		}
		
	}
	
	void getEmployee() {

		System.out.println("Enter employee id = ");
		int id=scanner.nextInt();
		Employee employee;
		if((employee = controller.getEmployee(id)) != null) {
			System.out.println("Employee id= "+ employee.getId());
			System.out.println("Employee Name= "+ employee.getName());
			System.out.println("Employee Salary= "+ employee.getSal());
			System.out.println("Employee Contact= "+ employee.getContact());
			
		}
		else {
			System.out.println("Employee not found");
		}
		
		
	}
	
	void getAllEmployees() {
		
		sortEmployees();
		
		if (controller.getAllEmployee().isEmpty()) {
			System.out.println("Employee NOT FOUND !");
			return;
		}
		
		for (Employee employee : controller.getAllEmployee()) {
			System.out.println();
			System.out.println("Employee id: " + employee.getId());
			System.out.println("Employee Name: " + employee.getName());
			System.out.println("Employee Salary: " + employee.getSal());
			System.out.println("Employee Contact: " + employee.getContact());
		
			System.out.println("\n--------------------------------------------------\n");
			
		}
		
		
	}
	
	
	void deleteEmployee() {
		
		getAllEmployees();
		
		System.out.println("enter emplooyee id \n");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter employee name \n");
		String name=scanner.nextLine();
		
		System.out.println("enter employee salary \n");
		double salary=scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter employee contact \n");
		long contact=scanner.nextLong();
		scanner.nextLine();
		
		Employee employee= new Employee(id, name, salary, contact); 
		
		for (Employee employee1 : controller.getAllEmployee()) {
			
			if(employee.getId()==employee1.getId()) {
				if (employee.getName().equalsIgnoreCase(employee1.getName())){
					if (employee.getSal()==employee1.getSal()) {
						if (employee.getContact()==employee.getContact()) {
							controller.delEmployee(employee);
							System.out.println("Employee Deleted !\n");
							return;
						}
						
					}
				} 
			}
		}
		
		System.out.println("Employee Not Found !!!!!!");
	
	}


		void updateEmployee() {
			
			getAllEmployees();
			
			System.out.println("Enter Employee ID to Upadte Employee :");
			int eId=scanner.nextInt();
			scanner.nextLine();
			
	
			for (Employee emp : controller.getAllEmployee()) {
				if(eId==emp.getId()) {
					Employee employee=emp;
					
					System.out.println("WHAT YOU WANT TO UPDATE? \n"+
							"1. ID \n"+
							"2. NAMAE \n"+
							"3. SALARY \n"+
							"4. CONTACT \n"+
							"5. UPDATE ALL \n");
					
						int choice=scanner.nextInt();
						
						switch (choice) {
						case 1: {
							System.out.println("enter emplooyee id \n");
							int id=scanner.nextInt();
							emp.setId(id);
							scanner.nextLine();
							
							System.out.println("EMployee ID Updated");
							break;
						}
						case 2: {
							System.out.println("enter employee name \n");
							String name=scanner.nextLine();
							emp.setName(name);
							System.out.println("Employee Name Updated");
							break;
						}
						case 3: {
							System.out.println("enter employee salary \n");
							double salary=scanner.nextDouble();
							scanner.nextLine();
							emp.setSal(salary);
							System.out.println("Employee Name Updated");
							break;
						}
						case 4: {
							System.out.println("Enter employee contact \n");
							long contact=scanner.nextLong();
							scanner.nextLine();
							emp.setContact(contact);
							break;
						}
						case 5: {
							
							System.out.println("enter emplooyee id \n");
							int id=scanner.nextInt();
							scanner.nextLine();
							
							System.out.println("enter employee name \n");
							String name=scanner.nextLine();
							
							System.out.println("enter employee salary \n");
							double salary=scanner.nextDouble();
							scanner.nextLine();
							
							System.out.println("Enter employee contact \n");
							long contact=scanner.nextLong();
							scanner.nextLine();
							
							emp.setId(id);
							emp.setName(name);
							emp.setSal(salary);
							emp.setContact(contact);
							
							System.out.println("EMPLOYEE INFORMATION UPDATED \n");
							
						}
						default:
							System.out.println("Error");
											
					} 
					
				}
			}
		}
	
			
		

	void sortEmployees() {
		System.out.println("SORT EMPLOYEE BASED OF \n"
				+"1. ID \n"
				+"2. NAME \n"
				+"3. SALARY \n"
				+"4. CONTACT \n"
				+"5. DO NOT SORT");
		int sortChoice=scanner.nextInt();

				switch (sortChoice) {
				case 1: {
					controller.getSorted(new SortById());
					break;
				}
				case 2: {
					controller.getSorted(new SortByName());
					break;
				}
				case 3: {
					controller.getSorted(new SortBySalary());
					break;
				}
				case 5: {
					controller.getSorted(new SortByContact());
					break;
				}
				case 6: {
					controller.getSorted(new SortByContact());
					break;
				}
				default:
					System.out.println("INVALID CHOICE !!!");
				}
		
	}
			
		
}	
		
		
	
	
	
	

