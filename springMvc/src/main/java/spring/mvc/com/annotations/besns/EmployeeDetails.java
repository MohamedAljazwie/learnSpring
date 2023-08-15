package spring.mvc.com.annotations.besns;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.io.Serializable;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class EmployeeDetails implements Serializable {
	private Employee employee;
	private int lastYearSalary;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public int getLastYearSalary() {
		return lastYearSalary;
	}

	public void setLastYearSalary(int lastYearSalary) {
		this.lastYearSalary = lastYearSalary;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employee=" + employee + ", lastYearSalary=" + lastYearSalary + "]";
	}

	public static class Employee {
		private String id;
		private String name;
		private String dept;

		public Employee() {
		}

		public Employee(String id, String name, String dept) {
			this.id = id;
			this.name = name;
			this.dept = dept;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDept() {
			return dept;
		}

		@Override
		public String toString() {
			return " [id=" + id + ", name=" + name + ", dept=" + dept + "]";
		}

	}
}
