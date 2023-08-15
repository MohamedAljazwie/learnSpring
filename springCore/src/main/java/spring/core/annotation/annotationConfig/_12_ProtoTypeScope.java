package spring.core.annotation.annotationConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

public class _12_ProtoTypeScope {

	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public ServiceBean serviceBean() {
		return new ServiceBean();
	}

	@Bean
	public ClientBean1 clientBean1() {
		return new ClientBean1();
	}

	@Bean
	public ClientBean2 clientBean2() {
		return new ClientBean2();
	}

	public static void main(String[] args) {
		runApp();
		runApp();
	}

	private static void runApp() {
		System.out.println("--- running app ---");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_12_ProtoTypeScope.class);
		context.getBean(ClientBean1.class).doSomething();
		context.getBean(ClientBean2.class).doSomething();
	}

	public class ClientBean1 {
		@Autowired
		private ServiceBean serviceBean;

		public void doSomething() {
			System.out.println("from ClientBean1: serviceBean: " + System.identityHashCode(serviceBean));
		}
	}

	public class ClientBean2 {
		@Autowired
		private ServiceBean serviceBean;

		public void doSomething() {
			System.out.println("from ClientBean2: serviceBean: " + System.identityHashCode(serviceBean));
		}
	}

	public class ServiceBean {

	}
}
