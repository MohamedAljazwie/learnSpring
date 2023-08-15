package spring.core.xml.xmlConfig.classes;


public class EmployeeImpl implements EmployeeService {

	 public void addEmployee() {
	  System.out.println("addEmployee() is running ");
	 }

	 public String addEmployeeReturnValue() {
	  System.out.println("addEmployeeReturnValue() is running ");
	  return "abc";
	 }

	 public void addEmployeeThrowException() throws Exception {
	  System.out.println("addEmployeeThrowException() is running ");
	  throw new Exception("Generic Error");
	 }

	 public void addEmployeeAround(String name) {
	  System.out.println("addEmployeeAround() is running, args : " + name);
	 }
	}
