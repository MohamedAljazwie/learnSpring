package spring.core.annotation.annotationConfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class _8_SpringBeanLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "predestory")
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public OtherBean otherBean() {
        return new OtherBean("hello from otherBean!");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(_8_SpringBeanLifeCycle.class);

        context.registerShutdownHook();

        System.out.println("-- accessing bean --");
        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();

        System.out.println("-- finished --");
    }
    
    public class MyBean  implements DisposableBean, InitializingBean {
        private OtherBean otherBean;
        public MyBean() {
        	System.out.println("\n\nExecuting MyBean Constructor");
        }

        public void init() {
        	System.out.println("\n\nMy init method is called for MyBean");

        }

        public void predestory() {
        	System.out.println("\n\nMy predestory method is called for MyBean");

        }

        @PostConstruct      
        public void postConstruct() {
            System.out.println("\n\nMy  @PostConstruct    method is called for MyBean");

        }

        @PreDestroy   
        public void PreDestroy() {
            System.out.println("\n\nMy @PreDestroy   method is called for MyBean");

        }

        @Override
        public void destroy() throws Exception {
            System.out.println("\n\nMy destroy method is called for MyBean");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("\n\nMy afterPropertiesSet method is called for MyBean");
        }

        @Autowired
        public void setOtherBean(OtherBean otherBean) {
            System.out.println("setOtherBean(): " + otherBean);
            this.otherBean = otherBean;
        }

        public void doSomething() {
            System.out.println("doSomething()");
        }

    }
    public class OtherBean {
        private String message;

        public OtherBean(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "OtherBean{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }
}
