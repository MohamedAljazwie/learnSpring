package spring.core.annotation.annotationConfig;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import spring.core.annotation.annotationConfig.classesWithAnnotation._21.*;


@Configuration
@ComponentScan(basePackages="spring.core.annotation.annotationConfig.classesWithAnnotation._21")
public class _21_CircularDependencies {
	@Autowired
	private Car car;
	@Autowired
	private Driver driver;

	@PostConstruct
	public void postConstruct() {
		System.out.println(car);
		car.drive();
		System.out.println(driver);

		driver.showCar();
	}

	    public static void main(String[] args) {
	        new AnnotationConfigApplicationContext(_21_CircularDependencies.class);
	    }
	

	
}
