package spring.core.xml.xmlConfig.classes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringApplicationContextListener implements ServletContextListener {
    @Override
public void contextInitialized(ServletContextEvent sce) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("A1pplicationContext.xml");

    sce.getServletContext().setAttribute("applicationContextData", ac);            
}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
