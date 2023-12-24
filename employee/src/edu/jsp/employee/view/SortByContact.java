package edu.jsp.employee.view;

import java.util.Comparator;

import edu.jsp.employee.model.Employee;

public class SortByContact implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.getContact()-o2.getContact());
	}

}
