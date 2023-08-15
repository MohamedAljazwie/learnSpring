package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
	 
	 void addEmployee();  
	    
	  String addEmployeeReturnValue();  
	    
	  void addEmployeeThrowException() throws Exception;  
	    
	  void addEmployeeAround(String name);  
	}
