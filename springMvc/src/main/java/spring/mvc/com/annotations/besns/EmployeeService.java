package spring.mvc.com.annotations.besns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.com.annotations.besns.EmployeeDetails.Employee;

import javax.inject.Provider;

@Service
public class EmployeeService {
	@Autowired
	private Provider<EmployeeDetails> employeeDetailsProvider;

	public EmployeeDetails findEmployeeSalary() {
		EmployeeDetails employeeDetails = employeeDetailsProvider.get();
		Employee employee = employeeDetails.getEmployee();
		employeeDetails.setLastYearSalary(getEmployeeSalary(employee));
		return employeeDetails;
	}

	private int getEmployeeSalary(Employee employee) {
		// todo: call backend instead
		int salary = 100 * RandomUtil.getInt(30, 100);
		return salary;
	}
}
