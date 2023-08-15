package spring.mvc.com.xml.controller.xmlConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class _1_StartSpringMvcTest extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView startTest=new ModelAndView("hello");
		String message =" Welcome to Spring MVC Using XML Configuration";
		startTest.addObject("message", message);
		return null;
	}

}
