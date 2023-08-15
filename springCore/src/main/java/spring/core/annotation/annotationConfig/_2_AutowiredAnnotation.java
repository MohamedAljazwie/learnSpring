package spring.core.annotation.annotationConfig;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class _2_AutowiredAnnotation {
//	@Autowired
//	private static Greeter greeter;
    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }

    public static void main(String... strings) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_2_AutowiredAnnotation.class);
        Greeter greeter = context.getBean(Greeter.class);
        greeter.showGreeting("Joe");
    }
	
	
	private  class Greeter {
	    @Autowired
	    private GreetingService greetingService;
	    
	    @Inject
	    private GreetingService greetingService2;

	    public void showGreeting(String name) {
	        System.out.println("greetingService "+greetingService.getGreeting(name));
	        
	        System.out.println("greetingService2 "+greetingService2.getGreeting(name));
	    }
	}
	
	private class GreetingService {

	    public String getGreeting(String name) {
	        return "Hi there, " + name;
	    }
	}
}
