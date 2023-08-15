package spring.core.annotation.annotationConfig.classesWithAnnotation._22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverWithSetterInjection {

		private CarWithSetterInjection car;

		@Autowired
		public void setCarWithSetterInjection(CarWithSetterInjection car) {
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
