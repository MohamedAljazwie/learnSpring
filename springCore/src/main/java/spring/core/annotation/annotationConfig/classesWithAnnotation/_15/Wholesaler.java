package spring.core.annotation.annotationConfig.classesWithAnnotation._15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wholesaler {
    @Autowired
    private WholeSaleOrderService wholeSaleOrderService;

    public void buySomethingInBulk() {
        wholeSaleOrderService.placeOrder("Car", 100);
    }
}
