package spring.core.xml.xmlConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.ClassesWithAnnotaions.Employee;
import spring.core.xml.xmlConfig.classes.EmployeeImpl;
import spring.core.xml.xmlConfig.classes.EmployeeService;

public class _14_AOP {
    static final Logger logger = Logger.getLogger(_12_QuiliferAnntoation.class.toString());
 public static void main(String[] args) {
      logger.info("\n\n     *************************My  before execute aopWithXml xml   called  ************************");

   //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/aopWithXml.xml");
    // logger.info("\n\n     *************************My  before bean   EmployeeService  called  ************************");
  
    // EmployeeService employee=ac.getBean("employeeImpi",EmployeeImpl.class);
    // employee.addEmployee();
   //  logger.log(Level.INFO, "{0}", employee);
   //  logger.info("\n\n     *************************My  AFTER bean  EmployeeService  called  ************************");

    // logger.info("\n\n     *************************My  after execute aopWithXml xml   called  ************************");

     ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");
       logger.info("\n\n     *************************My  before bean   EmployeeService  called  ************************");
    
       EmployeeService  employee=ac.getBean(EmployeeImpl.class);
        employee.addEmployee();
       logger.log(Level.INFO, "{0}", employee);
       logger.info("\n\n     *************************My  AFTER bean  EmployeeService  called  ************************");

       logger.info("\n\n     *************************My  after execute A1pplicationContext xml   called  ************************");

}
}
