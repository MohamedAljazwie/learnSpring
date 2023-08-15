package spring.core.annotation.annotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
//_7_ImplicitConstructorInjectionInConfigurationAnnotation
public class _7_ImplicitConstructorInjectionIn{
	
	    private Greeter greeter;
	    public _7_ImplicitConstructorInjectionIn() {
	    
	    }
	    public _7_ImplicitConstructorInjectionIn(Greeter greeter) {
	        this.greeter = greeter;
	    }

	    public static void main(String... strings) {
	        AnnotationConfigApplicationContext  context =
	                new AnnotationConfigApplicationContext(_7_ImplicitConstructorInjectionIn.class);

	        _7_ImplicitConstructorInjectionIn appRunner = context.getBean(_7_ImplicitConstructorInjectionIn.class);
	        appRunner.greeter.greet("Joe");
	    }
	    
	    @Component
	    public class Greeter {

	        public void greet(String name){
	            System.out.println("hi there, "+name);
	        }
	    }
	}
