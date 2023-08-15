package spring.core.annotation.annotationConfig.classesWithAnnotation._17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetailBuyer {
    @Autowired
    private RetailOrderService orderService;

    public void buySomething() {
        orderService.placeOrder("Laptop");
    }
}