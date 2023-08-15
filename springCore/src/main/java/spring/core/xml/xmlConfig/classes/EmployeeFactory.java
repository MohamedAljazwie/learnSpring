/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.classes;

/**
 *
 * @author mohamed.aljazwiee
 */
public class EmployeeFactory {
     
    public static EmployeeDTO createEmployeeOfType(String type)
    {
        if (null != type)
        switch (type) {
            case "manager":
            {
                EmployeeDTO employee = new EmployeeDTO();
                
                employee.setId(4);
                employee.setFirstName("Yasser");
                employee.setLastName("ITS");
                //Set designation here
                employee.setDesignation(type);
                
                return employee;
            }
            case "director":
            {
                EmployeeDTO employee = new EmployeeDTO();
                
                employee.setId(3);
                employee.setFirstName("Tarek");
                employee.setLastName("Mostafa");
                //Set designation here
                employee.setDesignation(type);
                
                return employee;
            }
            default:
                throw new IllegalArgumentException("Unknown product");
        }
     return null;
    }
    
     public  EmployeeDTO createEmployee(String type)
    {
        if (null != type)
        switch (type) {
            case "technicalmanager":
            {
                EmployeeDTO employee = new EmployeeDTO();
                
                employee.setId(1);
                employee.setFirstName("Mahmoud");
                employee.setLastName("Yousery");
                //Set designation here
                employee.setDesignation(type);
                
                return employee;
            }
            case "qcmanager":
            {
                EmployeeDTO employee = new EmployeeDTO();
                
                employee.setId(2);
                employee.setFirstName("Tarek");
                employee.setLastName("Jaky");
                //Set designation here
                employee.setDesignation(type);
                
                return employee;
            }
            default:
                throw new IllegalArgumentException("Unknown product");
        }
        return null;
        
    }
}
