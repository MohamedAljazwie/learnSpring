package spring.mvc.com.xml.controller.xmlConfig;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class EditEmployeeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
String empID=arg0.getParameter("empID");
Map<String,Map<String,Object>> employees=(Map<String, Map<String, Object>>) arg0.getSession().getAttribute("employees");;		
Map<String,Object> employee=employees.get(empID);
ModelAndView editEmployee=new ModelAndView("addEmployee");
editEmployee.addObject("employee",employee);
		return editEmployee;
	}

}
