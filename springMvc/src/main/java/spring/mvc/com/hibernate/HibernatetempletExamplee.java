/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.hibernate;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.mvc.com.jdbc.Employee;
import spring.mvc.com.jdbc.EmployeeDao;

/**
 *
 * @author MohamedSayed
 */
public class HibernatetempletExamplee {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao doaImpI = (EmployeeDao) context.getBean(HibernateEmployeeDoaImpI.class);
        System.out.println("----Listing Record with ID = 2 -----");
        Employee employee = doaImpI.getEmployee(100);
        System.out.print(employee);
        List<Employee> employees = doaImpI.listEmployees();
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
