package spring.core.annotation.annotationConfig;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *  @Primary indicates that a particular bean should be given preference when multiple beans are candidates to be autowired to a single-valued dependency. 
 *  If exactly one 'primary' bean exists among the candidates,
 *   it will be the autowired value.
 * @author Mohamed.Aljazwiee
 *
 */

@Configuration
public class _5_PrimaryAnnotation {

    @Bean(autowire = Autowire.BY_TYPE)
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public Dao daoA() {
        return new DaoA();
    }

    @Primary
    @Bean
    public Dao daoB() {
        return new DaoB();
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(_5_PrimaryAnnotation.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder("122");

    }
    public interface Dao {
        void saveOrder(String orderId);
    }
    
    public class DaoA implements Dao {

        @Override
        public void saveOrder(String orderId) {
            System.out.println("DaoA Order saved " + orderId);
        }
    }
    
    public class DaoB implements Dao {

        @Override
        public void saveOrder(String orderId) {
            System.out.println("DaoB Order saved " + orderId);
        }
    }
    
    public class OrderService {

        private Dao dao;

        public void placeOrder(String orderId) {
            System.out.println("placing order " + orderId);
            dao.saveOrder(orderId);
        }

        public void setDao(Dao dao) {
            this.dao = dao;
        }
    }
}
