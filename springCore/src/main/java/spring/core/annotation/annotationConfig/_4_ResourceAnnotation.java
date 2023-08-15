package spring.core.annotation.annotationConfig;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *  we can use @Resource instead of using the combination of @Autowire and @Qualifier.
 * @author Mohamed.Aljazwiee
 *
 */
@Configuration
public class _4_ResourceAnnotation {

	@Bean(name = "OrderServiceA")
	public OrderService orderServiceByProvider1() {
		return new OrderServiceImpl1();
	}

	@Bean(name = "OrderServiceB")
	public OrderService orderServiceByProvider2() {
		return new OrderServiceImpl2();
	}

	@Bean
	public OrderServiceClient createClient() {
		return new OrderServiceClient();
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_4_ResourceAnnotation.class);
		OrderServiceClient bean = context.getBean(OrderServiceClient.class);
		bean.showPendingOrderDetails();
	}

	public interface OrderService {

		String getOrderDetails(String orderId);
	}

	public class OrderServiceImpl1 implements OrderService {

		public String getOrderDetails(String orderId) {
			return "Order details from impl 1, for order id=" + orderId;
		}
	}

	public class OrderServiceImpl2 implements OrderService {

		public String getOrderDetails(String orderId) {
			return "Order details from impl 2, for order id=" + orderId;
		}
	}

	public class OrderServiceClient {

		@Resource(name = "OrderServiceA")
		private OrderService orderService;

		public void showPendingOrderDetails() {
			for (String orderId : Arrays.asList("100", "200", "300")) {
				System.out.println(orderService.getOrderDetails(orderId));
			}
		}
	}
}
