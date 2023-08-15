/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.io.File;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.classes.CustomerService;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _7_Scopes {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/scopes.xml");


        /*  when object in case customerServiceSingletona */
        System.out.println("/* Start     when object in case customerServiceSingletona */");
        CustomerService customerServiceSingletona = (CustomerService) ac.getBean("customerServiceSingleton");
        customerServiceSingletona.setMessage("Message by customerServiceSingletonaA");
        System.out.println("Message : " + customerServiceSingletona.getMessage());

        //retrieve it again
        CustomerService customerServiceSingletonB = (CustomerService) ac.getBean("customerServiceSingleton");
        System.out.println("Message : " + customerServiceSingletonB.getMessage());

        /* ***************/
        System.out.println("/* end     when object in case customerServiceSingletona */");

        /*  when object in case customerServicePrototype */
        System.out.println("/* Start     when object in case customerServicePrototype */");

        CustomerService customerServicePrototypeA = (CustomerService) ac.getBean("customerServicePrototype");
        customerServicePrototypeA.setMessage("Message by customerServicePrototypeA");
        System.out.println("Message : " + customerServicePrototypeA.getMessage());

        //retrieve it again
        CustomerService customerServicePrototypeB = (CustomerService) ac.getBean("customerServicePrototype");
        System.out.println("Message : " + customerServicePrototypeB.getMessage());

        /* ***************/
        System.out.println("/* end      when object in case customerServicePrototype */");

        ApplicationContext ac1 = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");

        System.out.println("/* Start     when object in case customerServiceSingleton from xmlConfig package */");
        try {
        CustomerService customerServiceSingletona1 = (CustomerService) ac1.getBean(CustomerService.class);
        customerServiceSingletona1.setMessage("Message by customerServiceSingletonaA");
        System.out.println("Message : " + customerServiceSingletona1.getMessage());
        }catch (Exception e) {
            System.out.println("/* xmlConfig.classes.CustomerService;  Not Created from annotations/A1pplicationContext.xm File   */");
		}
        System.out.println("/* End     when object in case customerServiceSingleton from xmlConfig package */");
        System.out.println("/* Start     when object in case customerServiceSingleton from ClassesWithAnnotaions package */");

        spring.core.xml.xmlConfig.ClassesWithAnnotaions.CustomerService customerServiceSingletona1 = 
        		(spring.core.xml.xmlConfig.ClassesWithAnnotaions.CustomerService) ac1.getBean(spring.core.xml.xmlConfig.ClassesWithAnnotaions.CustomerService.class);
        customerServiceSingletona1.setMessage("Message by customerServiceSingletonaA");
        System.out.println("Message : " + customerServiceSingletona1.getMessage());
        
        System.out.println("/* End     when object in case customerServiceSingleton from ClassesWithAnnotaions package */");

    }
}
