package spring.mvc.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import spring.mvc.com.annotations.LoginInterceptor;
import spring.mvc.com.annotations._11_CustomHttpMessageConverter;

@Configuration
@ComponentScan(basePackages = { "spring.mvc.com.annotations" })
@EnableWebMvc /*
				 * [dding this annotation to a @Configuration class imports the Spring MVC
				 * configuration from WebMvcConfigurationSupport which is the main class
				 * providing the configuration behind the MVC Java config.]
				 */
public class MyWebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	@Autowired
	LoginInterceptor loginInterceptor;

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new _11_CustomHttpMessageConverter.ReportConverter());
	}

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		System.out.println("-- context refreshed --");
		System.out.println("context: " + event.getApplicationContext());

		handlerAdapter.getMessageConverters().stream().forEach(System.out::println);
		System.out.println("-------");
	}

	@EventListener
	public void handleEvent(RequestHandledEvent e) {
		System.out.println("-- RequestHandledEvent --");
		System.out.println(e);
	}

	
	@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
		registry.addInterceptor(loginInterceptor).addPathPatterns("/handlerInterceptor/**");
		}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// commenting next line, setViewClass, as by
		// default the resolver's view is the same
		// viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
