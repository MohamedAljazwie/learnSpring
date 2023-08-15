package spring.core.annotation.annotationConfig.classesWithAnnotation._25;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MySingletonBean implements ApplicationContextAware {

	
	private ApplicationContext applicationContextAware;

	  public void setApplicationContext(ApplicationContext applicationContextAware) throws BeansException {
	      this.applicationContextAware = applicationContextAware;
	  }
	  
    @Autowired
    private MyPrototypeBean prototypeBean;
    
    @Autowired
    private MyPrototypeBeanWithScopedProxyMode beanWithScopedProxyMode;;
    @Autowired
    private InterfacePrototypeBasedProxy basedProxy;
    
//    
//    @Autowired
//    private ApplicationContext applicationContext;

    public void showMessage(){
        System.out.println("spring container creates MyPrototype Bean from  the singleton bean MySingletonBean only once  "+prototypeBean.getDateTime());

        System.out.println("spring container creates MyPrototype Bean With Scoped ProxyMode from  the singleton bean MySingletonBean many Times   "+beanWithScopedProxyMode.getDateTime());
        System.out.println("spring container creates Interface Prototype Based Proxy from  the singleton bean MySingletonBean many Times   "+basedProxy.getDateTime());

        //        
//        MyPrototypeBean bean = applicationContext.getBean(MyPrototypeBean.class);
//        System.out.println(" get instance of MyPrototypeBean By Using ApplicationContext "+bean.getDateTime());
        
        MyPrototypeBean beanAware = applicationContextAware.getBean(MyPrototypeBean.class);
        System.out.println(" get instance of MyPrototypeBean By Using ApplicationContextAware "+beanAware.getDateTime());
    }
}
