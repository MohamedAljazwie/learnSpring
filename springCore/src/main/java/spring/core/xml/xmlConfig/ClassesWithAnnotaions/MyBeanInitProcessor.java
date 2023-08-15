/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

/**
 *
 * @author mohamed.aljazwiee
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
 @Component
public class MyBeanInitProcessor implements BeanPostProcessor{
     static final Logger logger = Logger.getLogger(MyBeanInitProcessor.class.toString());

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        logger.log(Level.INFO, "after  initialization: {0}  that is found in Pakage {1}", new Object[]{beanName, bean.getClass().getPackage().getName()});
        return bean;
    }
 
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.log(Level.INFO, "before  initialization: {0}  that is found in Pakage {1}", new Object[]{beanName, bean.getClass().getPackage().getName()});
        return bean;
    }
}
