/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.classes.Triangle;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _8_SpringBeanLifeCycle {

    static final Logger logger = Logger.getLogger(_8_SpringBeanLifeCycle.class.toString());

    public static void main(String[] args) {
        logger.info("\n\nMy  before execute SpringBeanLifeCycle xml   called ");

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/SpringBeanLifeCycle.xml");

        Triangle triangle = ac.getBean(Triangle.class);

        triangle.draw();

        logger.info("\n\nMy  after  execute SpringBeanLifeCycle xml   called ");

        logger.info("\n\nMy  before execute A1pplicationContext xml   called ");

        ac = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");
        spring.core.xml.xmlConfig.ClassesWithAnnotaions.Triangle triangle1 = ac.getBean(spring.core.xml.xmlConfig.ClassesWithAnnotaions.Triangle.class);

        triangle1.draw();

        logger.info("\n\nMy  after execute A1pplicationContext xml   called ");

    }
}
