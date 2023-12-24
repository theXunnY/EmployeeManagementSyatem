package edu.jsp.employee.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;

import edu.jsp.employee.model.Employee;
import edu.jsp.employee.view.SortByContact;
import edu.jsp.employee.view.SortById;
import edu.jsp.employee.view.SortByName;
import edu.jsp.employee.view.SortBySalary;


public class Controller {

	private List<Employee> employees=new ArrayList<>(); 
	
	public Employee saveEmployee(Employee employee ) {
		if(employee != null) {
			employees.add(employee);
			return employee;
		}
		else {
			return null;
		}
	}

	
	public Employee delEmployee(Employee target) {

		if(target!=null) {
			for (Employee employee : employees) {
				if(employee.getId()==target.getId()) {
					try{employees.remove(employee);
					}catch (ConcurrentModificationException e) {
						System.out.println(e.getMessage());
					}
					return employee;
					
				}
			}				
					return null;

		}
		else {
			return null;
		}
		
	}
	
	
	public List<Employee> getAllEmployee() {
		return employees;
		
	}
	
	public Employee getEmployee(int id) {
		if(id >0) {
			for (Employee employee : employees) {
				if(employee.getId()==id) {
					return employee;
				}
			}
			return null;
		}
		else {
			return null;
		}
	}


	public List<Employee> getSorted(Comparator<Employee> compartor){
		
		if (compartor instanceof SortById) {
			Collections.sort(employees, compartor);
			return employees;
		}
		else if(compartor instanceof SortByName) {
			Collections.sort(employees, compartor);
			return employees;
		}
		else if(compartor instanceof SortBySalary) {
			Collections.sort(employees, compartor);
			return employees;
		}
		else if(compartor instanceof SortByContact) {
			Collections.sort(employees, compartor);
			return employees;
		}
		else {
			return employees;
		}
		
		
			
		
		
		
		
	}

}


