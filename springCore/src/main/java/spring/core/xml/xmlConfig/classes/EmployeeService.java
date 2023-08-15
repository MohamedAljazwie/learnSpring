package spring.core.xml.xmlConfig.classes;

public interface EmployeeService {
	 
	 void addEmployee();  
	    
	  String addEmployeeReturnValue();  
	    
	  void addEmployeeThrowException() throws Exception;  
	    
	  void addEmployeeAround(String name);  
	}
