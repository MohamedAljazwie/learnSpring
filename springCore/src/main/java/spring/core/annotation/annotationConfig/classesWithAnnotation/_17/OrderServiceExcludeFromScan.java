package spring.core.annotation.annotationConfig.classesWithAnnotation._17;

import org.springframework.stereotype.Service;

@Service
@ExcludeFromScan
//WholeSaleOrderServiceExcludeFromScan
public class OrderServiceExcludeFromScan {

    public void placeOrder(String item, int quantity) {
        if (quantity < 10) {
            throw new IllegalArgumentException(
                    "Quantity must be more than 10  for a wholesale order");
        }
        System.out.printf("Wholesale order placed. Item: %s Quantity: %s%n", item, quantity);
    }
}