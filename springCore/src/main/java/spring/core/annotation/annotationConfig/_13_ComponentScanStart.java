package spring.core.annotation.annotationConfig;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.core.annotation.annotationConfig.classesWithAnnotation._13.MyPrototypeBean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("spring.core.annotation.annotationConfig.classesWithAnnotation")
public class _13_ComponentScanStart {

	   
	    public static void main(String... strings) {
	        AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(_13_ComponentScanStart.class);
	        System.out.println("-- Spring container started and is ready --");
	        MyPrototypeBean bean = context.getBean(MyPrototypeBean.class);
	        bean.doSomething();
	    }

	    
	   
	    
	 
	
	    
	
	    
	  
}
