/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.classes;

/**
 *
 * @author mohamed.aljazwiee
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

public class BeanFactoryPPDemo implements BeanFactoryPostProcessor  
{
@Override
public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
 {
 PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();  
 cfg.setLocation(new FileSystemResource("database.properties"));  
 cfg.postProcessBeanFactory(beanFactory); 
 System.out.println("Bean factory post processor is initialized");
 }
}
