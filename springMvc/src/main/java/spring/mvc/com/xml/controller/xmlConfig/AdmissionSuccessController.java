/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.controller.xmlConfig;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import spring.mvc.com.xml.model.Student;

public class AdmissionSuccessController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       
        String name =hsr.getParameter("username");
        Student student=new Student();
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
        student.setDate("08/01/2018");
        student.setMobile(Long.valueOf(hsr.getParameter("mobile")));
        String[] skills=(String[]) hsr.getParameterValues("skills");
        student.setSkills(Arrays.asList(skills));
        
        ModelAndView view=new ModelAndView("admissionSuccess");
       view.addObject("student", student);
        return view;
        
    }
    
    
    
}
