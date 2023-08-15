package spring.core.annotation.annotationConfig.classesWithAnnotation._13;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Lazy
@Service("basic-service")
public class ServiceImplA implements MyService {

    @PostConstruct
    private void init() {
        System.out.println("initializing lazily " +
                this.getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "Message from " + getClass().getSimpleName();
    }
}
