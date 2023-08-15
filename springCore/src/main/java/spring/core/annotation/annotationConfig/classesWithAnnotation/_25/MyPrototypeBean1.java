package spring.core.annotation.annotationConfig.classesWithAnnotation._25;

import java.time.LocalDateTime;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,  proxyMode = ScopedProxyMode.TARGET_CLASS)
//MyPrototypeBeanWithScopedProxyMode
public class MyPrototypeBean1 {
	

    private String dateTimeString = LocalDateTime.now().toString();

    public String getDateTime() {
        return dateTimeString;
    }
}
