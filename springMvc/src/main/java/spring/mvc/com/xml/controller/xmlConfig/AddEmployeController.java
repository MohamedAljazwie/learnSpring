package spring.mvc.com.xml.controller.xmlConfig;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.AbstractController;


public class AddEmployeController extends AbstractController {
	Integer fInteger;
    static final Logger logger = Logger.getLogger(AddEmployeController.class.toString());

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	logger.info("run AddEmployeController.handleRequestInternal" );
		ModelAndView addEmployees=new ModelAndView("addEmployee");
		logger.info(" AddEmployeController===>[addEmployees]"+addEmployees);

		return addEmployees;
	}

	

}
