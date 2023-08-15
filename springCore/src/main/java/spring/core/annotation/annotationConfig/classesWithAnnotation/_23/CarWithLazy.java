package spring.core.annotation.annotationConfig.classesWithAnnotation._23;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class CarWithLazy {
    private final DriverWithLazy driverWithLazy;

    public CarWithLazy(@Lazy DriverWithLazy driverWithLazy) {
        this.driverWithLazy = driverWithLazy;
    }
    
    public void drive() {
		System.out.println("driven by: " + driverWithLazy);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
