package spring.mvc.com.xml.controller.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController1 {

	@RequestMapping("/helloPage/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name){
		String message="Hello Spring MVC how r u "+name;
		return new ModelAndView("hellopage","message",message);
	}
}
