package spring.core.annotation.annotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages= {"spring.core.annotation.annotationConfig.classesWithAnnotation._26,resources"})
public class _26_ResourceLoaderInjection {

	  public static void main(String[] args) throws IOException {
	        new AnnotationConfigApplicationContext(_26_ResourceLoaderInjection.class);
	    }
	

}
