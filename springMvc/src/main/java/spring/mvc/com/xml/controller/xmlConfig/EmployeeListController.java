package spring.mvc.com.xml.controller.xmlConfig;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.AbstractController;


public class EmployeeListController extends AbstractController {
    static final Logger logger = Logger.getLogger(EmployeeListController.class.toString());
    
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	logger.info("run EmployeeListController.handleRequestInternal" );
		ModelAndView listEmployees=new ModelAndView("employeesList");
		logger.info(" EmployeeListController===>[listEmployees]"+listEmployees);

		return listEmployees;
	}

	

}
