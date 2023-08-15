package spring.core.annotation.annotationConfig.classesWithAnnotation._24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientBean {
	@Autowired
    private final ServiceBean serviceBean;

    private ClientBean(ServiceBean serviceBean) {
        this.serviceBean = serviceBean;
    }

    public void doSomething() {
        System.out.println("doing something with: " + serviceBean);
    }
}