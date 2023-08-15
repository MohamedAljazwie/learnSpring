package spring.mvc.com.xml.controller.xmlConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msayed
 */
public class indexController implements org.springframework.web.servlet.mvc.Controller{

    @Override
    public org.springframework.web.servlet.ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       hsr1.sendRedirect("welcome.jsp");
        return null;
       
    }

    
}
