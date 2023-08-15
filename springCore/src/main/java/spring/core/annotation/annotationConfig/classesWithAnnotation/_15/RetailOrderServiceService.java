package spring.core.annotation.annotationConfig.classesWithAnnotation._15;


import org.springframework.stereotype.Service;

@Service
public class RetailOrderServiceService {

    public void placeOrder(String item) {
        System.out.printf("Retail order placed. Item: %s%n", item);
    }
}