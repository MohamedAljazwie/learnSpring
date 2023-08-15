package spring.core.annotation.annotationConfig;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _3_QualifierAnnotation {
//	@Autowired
//	private static Greeter greeter;
	@Bean
	public GreetingService greetingService() {
		return new GreetingService();
	}

	@Bean
	public GreetingService greetingService2() {
		return new GreetingService();
	}

	@Bean
	public Greeter greeter() {
		return new Greeter();
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				_3_QualifierAnnotation.class);
		Greeter greeter = context.getBean(Greeter.class);
		greeter.showGreeting("Joe");
	}

	private class Greeter {
		@Autowired
		 @Qualifier("greetingService")  // Without it Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private spring.core.annotationConfig._3_QualifierAnnotation$GreetingService spring.core.annotationConfig._3_QualifierAnnotation$Greeter.service; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type [spring.core.annotationConfig._3_QualifierAnnotation$GreetingService] is defined: expected single matching bean but found 2: greetingService2,greetingService
		private GreetingService service;


		public void showGreeting(String name) {
			System.out.println("greetingService " + service.getGreeting(name));

//			System.out.println("greetingService2 " + greetingService2.getGreeting(name));
		}
	}

	private static class GreetingService {
		private static int count = 0;

		public GreetingService() {
			System.out.println(" Initialization  GreetingService Instance  " + ++count);
		}

		public String getGreeting(String name) {
			return  " GreetingService ["+count+"]  Hi there, " + name;
		}
	}
}
