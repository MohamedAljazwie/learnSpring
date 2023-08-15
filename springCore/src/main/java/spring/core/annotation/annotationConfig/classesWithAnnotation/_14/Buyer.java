package spring.core.annotation.annotationConfig.classesWithAnnotation._14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Buyer {
    @Autowired
    private OrderService orderService;

    public void buySomething() {
        orderService.placeOrder("Laptop");
    }
}