package spring.core.annotation.annotationConfig.classesWithAnnotation._21;

import org.springframework.stereotype.Component;


@Component
public class Car {
    private final Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }
    
    public void drive() {
		System.out.println("driven by: " + driver);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
