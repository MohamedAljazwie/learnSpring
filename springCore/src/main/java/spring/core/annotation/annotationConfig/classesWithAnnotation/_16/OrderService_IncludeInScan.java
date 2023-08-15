package spring.core.annotation.annotationConfig.classesWithAnnotation._16;
@IncludeInScan
public class OrderService_IncludeInScan {

    public void placeOrder(String item) {
        System.out.printf("Retail order placed. Item: %s%n", item);
    }
}