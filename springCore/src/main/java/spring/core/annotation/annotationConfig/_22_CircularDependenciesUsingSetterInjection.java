package spring.core.annotation.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import spring.core.annotation.annotationConfig.classesWithAnnotation._22.CarWithSetterInjection;
import spring.core.annotation.annotationConfig.classesWithAnnotation._22.DriverWithSetterInjection;

import javax.annotation.PostConstruct;

@ComponentScan(basePackages="spring.core.annotation.annotationConfig.classesWithAnnotation._221")
@Configuration
public class _22_CircularDependenciesUsingSetterInjection {
	@Autowired
	private CarWithSetterInjection car;
	@Autowired
	private DriverWithSetterInjection driver;

	@PostConstruct
	public void postConstruct() {
		System.out.println(car);
		car.drive();
		System.out.println(driver);

		driver.showCar();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				_22_CircularDependenciesUsingSetterInjection.class);
	}

}
