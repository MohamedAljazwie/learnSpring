package spring.core.annotation.annotationConfig.classesWithAnnotation._23;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class DriverWithLazy {
    private final CarWithLazy carWithLazy;

    public DriverWithLazy(CarWithLazy carWithLazy) {
        this.carWithLazy = carWithLazy;
    }
    public void showCar() {
		System.out.println("my car: " + carWithLazy);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
