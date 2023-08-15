package spring.mvc.com.xml.controller.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		String message="Hello Spring MVC how r u ";
              return new ModelAndView("hello","message",message);
		
	}
}
