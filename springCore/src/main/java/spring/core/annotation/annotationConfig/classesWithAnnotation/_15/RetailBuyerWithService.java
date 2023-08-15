package spring.core.annotation.annotationConfig.classesWithAnnotation._15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetailBuyerWithService {
    @Autowired
    private RetailOrderServiceService orderService;

    public void buySomething() {
        orderService.placeOrder("Laptop");
    }
}

