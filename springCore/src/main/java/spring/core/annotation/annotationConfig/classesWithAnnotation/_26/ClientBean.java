package spring.core.annotation.annotationConfig.classesWithAnnotation._26;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ClientBean {
    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:myResource.txt");
        File file = resource.getFile();
        String s = new String(Files.readAllBytes(file.toPath()));
        System.out.println(s);
    }
}