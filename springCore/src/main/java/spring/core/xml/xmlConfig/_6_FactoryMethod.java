/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.classes.EmployeeDTO;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _6_FactoryMethod {
    public static void main(String[] args) {
        
                    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/factoryMethod.xml");

                    /*         using static method */
                    EmployeeDTO manager=(EmployeeDTO) ac.getBean("manager");
                    System.out.println(manager);
                     EmployeeDTO director=(EmployeeDTO) ac.getBean("director");
                    System.out.println(director);
                    
                    /* usong local method*/
                  EmployeeDTO technicalmanager=(EmployeeDTO) ac.getBean("technicalmanager");
                    System.out.println(technicalmanager);
                     EmployeeDTO qcmanager=(EmployeeDTO) ac.getBean("qcmanager");
                    System.out.println(qcmanager);
    }
}
