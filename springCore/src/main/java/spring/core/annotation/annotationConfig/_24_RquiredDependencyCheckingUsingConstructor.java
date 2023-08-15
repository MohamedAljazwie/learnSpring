package spring.core.annotation.annotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.annotation.annotationConfig.classesWithAnnotation._24.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages="spring.core.annotation.annotationConfig.classesWithAnnotation._24")

public class _24_RquiredDependencyCheckingUsingConstructor {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(_24_RquiredDependencyCheckingUsingConstructor.class);
        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();
    }


  
}
