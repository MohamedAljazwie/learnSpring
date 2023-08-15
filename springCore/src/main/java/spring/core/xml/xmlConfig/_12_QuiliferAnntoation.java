/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import static spring.core.xml.xmlConfig._9_BeanPostProcessor.logger;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.ClassesWithAnnotaions.MessageProducer;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _12_QuiliferAnntoation {
        static final Logger logger = Logger.getLogger(_12_QuiliferAnntoation.class.toString());
    public static void main(String[] args) {
         logger.info("\n\n     *************************My  before execute A1pplicationContext xml   called  ************************");

      ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/annotations/A1pplicationContext.xml");
        logger.info("\n\n     *************************My  before bean   MessageProducer  called  ************************");
        MessageProducer messageProducer=ac.getBean(MessageProducer.class);
        
        messageProducer.produce();
        logger.info("\n\n     *************************My  AFTER bean  MessageProducer  called  ************************");

        logger.info("\n\n     *************************My  after execute A1pplicationContext xml   called  ************************");

    }
}
