package spring.core.annotation.annotationConfig.classesWithAnnotation._21;

import org.springframework.stereotype.Component;

@Component
public class Driver {
    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }
    public void showCar() {
		System.out.println("my car: " + car);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
