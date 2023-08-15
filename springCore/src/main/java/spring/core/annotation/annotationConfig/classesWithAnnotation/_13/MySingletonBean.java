package spring.core.annotation.annotationConfig.classesWithAnnotation._13;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MySingletonBean {

    @PostConstruct
    public void init() {
        System.out.println("initializing " +
                this.getClass().getSimpleName());
    }
}