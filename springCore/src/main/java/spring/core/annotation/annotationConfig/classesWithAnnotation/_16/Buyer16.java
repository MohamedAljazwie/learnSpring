package spring.core.annotation.annotationConfig.classesWithAnnotation._16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Buyer16 {
    @Autowired
    private OrderService_IncludeInScan orderService_IncludeInScan;

    public void buySomething() {
        orderService_IncludeInScan.placeOrder("Laptop");
    }
}