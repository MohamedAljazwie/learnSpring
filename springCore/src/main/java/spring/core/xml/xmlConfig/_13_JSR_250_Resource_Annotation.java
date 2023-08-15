/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.ClassesWithAnnotaions.Employee;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _13_JSR_250_Resource_Annotation {
        static final Logger logger = Logger.getLogger(_12_QuiliferAnntoation.class.toString());
    public static void main(String[] args) {
         logger.info("\n\n     *************************My  before execute A1pplicationContext xml   called  ************************");

      ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");
        logger.info("\n\n     *************************My  before bean   Employee  called  ************************");
     
        Employee employee=ac.getBean(Employee.class);
        logger.log(Level.INFO, "{0}", employee);
        logger.info("\n\n     *************************My  AFTER bean  Employee  called  ************************");

        logger.info("\n\n     *************************My  after execute A1pplicationContext xml   called  ************************");

    }
}
