package spring.core.annotation.annotationConfig.classesWithAnnotation._22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarWithSetterInjection {


		private DriverWithSetterInjection driver;

		@Autowired
		public void setDriverWithSetterInjection(DriverWithSetterInjection driver) {
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