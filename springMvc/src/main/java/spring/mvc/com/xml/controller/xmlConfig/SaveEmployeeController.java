package spring.mvc.com.xml.controller.xmlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SaveEmployeeController extends AbstractController{
    static final Logger logger = Logger.getLogger(SaveEmployeeController.class.toString());

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest var1, HttpServletResponse var2) throws Exception {
		logger.info("run SaveEmployeeController.handleRequestInternal" );

		String empID=var1.getParameter("empID");
		String empName=var1.getParameter("empName");
		String empAge=var1.getParameter("empAge");
		String empSalary=var1.getParameter("empSalary");

Map<String,Map<String,Object>> employees=(Map<String, Map<String, Object>>) var1.getSession().getAttribute("employees");;		
if(employees==null)
		{
			logger.info("employees is empty ==============>"+employees);
			employees=new HashMap();
			var1.getSession().setAttribute("employees", employees);

		
		}
		Map<String,Object>employee=new HashMap<>();
		employee.put("empID", empID);
		employee.put("empName", empName);
		employee.put("empAge", empAge);
		employee.put("empSalary", empSalary);
		employees.put(empID, employee);
		logger.info("employee=====>"+employee);
		logger.info("employees=====>"+employees);
		ModelAndView showEmployees=new ModelAndView("addEmployee");
		
	//	showEmployees.addObject("employees", employees);
		logger.info(" AddEmployeController===>[showEmployees]"+showEmployees);

		return showEmployees;
	}

}
