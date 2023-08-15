/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.controller.annotations;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

import spring.mvc.com.xml.model.Address;

/**
 *
 * @author msayed
 */
@Controller
@RequestMapping("hello")
public class AdmissionController {
   
    @RequestMapping(value = "admissionForm.html",method = RequestMethod.GET)
    public  ModelAndView getadmissionForm()
    {
        
        return new ModelAndView("admissionForm");
    }
    @RequestMapping(value = "admissionSuccess.html",method =RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@ModelAttribute("student") spring.mvc.com.jdbc.EmployeeService student,@ModelAttribute("address") Address address,BindingResult result)
    {
        if(result.hasErrors())
        {
           return new ModelAndView("admissionForm");
        }
       // student.setAddress(address);
        ModelAndView view=new ModelAndView("admissionSuccess");
   
        
        return view;
    }
    
    @ModelAttribute
    public void addingComminOBject(Model model)
    {
        model.addAttribute("message","STUDENT ADMISSION FORM");
    }
}
