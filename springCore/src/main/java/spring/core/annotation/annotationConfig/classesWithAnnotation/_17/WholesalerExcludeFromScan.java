package spring.core.annotation.annotationConfig.classesWithAnnotation._17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ExcludeFromScan
public class WholesalerExcludeFromScan {
    @Autowired
    private WholeSaleOrderServiceExcludeFromScan wholeSaleOrderServiceExcludeFromScan;

    public void buySomethingInBulk() {
        wholeSaleOrderServiceExcludeFromScan.placeOrder("Car", 100);
    }
}
