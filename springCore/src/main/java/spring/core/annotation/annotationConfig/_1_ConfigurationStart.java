package spring.core.annotation.annotationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _1_ConfigurationStart {
	 private int counter;
@Autowired
	 private Greeter greeter;
//	    @Bean
	    public Greeter greeterWithoutBean() {
	        return new Greeter();
	    }

	    
	    @Bean
	    public Greeter greeterWithBean() {
	        return new Greeter();
	    }

	    public static void main(String... strings) {
	        AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(_1_ConfigurationStart.class);
	        _1_ConfigurationStart greeter = context.getBean(_1_ConfigurationStart.class);
	        
	       
	        
	        greeter.greeterWithoutBean().sayHi("Joe1");
	        greeter.greeterWithoutBean().sayHi("Joe2");
	        
	        greeter.greeterWithBean().sayHi("jazwiee1");
	        greeter.greeterWithBean().sayHi("jazwiee2");
	        
	        Greeter greeter2 = context.getBean(Greeter.class);  // without annotation   @Bean it will not intialize
	        greeter2.sayHi(" idemia ");
	        
	        Greeter greeter3 = (Greeter)context.getBean("greeterWithBean");  // without annotation   @Bean it will not intialize
	        greeter3.sayHi(" greeterWithBean ");
	        
	        Greeter greeter4= (Greeter)context.getBean("greeter");  
	        greeter4.sayHi(" greeterWithBean "); 
	    }

	    public static class Greeter {
	    	static int counter=0;
	    	public Greeter() {
	    		   System.out.println(" new Instance, " +  ++counter);
			}
	        public void sayHi(String name) {
	            System.out.println("Hi there, " + name +" instance "+counter);
	        }

	    }
	}
