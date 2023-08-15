/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.xml.controller.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MohamedSayed
 */
@Controller
public class HelloWorldController {
 
  
   public String sayHelloWorld(ModelMap model) {
     model.addAttribute("message", "Spring 3.0 MVC Framework Hello World Example!");
     model.addAttribute("auther", "DineshOnJava");
     return "hello";
   }
}
