package spring.mvc.com.xml.services;

import java.util.List;

import spring.mvc.com.xml.model.Employee;


/**
 * @author Dinesh Rajput
 *
 */
public interface EmployeeService {
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
