/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.controller.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.com.jdbc.Employee;
import spring.mvc.com.jdbc.EmployeeService;

/**
 *
 * @author MohamedSayed
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//    public ModelAndView employee() {
//        return new ModelAndView("employeeform", "command", new Employee());
//    }
//
//    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
//    public ModelAndView addemployee(@ModelAttribute("command") Employee employee, ModelMap model) {
//        model.addAttribute("emolyee", employee);
//        return new ModelAndView("employeedetails", model);
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("command") Employee employee,
            BindingResult result) {
//        Employee employee = prepareModel(Employee);
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/add.html");
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView listEmployees() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employees", employeeService.listEmployees());
        return new ModelAndView("employeesList", model);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addEmployee(@ModelAttribute("command") Employee employeee,
            BindingResult result) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employees", employeeService.listEmployees());
        return new ModelAndView("addEmployee", model);
    }

    
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView editEmployee(@ModelAttribute("command") Employee employee,
            BindingResult result) {
        employeeService.delete(employee);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employee", null);
        model.put("employees", employeeService.listEmployees());
        return new ModelAndView("addEmployee", model);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@ModelAttribute("command") Employee employee,
            BindingResult result) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employee", employeeService.getEmployee(employee.getEmployeeId()));
        model.put("employees", employeeService.listEmployees());
        return new ModelAndView("addEmployee", model);
    }

    private Employee prepareModel(Employee Employee) {
        Employee employee = new Employee();
        employee.setCommissionPct(Employee.getCommissionPct());
        employee.setEmail(Employee.getEmail());
        employee.setEmployeeId(Employee.getEmployeeId());
        employee.setFirstName(Employee.getFirstName());
        employee.setHireDate(Employee.getHireDate());
        employee.setLastName(Employee.getLastName());
        employee.setPhoneNumber(Employee.getPhoneNumber());
        employee.setSalary(Employee.getSalary());
        return employee;
    }

    private List<Employee> prepareListofBean(List<Employee> employees) {
        List<Employee> beans = null;
        if (employees != null && !employees.isEmpty()) {
            beans = new ArrayList<Employee>();
            Employee bean = null;
            for (Employee employee : employees) {
                bean = new Employee();
                bean.setCommissionPct(employee.getCommissionPct());
                bean.setEmail(employee.getEmail());
                bean.setEmployeeId(employee.getEmployeeId());
                bean.setFirstName(employee.getFirstName());
                bean.setHireDate(employee.getHireDate());
                bean.setLastName(employee.getLastName());
                bean.setPhoneNumber(employee.getPhoneNumber());
                bean.setSalary(employee.getSalary());
                beans.add(bean);
            }
        }
        return beans;
    }

    private Employee prepareEmployee(Employee employee) {
        Employee bean = new Employee();
        bean.setCommissionPct(employee.getCommissionPct());
        bean.setEmail(employee.getEmail());
        bean.setEmployeeId(employee.getEmployeeId());
        bean.setFirstName(employee.getFirstName());
        bean.setHireDate(employee.getHireDate());
        bean.setLastName(employee.getLastName());
        bean.setPhoneNumber(employee.getPhoneNumber());
        bean.setSalary(employee.getSalary());
        return bean;
    }
}
