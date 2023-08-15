/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author MohamedSayed
 */
public class JDBCtempletExamplee {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao doaImpI = context.getBean(EmployeeDoaImpI.class);
        System.out.println("----Listing Record with ID = 2 -----");
        Employee employee = doaImpI.getEmployee(100);
        System.out.print(employee);

    }
}
