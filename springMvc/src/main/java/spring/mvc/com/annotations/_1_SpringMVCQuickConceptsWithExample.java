package spring.mvc.com.annotations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class _1_SpringMVCQuickConceptsWithExample {
	  @RequestMapping(value = "/springMVCQuickStart", method = RequestMethod.GET)
	    public ModelAndView prepareView() {
	        //bind msg variable to a value which our jsp view
	        //will be using=
	        ModelAndView modelAndView=new ModelAndView();
	        modelAndView.addObject("msg", "\"Spring quick start!");
	        modelAndView.setViewName("quickStart");
	        return modelAndView;
	    }
}
