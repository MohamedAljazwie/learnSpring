package spring.core.annotation.annotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.core.annotation.annotationConfig.classesWithAnnotation._14.Buyer;
import spring.core.annotation.annotationConfig.classesWithAnnotation._14.OrderService;


/**
 * Spring - Using Filters To Customize Scanning with @ComponentScan
[Last Updated: May 6, 2021]

By default, @ComponentScan scans all classes which are annotated with @Component,
 @Repository, @Service, @Controller, @Configuration, 
 or a custom annotation that itself is annotated with @Component.

We can modify and extend this behavior by applying custom filters via @ComponentScan#includeFilters 
or @ComponentScan#excludeFilters attributes.

Following shows ComponentScan annotation snippet along with include/exclude filter attributes 
and their type (i.e. Filter) definition:
 * @author Mohamed.Aljazwiee
 *
 */

@Configuration
@ComponentScan(basePackages="spring.core.annotation.annotationConfig.classesWithAnnotation._14"
, includeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,value= {OrderService.class}))
public class _14_ComponentScanNonComponentIncludeFilters {



    public static void main(String... strings) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(_14_ComponentScanNonComponentIncludeFilters.class);
        System.out.println("-- Spring container started and is ready --");
        Buyer buyer = context.getBean(Buyer.class);
        buyer.buySomething();
    }
}
