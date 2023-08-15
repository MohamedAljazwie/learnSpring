/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.classes.Triangle;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _3_InnerBeanInjection {
    
    public static void main(String[] args) {
          ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/innerBean.xml");
        Triangle triangle = (Triangle) ac.getBean("triangle");
      
        triangle.draw();
    }
 
}
