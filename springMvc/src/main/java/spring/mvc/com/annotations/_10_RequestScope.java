package spring.mvc.com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.com.annotations.besns.EmployeeDetails;
import spring.mvc.com.annotations.besns.EmployeeDetails.Employee;
import spring.mvc.com.annotations.besns.EmployeeService;
import spring.mvc.com.annotations.besns.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

@RestController
@RequestMapping("/requestScope")
public class _10_RequestScope {
	@Autowired
	private Provider<EmployeeDetails> employeeDetailsProvider;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
	public List<EmployeeDetails> handler(@PathVariable("id") String employeeId,@RequestBody List<EmployeeDetails> employeeDetails) {
		EmployeeDetails details= employeeDetailsProvider.get();
		details.setEmployee(getEmployeeById(employeeId));
		StringBuilder builder=new StringBuilder();
		EmployeeDetails details2= employeeService.findEmployeeSalary();
		builder.append("EmployeeDetails from  employeeDetailsProvider is ").append(details).append("\n");
		builder.append("EmployeeDetails from  employeeService is ").append(details2).append("\n");
		
		if(details==details2)
			builder.append("employeeDetailsProvider's EmployeeDetails  is equal to   employeeService's EmployeeDetails  is ").append("\n");
		List<EmployeeDetails> detailsList=new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details2);
		return detailsList;
	}

	private Employee getEmployeeById(String employeeId) {
		// todo: call to backend instead
		Employee employee = new EmployeeDetails.Employee(employeeId, RandomUtil.getFullName(),
				RandomUtil.getAnyOf("Admin", "IT", "Sales"));
		return employee;
	}
}
