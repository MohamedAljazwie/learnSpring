/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.ClassesWithAnnotaions.NetworkManager;
import spring.core.xml.xmlConfig.classes.Triangle;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _9_BeanPostProcessor {

    static final Logger logger = Logger.getLogger(_8_SpringBeanLifeCycle.class.toString());

    public static void main(String[] args) {
        logger.info("\n\n     *************************My  before execute beanPostProcessor xml   called  ************************");

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/beanPostProcessor.xml");
        logger.info("\n\n     *************************My  before bean   Triangle  called  ************************");
        Triangle triangle = ac.getBean(Triangle.class);

        triangle.draw();
        logger.info("\n\n     *************************My  AFTER bean  Triangle  called  ************************");

        logger.info("\n\n     *************************My  after  execute beanPostProcessor xml   called  ************************");

        
        
        logger.info("\n\n     *************************My  before execute A1pplicationContext xml   called  ************************");

        ac = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");
        logger.info("\n\n     *************************My  before bean   Triangle  called  ************************");

        spring.core.xml.xmlConfig.ClassesWithAnnotaions.Triangle triangle1 = ac.getBean(spring.core.xml.xmlConfig.ClassesWithAnnotaions.Triangle.class);

        triangle1.draw();
        logger.info("\n\n     *************************My  AFTER bean  Triangle  called  ************************");

        logger.info("\n\n     *************************My  before bean  NetworkManager  called  ************************");
        NetworkManager networkManager = ac.getBean(NetworkManager.class);
        networkManager.readData();
        logger.info("\n\n     *************************My  AFTER bean  NetworkManager  called  ************************");

        logger.info("\n\n     *************************My  after execute A1pplicationContext xml   called  ************************");


    }
}
