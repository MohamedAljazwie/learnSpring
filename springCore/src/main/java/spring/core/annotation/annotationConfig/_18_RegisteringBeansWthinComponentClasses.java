package spring.core.annotation.annotationConfig;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
/**
 * Full @Configuration vs 'lite' @Beans mode?
When @Bean methods are declared within classes that are not annotated with 
@Configuration they are referred to as being processed in a 'lite' mode. For example, 
bean methods declared in a @Component or even in a plain old class will be considered 'lite'.

Unlike full @Configuration, lite @Bean methods cannot easily declare inter-bean dependencies.
 Usually one @Bean method should not invoke another @Bean method when operating in 'lite' mode.

Only using @Bean methods within @Configuration 
classes is a recommended approach of ensuring that 'full' mode is always used. 
This will prevent the same @Bean method from accidentally being invoked multiple times 
and helps to reduce subtle bugs that can be hard to track down when operating in 'lite' mode.
 * @author Mohamed.Aljazwiee
 *
 */
@Configuration
@ComponentScan(basePackageClasses = _18_RegisteringBeansWthinComponentClasses.class, useDefaultFilters = false,
                    includeFilters = {@ComponentScan.Filter(
                                        type = FilterType.ASSIGNABLE_TYPE,
                                        value = _18_RegisteringBeansWthinComponentClasses.TestBean.class)})
public class _18_RegisteringBeansWthinComponentClasses {



    public static void main (String[] args) {
        AnnotationConfigApplicationContext context =
                            new AnnotationConfigApplicationContext(
                            		_18_RegisteringBeansWthinComponentClasses.class);
        MyBean bean = context.getBean(MyBean.class);
        System.out.println(bean);

        //accessing multiple times
        bean = context.getBean(MyBean.class);
        System.out.println(bean);

        /*this will return a new instance because @Component methods are not
        * CGLIB proxied*/
        TestBean testBean = context.getBean(TestBean.class);
        System.out.println(testBean.myBean());
    }

    @Component
     static class TestBean {
        @Bean
        public MyBean myBean () {
            return new MyBean();
        }
    }
    
    public static class MyBean {
    	private  static int count=0;
    	public MyBean() {
    		System.out.println("Initalize MyBean ["+ ++count+" ]");
		}
    }
}
