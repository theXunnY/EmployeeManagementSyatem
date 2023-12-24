package edu.jsp.employee.view;

import java.util.Comparator;

import edu.jsp.employee.model.Employee;

public class SortById implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId()-o2.getId() ;
	}

}
