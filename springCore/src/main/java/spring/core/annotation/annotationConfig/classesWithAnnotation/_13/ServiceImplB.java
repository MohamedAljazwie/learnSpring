package spring.core.annotation.annotationConfig.classesWithAnnotation._13;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


@Service
public class ServiceImplB implements MyService {

    @PostConstruct
    private void init(){
        System.out.println("initializing at start up " +
                this.getClass().getSimpleName());
    }
    @Override
    public String getMessage() {
        return "Message from "+getClass().getSimpleName();
    }
}
