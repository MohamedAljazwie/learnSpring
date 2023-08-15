package spring.core.annotation.annotationConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * When MyEagerBean is loaded, it will cause to initialize all it's dependencies
 * unless we use @Lazy at injection point too. The usage of @Lazy in factory
 * class MyConfig prevents loading bean during 'startup' until it's used first
 * time in the application.
 * 
 * In short:
 * 
 * @Lazy with @Bean (or @Lazy with @Component): don't load eagerly during
 *       application start up, until it's used in the application
 * 
 * @Lazy with @Autowired : don't load during outer class initialization, until
 *       it's first used by the application.
 * 
 * 
 *       How that works? Spring creates and uses a lazy-resolution proxy object
 *       for the injection point (the one annotated with @Autowired and @Lazy)
 *       instead of initializing the object directly.
 * @author Mohamed.Aljazwiee
 *
 */
@Configuration
public class _9_LazyAnnotation {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(_9_LazyAnnotation.class);
		System.out.println("--- container initialized ---");
		MyEagerBean bean = context.getBean(MyEagerBean.class);
		System.out.println("MyEagerBean retrieved from bean factory");
		bean.doSomethingWithLazyBean();
	}

		@Bean
		public MyEagerBean eagerBean() {
			return new MyEagerBean();
		}

		@Bean
		@Lazy
		public MyLazyBean lazyBean() {
			return new MyLazyBean();
		}
	

	public class MyEagerBean {

		@Autowired
		@Lazy
		private MyLazyBean myLazyBean;

		@PostConstruct
		public void init() {
			System.out.println(getClass().getSimpleName() + " has been initialized");
		}

		public void doSomethingWithLazyBean() {
			System.out.println("Using lazy bean");
			myLazyBean.doSomething();
		}
	}

	public class MyLazyBean {

		@PostConstruct
		public void init() {
			System.out.println(getClass().getSimpleName() + " has been initialized");
		}

		public void doSomething() {
			System.out.println("inside lazy bean doSomething()");
		}
	}
}