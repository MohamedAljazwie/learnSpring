package spring.core.annotation.annotationConfig;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.core.annotation.annotationConfig.classesWithAnnotation._25.*;

/**
 * The problem is: spring container creates the singleton bean MySingletonBean only once, 
 * and thus only gets one opportunity to inject the dependencies into it.
 *  The container cannot provide MySingletonBean with a new instance of MyPrototypeBean every time one is needed
 *  -------------------Solution to the problem ---------------------
Following are the solutions to the above problems

    1-Inject ApplicationContext bean into MySingletonBean to get instance of MyPrototypeBean.
    2-Lookup method injection. This approach involves in dynamic bytecode generation.
    3-Using Scoped Proxy. (example here and here).
    4-Using JSR 330 Provider<T> injected by Spring.
    5-Injecting Spring's ObjectProvider<T>..
    6-By using Java 8 Functions (example).
 * @author Mohamed.Aljazwiee
 *
 */
@Configuration
@ComponentScan(basePackages="spring.core.annotation.annotationConfig.classesWithAnnotation._25")
public class _25_InjectingShortLevelScopeInLongerLevelScope {

   

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(_25_InjectingShortLevelScopeInLongerLevelScope.class);
        MySingletonBean bean = context.getBean(MySingletonBean.class);
        System.out.println(" \n\n   Test Short Level Instance in Long Level Instance    ");
        bean.showMessage();
        Thread.sleep(10000);
       System.out.println(" \n\n   Test Short Level Instance in Long Level Instance   Again ");
        bean = context.getBean(MySingletonBean.class);
        bean.showMessage();
    }
    

   
}

